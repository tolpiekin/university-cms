package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.stereotype.Service;
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
        return Optional.of(tutorRepository.save(tutor));
    }

    public Optional<Tutor> findById(Long id){
        return tutorRepository.findById(id);
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

    }
}
