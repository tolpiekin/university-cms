package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Timetable;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TimetableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }


    public Optional<Timetable> addTimetable(Timetable timetable){
        timetableRepository.save(timetable);
        return timetableRepository.findById(timetable.getId());
    }

    public Optional<Timetable> findById(Long id){
        try {
            return Optional.of(timetableRepository.findById(id)).orElseThrow(()->new TimetableNotFoundException(id));
        }
        catch (TimetableNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Timetable Not Found", exc);
        }
    }

    public List<Timetable> findAll(){
        return timetableRepository.findAll();
    }

    public Optional<Timetable> update(Long id, Timetable timetable){
        timetable.setId(id);
        timetableRepository.save(timetable);
        return timetableRepository.findById(id);
    }

    public void deleteById(Long id){
        try {
            Optional.of(timetableRepository.findById(id)).orElseThrow(()->new TimetableNotFoundException(id));
        }
        catch (TimetableNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Timetable Not Found", exc);
        }
        timetableRepository.deleteById(id);
    }
}
