package pl.edu.agh.soa.lab;

import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class ClientSOAP {
    public static void main(String[] args) throws IOException {
        MainService service = new MainService();
        Main servicePort = service.getMainPort();
        BindingProvider prov = (BindingProvider)servicePort;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "user");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "123");

        System.out.println("Usuwanie wszystkich studentów");
        servicePort.deleteAllStudents();

        System.out.println("Dodawanie studentów");
        servicePort.addStudent(1, "Anna Jeniec", "AiR", Arrays.asList("TO", "SOA", "AT"), null);
        servicePort.addStudent(2, "Patrycja Mak", "AiR", Arrays.asList("ZIPK", "SOA", "AT"), null);
        servicePort.addStudent(3, "Denis Bąk", "AiR", Arrays.asList("PWiR", "AT", "ZL"), null);
        servicePort.addStudent(4, "Wojciech Jagodziński", "AiR", Arrays.asList("FLZ", "SOA"), null);

        System.out.println("Wszyscy studenci:");
        List<Student> students = servicePort.getAllStudents();
        for (Student student: students) {
            System.out.print(student.getId() + ". " + student.getName() + ", faculty: " + student.getFaculty() + " courses: ");
            for (String course: student.getCourses().courses) {
                System.out.print(" " + course);
            }
            System.out.println("");
        }


        System.out.println("Studenci wg imienia:");
        List<Student> studentsFiltered = servicePort.listFilterStudents("Denis Bąk");
        for (Student student: studentsFiltered) {
            System.out.print(student.getId() + ". " + student.getName() + ", faculty: " + student.getFaculty() + " courses: ");
            for (String course: student.getCourses().courses) {
                System.out.print(" " + course);
            }
        }

        System.out.print("\n");
        System.out.println("Edytowanie Studenta 1:");
        servicePort.editStudent(1, "Hanna Jeniec", "MS", Arrays.asList("MT", "SD", "AT"), null);
        Student editedStudent = servicePort.getStudent(1);
        System.out.print(editedStudent.getId() + ". " + editedStudent.getName() + ", faculty: " + editedStudent.getFaculty() + " courses: ");
        for (String course: editedStudent.getCourses().courses) {
            System.out.print(" " + course);
        }

        System.out.println("");
        System.out.println("Dodawanie studenta z avatarem");
//        Getting image to Base64
        byte[] fileContent = FileUtils.readFileToByteArray(new File("C:/Users/gosia/Desktop/SOA/Zad11111/avatarIn.png"));

//        Add image to user
        servicePort.addStudent(5, "Ava Tar", "AiR", Arrays.asList("HGF", "SOA"), fileContent);

//        Get avatar
        byte[] avatar = servicePort.getStudent(5).getAvatar();
        System.out.println("Pobieranie avataru");
//        Decoding
        byte[] decodedBytes = Base64.getDecoder().decode(avatar);
//        Check if image is right
        FileUtils.writeByteArrayToFile(new File("C:/Users/gosia/Desktop/SOA/Zad11111/avatarOutSOAP.png"), decodedBytes);

    }
}
