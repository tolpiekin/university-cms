package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Timetable;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TimetableRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TimetableService;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {

    private final TimetableRepository timetableRepository;

    public TimetableServiceImpl(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    @Override
    public Timetable addTimetable(Timetable timetable){
        return timetableRepository.save(timetable);
    }

    @Override
    public Timetable findById(Long id){
        return timetableRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Timetable Not Found"));
    }

    @Override
    public List<Timetable> findAll(){
        return timetableRepository.findAll();
    }

    @Override
    public Timetable update(Timetable timetable){
        return timetableRepository.save(timetable);
    }

    public void deleteById(Long id){
        findById(id);
        timetableRepository.deleteById(id);
    }
}
