package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.DayOfWeek;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.DayOfWeekRepository;

import java.util.List;

@Service
public class DayOfWeekServiceImpl implements DayOfWeekService {

    private final DayOfWeekRepository dayOfWeekRepository;


    public DayOfWeekServiceImpl(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    @Override
    public DayOfWeek addDayOfWeek(DayOfWeek dayOfWeek){
        return dayOfWeekRepository.save(dayOfWeek);
    }

    @Override
    public DayOfWeek findById(Long id){
        return dayOfWeekRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "DayOfWeek not found"));
    }

    @Override
    public List<DayOfWeek> findAll(){
        return dayOfWeekRepository.findAll();
    }

    @Override
    public DayOfWeek update(DayOfWeek dayOfWeek){
        return dayOfWeekRepository.save(dayOfWeek);
    }

    @Override
    public void deleteById(Long id){
        findById(id);
        dayOfWeekRepository.deleteById(id);
    }
}
