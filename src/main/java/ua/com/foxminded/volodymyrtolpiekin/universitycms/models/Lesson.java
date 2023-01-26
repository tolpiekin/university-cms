package ua.com.foxminded.volodymyrtolpiekin.universitycms.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private Date start;
    private String location;
    private int hours;

    @OneToOne
    @JoinColumn
    private Group group;

    @OneToOne
    @JoinColumn
    private Course course;

    @OneToOne
    @JoinColumn
    private Tutor tutor;

    @ManyToOne
    private DayOfWeek dayOfWeek;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id.equals(lesson.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", start=" + start +
                ", location='" + location + '\'' +
                ", hours=" + hours +
                ", group=" + group +
                ", course=" + course +
                ", tutor=" + tutor +
                '}';
    }
}