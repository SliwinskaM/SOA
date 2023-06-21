package pl.edu.agh.soa.lab.client;

import org.apache.commons.io.FileUtils;
import pl.edu.agh.soa.lab.model.Student;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.edu.agh.soa.lab.model.StudentProto;
import pl.edu.agh.soa.lab.protobuf.StudentMessageWriter;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class ClientREST {

    private ResteasyClient resteasyClient;
    private String username = "";
    private String password = "";
    private static String token = null;

    public ClientREST() {
        this.resteasyClient = new ResteasyClientBuilder().build();
    }

    public void login(String username, String password) {
        this.username = username;
        this.password = password;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/Zad11111-web/api/authent/login");
        Form form = new Form();
        form.param("login", this.username);
        form.param("password", this.password);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
        MultivaluedMap<String, String> headers = response.getStringHeaders();
        token = headers.getFirst("Authorization");
    }

    private Student getStudent(Integer id) {
        Student foundStudent = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/Zad11111-web/api/student/getStudent/?id=" + id);
        Response response = target.request().get();
        int status = response.getStatus();
        if (status == 200) {
            foundStudent = response.readEntity(Student.class);
            System.out.println("Udało się znaleźć, kod odpowiedzi:" + status);
        } else {
            System.out.println("Nie udało się znależć, kod błędu:" + status);
        }
        response.close();
        return foundStudent;
    }

    private List<Student> getAllStudents() {
        List<Student> students = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/Zad11111-web/api/student/getAllStudents");
        Response response = target.request().get();
        int status = response.getStatus();
        if (status == 200) {
            students = response.readEntity(new GenericType<List<Student>>() {});
            System.out.println("Udało się znaleźć, kod odpowiedzi:" + status);
        } else {
            System.out.println("Nie udało się znależć, kod błędu:" + status);
        }
        response.close();
        return students;
    }

    private List<Student> getFilteredStudents(String name) {
        List<Student> students = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/Zad11111-web/api/student/listFilteredStudents/?name=" + name);
        Response response = target.request().get();
        int status = response.getStatus();
        if (status == 200) {
            students = response.readEntity(new GenericType<List<Student>>() {});
            System.out.println("Udało się znaleźć, kod odpowiedzi:" + status);
        } else {
            System.out.println("Nie udało się znależć, kod błędu:" + status);
        }
        response.close();
        return students;
    }


    private void addStudent(Integer id, String name, String faculty, List<String> courses, String avatarPath) {
        String targetString = "http://localhost:8080/Zad11111-web/api/student/addStudent/?id=" + id + "&name=" + name + "&faculty=" + faculty;
        for (String course : courses) {
            targetString += "&courses=" + course;
        }
        targetString += "&avatarPath=" + avatarPath;
        ResteasyWebTarget target = resteasyClient.target(targetString);
        Response response = target.request().header("Authorization", token).post(Entity.entity(new Student(), MediaType.APPLICATION_JSON_TYPE));
        int status = response.getStatus();
        if (status == 201) {
            System.out.println("Udało się utworzyć, kod odpowiedzi:" + status);
        } else {
            System.out.println("Nie udało się utworzyć, kod błędu:" + status);
        }
        response.close();
    }

    private void editStudent(Integer id, String name, String faculty, List<String> courses, String avatarPath) {
        String targetString = "http://localhost:8080/Zad11111-web/api/student/editStudent/?id=" + id + "&name=" + name + "&faculty=" + faculty;
        for (String course : courses) {
            targetString += "&courses=" + course;
        }
        targetString += "&avatarPath=" + avatarPath;
        ResteasyWebTarget target = resteasyClient.target(targetString);
        Response response = target.request().header("Authorization", token).put(Entity.entity(new Student(), MediaType.APPLICATION_JSON_TYPE));
        int status = response.getStatus();
        if (status == 200) {
            System.out.println("Udało się zedytować, kod odpowiedzi:" + status);
        } else {
            System.out.println("Nie udało się zedytować, kod błędu:" + status);
        }
        response.close();
    }

    private void deleteStudent(Integer id) {
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/Zad11111-web/api/student/deleteStudent/?id=" + id);
        Response response = target.request().header("Authorization", token).delete();
        int status = response.getStatus();
        if (status == 200) {
            System.out.println("Udało się usunąć, kod odpowiedzi:" + status);
        } else {
            System.out.println("Nie udało się usunąć, kod błędu:" + status);
        }
        response.close();
    }

    private void deleteAllStudents() {
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/Zad11111-web/api/student/deleteAllStudents");
        Response response = target.request().header("Authorization", token).delete();
        int status = response.getStatus();
        if (status == 200) {
            System.out.println("Udało się usunąć, kod odpowiedzi:" + status);
        } else {
            System.out.println("Nie udało się usunąć, kod błędu:" + status);
        }
        response.close();
    }

    private StudentProto.Student getStudentProto(Integer id) {
        StudentProto.Student newStudent = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/Zad11111-web/api/student/getProto/?id=" + id)
                .register(StudentMessageWriter.class);
        Response response = target.request().get();
        int status = response.getStatus();
        if (status == 200) {
            newStudent = response.readEntity(StudentProto.Student.class);
            System.out.println("Udało się znaleźć, kod odpowiedzi:" + status);
        } else {
            System.out.println("Nie udało się znależć, kod błędu:" + status);
        }
        response.close();
        return newStudent;
    }

    private void printStudent(Student student) {
        System.out.print(student.getId() + ". " + student.getName() + ", faculty: " + student.getFaculty() + " courses: ");
        for (String course: student.getCourses()) {
            System.out.print(course + " ");
        }
        System.out.println(", avatar code:" + student.getAvatar());
    }

    private void closeConnection() {
        if(!resteasyClient.isClosed())
            resteasyClient.close();
    }

    public static void main(String[] args) throws IOException {
        ClientREST client = new ClientREST();
        client.login("msliw", "123");

        System.out.println("Dodawanie studentów");
        client.addStudent(21, "Daniel Bakowski", "AiR", Arrays.asList("PWiR", "AT", "ZL"), "C:/Users/gosia/Desktop/SOA/Zad11111/avatarIn.png");
        client.addStudent(22, "Monika Kalinowska", "MBM", Arrays.asList("KH", "DF", "CV"), "C:/Users/gosia/Desktop/SOA/Zad11111/avatarIn2.png");
        client.addStudent(23, "Weronika Wąsowska", "AiR", Arrays.asList("PWiR", "AT", "ZL"), "C:/Users/gosia/Desktop/SOA/Zad11111/avatarIn3.png");
        client.addStudent(24, "Ignacy Wojski", "AiR", Arrays.asList("PWiR", "AT", "ZL"), "C:/Users/gosia/Desktop/SOA/Zad11111/avatarIn.png");

        System.out.println("\nWszyscy studenci:");
        List<Student> allStudents = client.getAllStudents();
        for (Student student: allStudents) {
            client.printStudent(student);
        }

        System.out.println("\nStudenci wg imienia Monika Kalinowska:");
        List<Student> studentsFiltered = client.getFilteredStudents("Monika Kalinowska");
        for (Student student: studentsFiltered) {
            client.printStudent(student);
        }

        System.out.println("\nEdycja studenta 21.");
        client.editStudent(21, "Dawid Bakowski", "MBM", Arrays.asList("PWiR", "AT", "HY"), "C:/Users/gosia/Desktop/SOA/Zad11111/avatarIn.png");

        System.out.println("Student 21:");
        Student foundStudent = client.getStudent(21);
        client.printStudent(foundStudent);

        System.out.println("\nUsuwanie studenta 21.");
        client.deleteStudent(21);

        System.out.println("\nWszyscy studenci:");
        List<Student> allStudents2 = client.getAllStudents();
        for (Student student: allStudents2) {
            client.printStudent(student);
        }

        System.out.println("\nStudent 22 w ProtoBuf:");
        System.out.println(client.getStudentProto(22));

        System.out.println("\nAvatar przykładowego studenta do pliku wyjściowego avatarOutREST.png.");
//        Get avatar
        byte[] avatar = client.getStudent(23).getAvatar();
//        Decoding
        byte[] decodedBytes = Base64.getDecoder().decode(avatar);
//        Check if image is right
        FileUtils.writeByteArrayToFile(new File("C:/Users/gosia/Desktop/SOA/Zad11111 v2/avatarOutREST.png"), decodedBytes);


        System.out.println("\nUsuwanie wszystkich studentów.");
        client.deleteAllStudents();
        System.out.println("\nZamykanie połączenia.");
        client.closeConnection();
    }
}
