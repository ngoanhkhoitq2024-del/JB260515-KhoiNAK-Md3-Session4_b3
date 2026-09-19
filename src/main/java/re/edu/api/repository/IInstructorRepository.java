package re.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.api.model.Instructor;

public interface IInstructorRepository extends JpaRepository<Instructor, Long> {
}
