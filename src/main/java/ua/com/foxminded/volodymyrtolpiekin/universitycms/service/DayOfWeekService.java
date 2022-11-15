package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public DayOfWeekService(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public Optional<DayOfWeek> addDayOfWeek(DayOfWeek dayOfWeek){
        dayOfWeekRepository.save(dayOfWeek);
        return dayOfWeekRepository.findById(dayOfWeek.getId());
    }

    public Optional<DayOfWeek> findById(Long id){
        try {
            return Optional.of(dayOfWeekRepository.findById(id).orElseThrow(()-> new DayOfWeekNotFoundException(id)));
        }
        catch (DayOfWeekNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DayOfWeek Not Found", exc);
        }
    }

    public List<DayOfWeek> findAll(){
        return dayOfWeekRepository.findAll();
    }

    public Optional<DayOfWeek> update(Long id, DayOfWeek dayOfWeek){
        dayOfWeek.setId(id);
        return Optional.of(dayOfWeekRepository.save(dayOfWeek));
    }

    public void deleteById(Long id){
        try {
            Optional.of(findById(id)).orElseThrow(()->new DayOfWeekNotFoundException(id));
        }
        catch(DayOfWeekNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DayOfWeek Not Found", exc);
        }
        dayOfWeekRepository.deleteById(id);
    }
}
