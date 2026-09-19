package re.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.api.model.StudentEnrollment;

public interface IStudentEnrollmentRepository extends JpaRepository<StudentEnrollment, Long> {
}