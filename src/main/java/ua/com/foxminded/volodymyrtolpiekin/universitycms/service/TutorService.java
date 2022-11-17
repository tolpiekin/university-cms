package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TutorRepository;

import java.util.List;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public Tutor addTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    public Tutor findById(Long id){
        return tutorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor Not Found"));
    }

    public List<Tutor> findAll(){
        return tutorRepository.findAll();
    }

    public Tutor update(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    public void deleteById(Long id){
        findById(id);
        tutorRepository.deleteById(id);
    }
}
