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


    public Timetable addTimetable(Timetable timetable){
        return timetableRepository.save(timetable);
    }

    public Timetable findById(Long id){
        return Optional.of(timetableRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Timetable Not Found")).get();
    }

    public List<Timetable> findAll(){
        return timetableRepository.findAll();
    }

    public Timetable update(Timetable timetable){
        return timetableRepository.save(timetable);
    }

    public void deleteById(Long id){
        Optional.of(timetableRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Timetable Not Found"));
        timetableRepository.deleteById(id);
    }
}
