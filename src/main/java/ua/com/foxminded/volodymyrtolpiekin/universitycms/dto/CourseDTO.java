package ua.com.foxminded.volodymyrtolpiekin.universitycms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private Long groupId;
    private Long tutorId;

}
