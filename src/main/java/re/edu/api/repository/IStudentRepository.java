package re.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.api.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
