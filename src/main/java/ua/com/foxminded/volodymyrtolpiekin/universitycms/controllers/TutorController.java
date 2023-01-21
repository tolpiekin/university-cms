package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.TutorDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TutorService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tutors")
@RequiredArgsConstructor
public class TutorController {
    private final TutorService tutorService;

    @GetMapping
    public List<TutorDTO> showTutorsList() {
        return tutorService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TutorDTO createTutor(@RequestBody TutorDTO tutorDTO) {
        return tutorService.createTutor(tutorDTO);
    }

    @DeleteMapping(path = "{tutorId}")
    public void deleteTutor(@PathVariable("tutorId") Long tutorId) {
        tutorService.deleteById(tutorId);
    }

    @GetMapping(path="{tutorId}")
    public TutorDTO getTutor(@PathVariable("tutorId") Long tutorId) {
        return tutorService.getById(tutorId);
    }

    @PutMapping
    public TutorDTO updateTutor(@RequestBody TutorDTO tutorDTO) {
        return tutorService.update(tutorDTO);
    }

}
