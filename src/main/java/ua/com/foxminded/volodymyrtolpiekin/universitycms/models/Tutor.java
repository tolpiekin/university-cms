package ua.com.foxminded.volodymyrtolpiekin.universitycms.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tutors")
public class Tutor extends Person {
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "tutor")
    private List<Course> courses;

    public Tutor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tutor tutor = (Tutor) o;
        return id.equals(tutor.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", courses=" + courses +
                '}';
    }
}
