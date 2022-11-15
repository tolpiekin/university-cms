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

    public Optional<Tutor> addTutor(Tutor tutor){
        tutorRepository.save(tutor);
        return tutorRepository.findById(tutor.getId());
    }

    public Optional<Tutor> findById(Long id){
        try {
            return Optional.of(tutorRepository.findById(id)).orElseThrow(()->new TutorNotFoundException(id));
        }
        catch (TutorNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor Not Found", exc);
        }
    }

    public List<Tutor> findAll(){
        return tutorRepository.findAll();
    }

    public Optional<Tutor> update(Long id, Tutor tutor){
        tutor.setId(id);
        tutorRepository.save(tutor);
        return tutorRepository.findById(id);
    }

    public void deleteById(Long id){
        try {
            Optional.of(tutorRepository.findById(id)).orElseThrow(()->new TutorNotFoundException(id));
        }
        catch (TutorNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor Not Found", exc);
        }
    }
}
