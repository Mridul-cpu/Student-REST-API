package tda.springframework.studentapiproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tda.springframework.studentapiproject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
