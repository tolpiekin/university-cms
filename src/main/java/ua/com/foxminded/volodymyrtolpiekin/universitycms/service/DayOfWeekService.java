package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.DayOfWeek;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.DayOfWeekRepository;

import java.util.List;

@Service
public class DayOfWeekService {

    private final DayOfWeekRepository dayOfWeekRepository;


    public DayOfWeekService(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public DayOfWeek addDayOfWeek(DayOfWeek dayOfWeek){
        return dayOfWeekRepository.save(dayOfWeek);
    }

    public DayOfWeek findById(Long id){
        return dayOfWeekRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "DayOfWeek not found"));
    }

    public List<DayOfWeek> findAll(){
        return dayOfWeekRepository.findAll();
    }

    public DayOfWeek update(DayOfWeek dayOfWeek){
        return dayOfWeekRepository.save(dayOfWeek);
    }

    public void deleteById(Long id){
        findById(id);
        dayOfWeekRepository.deleteById(id);
    }
}
