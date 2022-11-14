package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.DayOfWeek;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.DayOfWeekRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DayOfWeekService {

    private final DayOfWeekRepository dayOfWeekRepository;

    @Autowired
    public DayOfWeekService(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public Optional<DayOfWeek> addDayOfWeek(DayOfWeek dayOfWeek){
        return Optional.of(dayOfWeekRepository.save(dayOfWeek));
    }

    public Optional<DayOfWeek> findById(Long id){
        return dayOfWeekRepository.findById(id);
    }

    public List<DayOfWeek> findAll(){
        return dayOfWeekRepository.findAll();
    }

    public Optional<DayOfWeek> update(Long id, DayOfWeek dayOfWeek){
        dayOfWeek.setId(id);
        return Optional.of(dayOfWeekRepository.save(dayOfWeek));
    }

    public void deleteById(Long id){
        dayOfWeekRepository.deleteById(id);
    }
}
