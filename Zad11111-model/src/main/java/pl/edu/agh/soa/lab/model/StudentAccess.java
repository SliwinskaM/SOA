package pl.edu.agh.soa.lab.model;

import org.apache.commons.io.FileUtils;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class StudentAccess {
    private List<Student> students = new ArrayList<>();

    public String hello(String name) {
        return "Hello " + name;
    }

    public List<Student> getAllStudents() {
        return students;
    }


    public Student getStudent(Integer id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }



    public List<Student> listFilterStudents(String name) {
        List<Student> filteredStudents = new ArrayList<>();
        if (name != null) {
            for (Student student : students) {
                if (student.getName().equals(name)) {
                    filteredStudents.add(student);
                }
            }
        }
        return filteredStudents;
    }


    public void addStudent(Integer id, String name, String faculty, List<String> courses, String avatarPath) throws IOException {
        Student newStudent = new Student(id, name, faculty, courses);
        if (! (avatarPath == null)) {
            if (!avatarPath.isEmpty()) {
                byte[] fileContent = FileUtils.readFileToByteArray(new File(avatarPath));
                newStudent.setAvatar(Base64.getEncoder().encode(fileContent));
            }
        }
        students.add(newStudent);
    }


    public void editStudent(Integer id, String name, String faculty, List<String> courses, String avatarPath) throws IOException {
        Student editedStudent = getStudent(id);
        editedStudent.setName(name);
        editedStudent.setFaculty(faculty);
        editedStudent.setCourses(courses);
        if (! (avatarPath == null)) {
            if (!avatarPath.isEmpty()) {
                byte[] fileContent = FileUtils.readFileToByteArray(new File(avatarPath));
                editedStudent.setAvatar(Base64.getEncoder().encode(fileContent));
            }
        }
    }


    public void deleteStudent(Integer id) {
        Student toDelete = getStudent(id);
        students.remove(toDelete);
    }

    public void deleteAllStudents() { students.clear(); }


}
