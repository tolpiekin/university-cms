package ua.com.foxminded.volodymyrtolpiekin.universitycms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private Long groupId;
}
