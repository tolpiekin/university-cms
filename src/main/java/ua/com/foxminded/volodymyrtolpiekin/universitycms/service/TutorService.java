package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.TutorDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;

import java.util.List;

public interface TutorService {
    Tutor addTutor(Tutor tutor);

    Tutor findById(Long id);

    List<Tutor> findAll();

    Tutor update(Tutor tutor);

    void deleteById(Long id);

    List<TutorDTO> getAll();

    TutorDTO createTutor(TutorDTO tutorDTO);

    TutorDTO getById(Long tutorId);

    TutorDTO update(TutorDTO tutorDTO);
}
