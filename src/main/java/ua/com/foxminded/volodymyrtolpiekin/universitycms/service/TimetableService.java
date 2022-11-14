package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Timetable;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TimetableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }


    public Optional<Timetable> addTimetable(Timetable timetable){
        return Optional.of(timetableRepository.save(timetable));
    }

    public Optional<Timetable> findById(Long id){
        return timetableRepository.findById(id);
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
        timetableRepository.deleteById(id);
    }
}
