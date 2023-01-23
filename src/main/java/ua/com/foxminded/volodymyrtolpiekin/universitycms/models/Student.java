package ua.com.foxminded.volodymyrtolpiekin.universitycms.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String name;
    @ManyToOne
    private Group group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", group=" + group +
                '}';
    }
}
