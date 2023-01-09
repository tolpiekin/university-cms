package ua.com.foxminded.volodymyrtolpiekin.universitycms.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.CourseDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.GroupService;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TutorService;

public class CourseMapper {

    @Autowired
    private GroupService groupService;

    @Autowired
    private TutorService tutorService;

    public CourseDTO toDto(Course course) {
        Long id = course.getId();
        String name = course.getName();
        Long groupId = (course.getGroup() == null) ? 0: course.getGroup().getId();
        Long tutorId = (course.getTutor() == null) ? 0: course.getTutor().getId();

        return new CourseDTO(id, name, groupId, tutorId);
    }

    public Course toCourse(CourseDTO courseDTO) {
        Course course = new Course();
        if (courseDTO.getId() != null)
            course.setId(courseDTO.getId());
        if (courseDTO.getName() != null)
            course.setName(courseDTO.getName());
        if (courseDTO.getGroupId() != null)
            course.setGroup(groupService.findById(courseDTO.getGroupId()));
        if ( courseDTO.getTutorId() != null)
            course.setTutor(tutorService.findById(courseDTO.getTutorId()));

        return course;
    }
}
