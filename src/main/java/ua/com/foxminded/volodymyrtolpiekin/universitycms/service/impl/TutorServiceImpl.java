package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.TutorDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TutorRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TutorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;
    private final ModelMapper mapper;

    public TutorServiceImpl(TutorRepository tutorRepository, ModelMapper mapper) {
        this.tutorRepository = tutorRepository;
        this.mapper = mapper;
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

    @Override
    public List<TutorDTO> getAll() {
        return findAll()
                .stream()
                .map(tutor -> mapper.map(tutor, TutorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TutorDTO createTutor(TutorDTO tutorDTO) {
        Tutor tutor = mapper.map(tutorDTO, Tutor.class);
        return mapper.map(addTutor(tutor), TutorDTO.class);
    }

    @Override
    public TutorDTO readById(Long tutorId) {
        return mapper.map(findById(tutorId), TutorDTO.class);
    }

    @Override
    public TutorDTO update(TutorDTO tutorDTO) {
        Tutor tutor = update(mapper.map(tutorDTO, Tutor.class));
        return mapper.map(tutor, TutorDTO.class);
    }
}
