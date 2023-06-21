package pl.edu.agh.soa.lab.service;

import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.edu.agh.soa.lab.model.Student;
import pl.edu.agh.soa.lab.dao.StudentDAO;

//import javax.annotation.security.PermitAll;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;



@SecurityDomain("other")
@WebContext(contextRoot = "/Main", urlPattern = "/*", authMethod = "BASIC", transportGuarantee = "NONE")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@Stateless
@WebService
public class Main {
    @EJB
    StudentDAO studentDAO;
//@EJB
//    FacultyDAO facultyDAO;

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private List<Student> students = new ArrayList<>();

    @WebMethod(action = "ActionHello")
    @WebResult(name = "ResultHello")
    @PermitAll
    public String hello(@WebParam(name = "name") String name) {
        LOGGER.info("Hello, param: " + name);
        return "Hello " + name;
    }

    @WebMethod(action = "ActionGetAll")
    @WebResult(name = "ResultGetAll")
    @PermitAll
    public List<Student> getAllStudents() {
        return students;
    }

    @WebMethod(action = "ActionGet")
    @WebResult(name = "ResultGet")
    @PermitAll
    public Student getStudent(@WebParam(name = "id") Integer id) {
        LOGGER.info("Get Student with id: " + id);
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @WebMethod(action = "ActionList")
    @WebResult(name = "ResultList")
    @PermitAll
    public List<Student> listFilterStudents(@WebParam(name = "name") String name) {; //, @WebParam(name = "faculty") String faculty) {
        LOGGER.info("Get Student with filters: name - " + name); // + "faculty - " + faculty);

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

    @WebMethod(action = "ActionAdd")
    @PermitAll
    public void addStudent(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name,
                           @WebParam(name = "faculty") String faculty, @WebParam(name = "courses") List<String> courses,
                           @WebParam(name = "avatar") byte[] avatar) {
        Student newStudent = new Student();
        newStudent.setId(id);
        newStudent.setName(name);
        newStudent.setFaculty(faculty);
        newStudent.setCourses(courses);
        if (avatar != null) {
            newStudent.setAvatar(Base64.getEncoder().encode(avatar));
        }
        students.add(newStudent);
    }

    @WebMethod(action = "ActionEdit")
    @PermitAll
    public void editStudent(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name,
                            @WebParam(name = "faculty") String faculty, @WebParam(name = "courses") List<String> courses,
                            @WebParam(name = "avatar") byte[] avatar) {
        Student editedStudent = getStudent(id);
        editedStudent.setName(name);
        editedStudent.setFaculty(faculty);
        editedStudent.setCourses(courses);
        if (avatar != null) {
            editedStudent.setAvatar(Base64.getEncoder().encode(avatar));
        }
    }

    @WebMethod(action = "ActionDeleteAll")
    @PermitAll
    public void deleteAllStudents() { students.clear(); }


    @WebMethod(action = "ActionDelete")
    @PermitAll
    public void deleteStudent(Integer id) {
        Student toDelete = getStudent(id);
        students.remove(toDelete);
    }
}
