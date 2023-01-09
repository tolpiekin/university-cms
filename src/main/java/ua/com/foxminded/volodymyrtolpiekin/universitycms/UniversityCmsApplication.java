package ua.com.foxminded.volodymyrtolpiekin.universitycms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.mapper.CourseMapper;

@SpringBootApplication
public class UniversityCmsApplication {

	@Bean
	public CourseMapper courseMapper() {
		return new CourseMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(UniversityCmsApplication.class, args);
	}

}
