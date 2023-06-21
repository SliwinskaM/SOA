
package pl.edu.agh.soa.lab;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa.lab package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudent_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "addStudentResponse");
    private final static QName _DeleteAllStudents_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "deleteAllStudents");
    private final static QName _DeleteAllStudentsResponse_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "deleteAllStudentsResponse");
    private final static QName _DeleteStudent_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "deleteStudent");
    private final static QName _DeleteStudentResponse_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "deleteStudentResponse");
    private final static QName _EditStudent_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "editStudent");
    private final static QName _EditStudentResponse_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "editStudentResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "getAllStudentsResponse");
    private final static QName _GetStudent_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "getStudent");
    private final static QName _GetStudentResponse_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "getStudentResponse");
    private final static QName _Hello_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "helloResponse");
    private final static QName _ListFilterStudents_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "listFilterStudents");
    private final static QName _ListFilterStudentsResponse_QNAME = new QName("http://service.lab.soa.agh.edu.pl/", "listFilterStudentsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa.lab
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteAllStudents }
     * 
     */
    public DeleteAllStudents createDeleteAllStudents() {
        return new DeleteAllStudents();
    }

    /**
     * Create an instance of {@link DeleteAllStudentsResponse }
     * 
     */
    public DeleteAllStudentsResponse createDeleteAllStudentsResponse() {
        return new DeleteAllStudentsResponse();
    }

    /**
     * Create an instance of {@link DeleteStudent }
     * 
     */
    public DeleteStudent createDeleteStudent() {
        return new DeleteStudent();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

    /**
     * Create an instance of {@link EditStudent }
     * 
     */
    public EditStudent createEditStudent() {
        return new EditStudent();
    }

    /**
     * Create an instance of {@link EditStudentResponse }
     * 
     */
    public EditStudentResponse createEditStudentResponse() {
        return new EditStudentResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link ListFilterStudents }
     * 
     */
    public ListFilterStudents createListFilterStudents() {
        return new ListFilterStudents();
    }

    /**
     * Create an instance of {@link ListFilterStudentsResponse }
     * 
     */
    public ListFilterStudentsResponse createListFilterStudentsResponse() {
        return new ListFilterStudentsResponse();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteAllStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "deleteAllStudents")
    public JAXBElement<DeleteAllStudents> createDeleteAllStudents(DeleteAllStudents value) {
        return new JAXBElement<DeleteAllStudents>(_DeleteAllStudents_QNAME, DeleteAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteAllStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "deleteAllStudentsResponse")
    public JAXBElement<DeleteAllStudentsResponse> createDeleteAllStudentsResponse(DeleteAllStudentsResponse value) {
        return new JAXBElement<DeleteAllStudentsResponse>(_DeleteAllStudentsResponse_QNAME, DeleteAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "deleteStudent")
    public JAXBElement<DeleteStudent> createDeleteStudent(DeleteStudent value) {
        return new JAXBElement<DeleteStudent>(_DeleteStudent_QNAME, DeleteStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "deleteStudentResponse")
    public JAXBElement<DeleteStudentResponse> createDeleteStudentResponse(DeleteStudentResponse value) {
        return new JAXBElement<DeleteStudentResponse>(_DeleteStudentResponse_QNAME, DeleteStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "editStudent")
    public JAXBElement<EditStudent> createEditStudent(EditStudent value) {
        return new JAXBElement<EditStudent>(_EditStudent_QNAME, EditStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "editStudentResponse")
    public JAXBElement<EditStudentResponse> createEditStudentResponse(EditStudentResponse value) {
        return new JAXBElement<EditStudentResponse>(_EditStudentResponse_QNAME, EditStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFilterStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListFilterStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "listFilterStudents")
    public JAXBElement<ListFilterStudents> createListFilterStudents(ListFilterStudents value) {
        return new JAXBElement<ListFilterStudents>(_ListFilterStudents_QNAME, ListFilterStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFilterStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListFilterStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.lab.soa.agh.edu.pl/", name = "listFilterStudentsResponse")
    public JAXBElement<ListFilterStudentsResponse> createListFilterStudentsResponse(ListFilterStudentsResponse value) {
        return new JAXBElement<ListFilterStudentsResponse>(_ListFilterStudentsResponse_QNAME, ListFilterStudentsResponse.class, null, value);
    }

}
