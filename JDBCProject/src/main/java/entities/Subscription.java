package entities;

import jakarta.persistence.*;
import keys.SubscKey;

import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscKey id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;
    @Column(name = "subscription_date")
    private Date date;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
