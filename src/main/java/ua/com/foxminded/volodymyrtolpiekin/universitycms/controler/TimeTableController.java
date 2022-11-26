package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TimetableRepository;

@Controller
public class TimeTableController {

    @Autowired
    TimetableRepository timetableRepository;

    @GetMapping("/timetables")
    private String showTimetablesList(Model model) {
        model.addAttribute("timetables", timetableRepository.findAll());
        return "timetables";
    }
}
