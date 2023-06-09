package ua.com.foxminded.volodymyrtolpiekin.universitycms.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private static final String API_COURSES = "/api/courses/**";
    private static final String API_GROUPS = "/api/groups/**";
    private static final String API_STUDENTS = "/api/students/**";
    private static final String API_TUTORS = "/api/tutors/**";
    private static final String API_SCHEDULES = "/api/schedules/**";

    private final UserDetailsServiceImpl userDetailsService;
    private final AuthEntryPointJwt unauthorizedHandler;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, AuthEntryPointJwt unauthorizedHandler) {
        this.userDetailsService = userDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/sign-in").permitAll()
                .antMatchers("/api/auth/sign-up").hasAnyRole("STUFF", "ADMIN")
                .antMatchers("/courses").anonymous()
                .antMatchers(HttpMethod.GET,(new String[] {API_COURSES, API_GROUPS, API_STUDENTS, API_TUTORS, API_SCHEDULES})).hasAnyRole("STUDENT", "TUTOR", "STUFF", "ADMIN")
                .antMatchers(HttpMethod.DELETE,(new String[] {API_COURSES, API_GROUPS, API_STUDENTS, API_TUTORS, API_SCHEDULES})).hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,(new String[] {API_COURSES, API_GROUPS, API_STUDENTS, API_TUTORS, API_SCHEDULES})).hasAnyRole("STUFF", "ADMIN")
                .antMatchers(HttpMethod.PUT,(new String[] {API_COURSES, API_GROUPS, API_STUDENTS, API_TUTORS, API_SCHEDULES})).hasAnyRole("STUFF", "ADMIN")
                .antMatchers(HttpMethod.PUT,("/api/courses/assign-teacher/**")).hasAnyRole("STUFF")
                .antMatchers(HttpMethod.PUT,("/api/courses/assign-group/**")).hasAnyRole("STUFF")
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .antMatchers("/api/test/**").permitAll()
                .anyRequest()
                .authenticated();

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
