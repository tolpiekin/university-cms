package ua.com.foxminded.volodymyrtolpiekin.universitycms.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private Date validFrom;
    private Date validTill;

    @OneToMany(mappedBy = "timetable")
    private List<DayOfWeek> days;

    public Timetable() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timeTable = (Timetable) o;
        return id.equals(timeTable.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", start=" + validFrom +
                ", end=" + validTill +
                ", days=" + days +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }
}
