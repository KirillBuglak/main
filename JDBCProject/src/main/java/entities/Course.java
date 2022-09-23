package entities;

import enums.Type;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private Type type;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;
    @Column(name = "students_count", nullable = true)
    private Integer studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    private double pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscriptions",
    joinColumns = {
            @JoinColumn(name = "course_id")},
    inverseJoinColumns = {
            @JoinColumn(name = "student_id")
    })
    List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "entities.Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", type=" + type +
                ", studentsCount=" + studentsCount +
                ", price=" + price +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}