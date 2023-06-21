
package pl.edu.agh.soa.lab;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Main", targetNamespace = "http://service.lab.soa.agh.edu.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Main {


    /**
     * 
     * @param courses
     * @param name
     * @param id
     * @param avatar
     * @param faculty
     */
    @WebMethod(action = "ActionEdit")
    @RequestWrapper(localName = "editStudent", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.EditStudent")
    @ResponseWrapper(localName = "editStudentResponse", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.EditStudentResponse")
    public void editStudent(
        @WebParam(name = "id", targetNamespace = "")
        Integer id,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "faculty", targetNamespace = "")
        String faculty,
        @WebParam(name = "courses", targetNamespace = "")
        List<String> courses,
        @WebParam(name = "avatar", targetNamespace = "")
        byte[] avatar);

    /**
     * 
     */
    @WebMethod(action = "ActionDeleteAll")
    @RequestWrapper(localName = "deleteAllStudents", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.DeleteAllStudents")
    @ResponseWrapper(localName = "deleteAllStudentsResponse", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.DeleteAllStudentsResponse")
    public void deleteAllStudents();

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "ActionHello")
    @WebResult(name = "ResultHello", targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.HelloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param arg0
     */
    @WebMethod(action = "ActionDelete")
    @RequestWrapper(localName = "deleteStudent", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.DeleteStudent")
    @ResponseWrapper(localName = "deleteStudentResponse", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.DeleteStudentResponse")
    public void deleteStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param id
     * @return
     *     returns pl.edu.agh.soa.lab.Student
     */
    @WebMethod(action = "ActionGet")
    @WebResult(name = "ResultGet", targetNamespace = "")
    @RequestWrapper(localName = "getStudent", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.GetStudent")
    @ResponseWrapper(localName = "getStudentResponse", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.GetStudentResponse")
    public Student getStudent(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param courses
     * @param name
     * @param id
     * @param avatar
     * @param faculty
     */
    @WebMethod(action = "ActionAdd")
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.AddStudentResponse")
    public void addStudent(
        @WebParam(name = "id", targetNamespace = "")
        Integer id,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "faculty", targetNamespace = "")
        String faculty,
        @WebParam(name = "courses", targetNamespace = "")
        List<String> courses,
        @WebParam(name = "avatar", targetNamespace = "")
        byte[] avatar);

    /**
     * 
     * @param name
     * @return
     *     returns java.util.List<pl.edu.agh.soa.lab.Student>
     */
    @WebMethod(action = "ActionList")
    @WebResult(name = "ResultList", targetNamespace = "")
    @RequestWrapper(localName = "listFilterStudents", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.ListFilterStudents")
    @ResponseWrapper(localName = "listFilterStudentsResponse", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.ListFilterStudentsResponse")
    public List<Student> listFilterStudents(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @return
     *     returns java.util.List<pl.edu.agh.soa.lab.Student>
     */
    @WebMethod(action = "ActionGetAll")
    @WebResult(name = "ResultGetAll", targetNamespace = "")
    @RequestWrapper(localName = "getAllStudents", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.GetAllStudents")
    @ResponseWrapper(localName = "getAllStudentsResponse", targetNamespace = "http://service.lab.soa.agh.edu.pl/", className = "pl.edu.agh.soa.lab.GetAllStudentsResponse")
    public List<Student> getAllStudents();

}
