package re.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.api.model.StudentEnrollment;

public interface EnrollmentRepository extends JpaRepository<StudentEnrollment, Long> {
}