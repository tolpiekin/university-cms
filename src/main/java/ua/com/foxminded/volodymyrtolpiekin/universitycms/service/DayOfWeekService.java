package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.DayOfWeek;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.DayOfWeekRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DayOfWeekService {

    private final DayOfWeekRepository dayOfWeekRepository;


    public DayOfWeekService(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public DayOfWeek addDayOfWeek(DayOfWeek dayOfWeek){
        return dayOfWeekRepository.save(dayOfWeek);
    }

    public Optional<DayOfWeek> findById(Long id){
        return Optional.of(dayOfWeekRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "DayOfWeek not found"));
    }

    public List<DayOfWeek> findAll(){
        return dayOfWeekRepository.findAll();
    }

    public DayOfWeek update(DayOfWeek dayOfWeek){
        return dayOfWeekRepository.save(dayOfWeek);
    }

    public void deleteById(Long id){
        Optional.of(findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "DayOfWeek Not Found"));
        dayOfWeekRepository.deleteById(id);
    }
}
