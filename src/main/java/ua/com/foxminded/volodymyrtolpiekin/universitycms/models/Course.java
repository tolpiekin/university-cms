package ua.com.foxminded.volodymyrtolpiekin.universitycms.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @SequenceGenerator(
            name = "courses_sequence",
            sequenceName = "courses_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "courses_sequence"
    )
    private Long id;
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "course")
    private List<Topic> topics;

    @ManyToOne
    private Tutor tutor;

}
