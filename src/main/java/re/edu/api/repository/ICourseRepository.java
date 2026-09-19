package re.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.api.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {

}
