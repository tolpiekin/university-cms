package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.DayOfWeekRepository;

@Controller
public class DayOfWeekController {
    private final DayOfWeekRepository dayOfWeekRepository;

    public DayOfWeekController(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    @GetMapping("/daysofweek")
    public String showDayOfWeekList(Model model) {
        model.addAttribute("daysofweek", dayOfWeekRepository.findAll());
        return "daysofweek";
    }
}
