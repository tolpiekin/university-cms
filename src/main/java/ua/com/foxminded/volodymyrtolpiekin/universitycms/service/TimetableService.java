package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Timetable;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TimetableRepository;

import java.util.List;

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
        return timetableRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Timetable Not Found"));
    }

    public List<Timetable> findAll(){
        return timetableRepository.findAll();
    }

    public Timetable update(Timetable timetable){
        return timetableRepository.save(timetable);
    }

    public void deleteById(Long id){
        findById(id);
        timetableRepository.deleteById(id);
    }
}
