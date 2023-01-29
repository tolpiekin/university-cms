package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.CourseService;

import java.util.List;

@RestController
@RequestMapping(path = "/courses")
@RequiredArgsConstructor
public class CoursesAnonymousController {

    private final CourseService courseService;
    @GetMapping
    public List<String> showCoursesList(Model model) {
        return courseService.getAllNames();
    }

}
