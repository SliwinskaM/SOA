package pl.edu.agh.soa.lab.api;


import io.swagger.annotations.*;
import org.hibernate.validator.constraints.NotEmpty;
import pl.edu.agh.soa.lab.jwt.JWTTokenNeeded;
import pl.edu.agh.soa.lab.model.Student;
import pl.edu.agh.soa.lab.model.StudentAccess;
import pl.edu.agh.soa.lab.model.StudentProto;
import pl.edu.agh.soa.lab.dao.StudentDAO;


import javax.ejb.EJB;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/student")
@Api(value = "Students API")
public class MainRestService {

//    private static final StudentAccess studentAcc = new StudentAccess();
    @EJB
    StudentDAO studentDAO;
//    @EJB
//    FacultyDAO facultyDAO;

//    @GET
//    @Path("/getStudent")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation("Returns student with given ID")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Znaleziono studenta"),
//            @ApiResponse(code = 404, message = "Nie znaleziono")
//    })
//    public Response getStudent(@NotNull @Min(value = 1, message = "Id cannot be smaller than 1") @QueryParam("id") Integer id) {
//        Student foundStudent = studentAcc.getStudent(id);
//        if (foundStudent == null) {
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity("Nie znaleniono").build();
//        }
//        else {
//            return Response.status(Response.Status.OK)
//                    .entity(foundStudent).build();
//        }
//    }

    @GET
    @Path("/getAllStudents")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation("Returns list of all students")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Znaleziono",
            response = Student.class,
            responseContainer = "List"),
            @ApiResponse(code = 404, message = "Nie znaleziono")
    })
    public Response getAllStudenst() {
        List<Student> allStudents = studentDAO.getAllStudents();
        if (allStudents.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nie znaleniono").build();
        }
        else {
            return Response.status(Response.Status.OK)
                    .entity(allStudents).build();
        }
    }

//    @GET
//    @Path("/listFilteredStudents")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Znaleziono",
//                    response = Student.class,
//                    responseContainer = "List"),
//            @ApiResponse(code = 404, message = "Nie znaleziono")
//    })
//    public Response getFilteredStudents(@NotNull @NotEmpty @QueryParam("name") String name) {
//        List<Student> filteredStudents = studentAcc.listFilterStudents(name);
//        if (filteredStudents.isEmpty()) {
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity("Nie znaleniono dopasowań").build();
//        }
//        else {
//            return Response.status(Response.Status.OK)
//                    .entity(filteredStudents).build();
//        }
//    }
//
//
//    @POST
//    @JWTTokenNeeded
//    @Path("/addStudent")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation("Adds student to the database")
//    @ApiResponses({
//            @ApiResponse(code = 201, message = "Dodano"),
//            @ApiResponse(code = 409, message = "Nie dodano")
//    })
//    public Response addStudent(@NotNull @Min(value = 1, message = "Id cannot be smaller than 1") @QueryParam("id") Integer id,
//                               @NotNull @NotEmpty @QueryParam("name") String name,
//                               @NotNull @NotEmpty @QueryParam("faculty") String faculty,
//                               @NotNull @QueryParam("courses") List<String> courses,
//                               @QueryParam("avatarPath") String avatarPath) {
//        try{
//            studentAcc.addStudent(id, name, faculty, courses, avatarPath);
//            return Response.status(Response.Status.CREATED)
//                    .entity("Dodano").build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.CONFLICT)
//                    .entity("Nie dodano").build();
//        }
//    }
//
//    @PUT
//    @JWTTokenNeeded
//    @Path("/editStudent")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation("Updates student with given id")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Zedytowano"),
//            @ApiResponse(code = 404, message = "Nie zedytowano")
//    })
//    public Response editStudent(@NotNull @Min(value = 1, message = "Id cannot be smaller than 1") @QueryParam("id") Integer id,
//                                @NotNull @NotEmpty @QueryParam("name") String name,
//                                @NotNull @NotEmpty @QueryParam("faculty") String faculty,
//                                @NotNull @QueryParam("courses") List<String> courses,
//                                @QueryParam("avatarPath") String avatarPath) {
//        try{
//            studentAcc.editStudent(id, name, faculty, courses, avatarPath);
//            return Response.status(Response.Status.OK)
//                    .entity("Zedytowano").build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.NOT_MODIFIED) //powinny się zgadzać?
//                    .entity("Nie zedytowano").build();
//        }
//    }
//
//    @DELETE
//    @JWTTokenNeeded
//    @Path("/deleteStudent")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Usunięto"),
//            @ApiResponse(code = 404, message = "Usuwanie nie powiodło się")
//    })
//    public Response deleteStudent(@NotNull @Min(value = 1, message = "Id cannot be smaller than 1") @QueryParam("id") Integer id) {
//        try{
//            studentAcc.deleteStudent(id);
//            return Response.status(Response.Status.OK)
//                    .entity("Usunięto").build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.NOT_MODIFIED)
//                    .entity("Usuwanie nie powiodło się").build();
//        }
//    }
//
//    @DELETE
//    @JWTTokenNeeded
//    @Path("/deleteAllStudents")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteAllStudents() {
//        try{
//            studentAcc.deleteAllStudents();
//            return Response.status(Response.Status.OK)
//                    .entity("Usunięto").build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.NOT_MODIFIED)
//                    .entity("Usuwanie nie powiodło się").build();
//        }
//    }
//
//    @GET
//    @Path("/getProto")
//    @Produces("application/protobuf")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Znaleziono studenta"),
//            @ApiResponse(code = 404, message = "Nie znaleziono")
//    })
//    public Response getStudentProto(@NotNull @Min(value = 1, message = "Id cannot be smaller than 1") @QueryParam("id") Integer id) {
//        Student student = studentAcc.getStudent(id);
//        if (student == null) {
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity("Nie znaleniono").build();
//        }
//        else {
//            var studentBuilder = StudentProto.Student.newBuilder();
//            studentBuilder.setId(student.getId()).setName(student.getName()).setFaculty(student.getFaculty()).
//                    addAllCourses(student.getCourses()); //.setAvatar(ByteString.copyFrom(student.getAvatar()));
//            var newStudent = studentBuilder.build();
//            return Response.status(Response.Status.OK)
//                    .entity(newStudent).build();
//        }
//    }
}
//
