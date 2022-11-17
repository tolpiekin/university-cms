package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public Tutor addTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    public Optional<Tutor> findById(Long id){
        return Optional.of(tutorRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor Not Found"));
    }

    public List<Tutor> findAll(){
        return tutorRepository.findAll();
    }

    public Tutor update(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    public void deleteById(Long id){
        Optional.of(tutorRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor Not Found"));
        tutorRepository.deleteById(id);
    }
}
