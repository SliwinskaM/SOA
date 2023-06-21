package pl.edu.agh.soa.lab.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(propOrder = {"id", "name", "faculty", "courses", "avatar"})
public class Student {
    private Integer id;
    private String name;
    private String faculty;
    private List<String> courses;
    private byte[] avatar = new byte[]{};

    public Student() {}
    public Student(Integer id, String name, String faculty, List<String> courses) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.courses = courses;
    }

    public Student(Integer id, String name, String faculty, List<String> courses, byte[] avatar) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.courses = courses;
        this.avatar = avatar;
    }

    @XmlElement //(name = "id")
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @XmlElement //(name = "name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @XmlElement //(name = "faculty")
    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    @XmlElementWrapper(name = "courses")
    @XmlElement //(name = "course")
    public List<String> getCourses() { return courses; }
    public void setCourses(List<String> courses) { this.courses = courses; }


    @XmlElement //(name = "avatar")
    public byte[] getAvatar() { return avatar; }
    public void setAvatar(byte[] avatar) { this.avatar = avatar; }


}
