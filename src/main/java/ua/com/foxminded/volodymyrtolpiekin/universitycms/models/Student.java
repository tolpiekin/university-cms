package ua.com.foxminded.volodymyrtolpiekin.universitycms.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "students")
public class Student extends Person{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    private Group group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

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
