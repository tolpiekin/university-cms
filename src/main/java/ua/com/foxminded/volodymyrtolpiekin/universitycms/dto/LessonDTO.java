package ua.com.foxminded.volodymyrtolpiekin.universitycms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.DayOfWeek;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonDTO {
    private Long id;
    private Date start;
    private String location;
    private int hours;
    private Long groupId;
    private Long courseId;
    private Long tutorId;
    private Long dayOfWeekId;
}
