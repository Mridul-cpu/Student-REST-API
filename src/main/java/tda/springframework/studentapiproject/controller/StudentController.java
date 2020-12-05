package tda.springframework.studentapiproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.springframework.studentapiproject.model.Student;
import tda.springframework.studentapiproject.service.StudentService;

import static org.springframework.http.ResponseEntity.status;

@RequestMapping("/api/v1/student")
@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStudents(){
        return status(HttpStatus.OK).body(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return status(HttpStatus.OK).body(studentService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Student student){
        studentService.add(student);
        return status(HttpStatus.CREATED).body("Student Added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Student student){
        studentService.update(id, student);
        return status(HttpStatus.OK).body("Student updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        studentService.delete(id);
        return status(HttpStatus.OK).body("Student updated successfully");
    }
}
