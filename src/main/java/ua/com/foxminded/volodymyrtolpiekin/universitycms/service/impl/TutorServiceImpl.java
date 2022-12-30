package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TutorRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TutorService;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor addTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor findById(Long id){
        return tutorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor Not Found"));
    }

    @Override
    public List<Tutor> findAll(){
        return tutorRepository.findAll();
    }

    @Override
    public Tutor update(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    @Override
    public void deleteById(Long id){
        findById(id);
        tutorRepository.deleteById(id);
    }
}
