package ua.com.foxminded.volodymyrtolpiekin.universitycms.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class DayOfWeek {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private Date date;

    @OneToMany(mappedBy = "dayOfWeek")
    private List<Lesson> lessons;

    @ManyToOne
    private Timetable timetable;

    public DayOfWeek() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Timetable getTimeTable() {
        return timetable;
    }

    public void setTimeTable(Timetable timetable) {
        this.timetable = timetable;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayOfWeek dayOfWeek = (DayOfWeek) o;
        return id.equals(dayOfWeek.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "id=" + id +
                ", date=" + date +
                ", lessons=" + lessons +
                '}';
    }
}
