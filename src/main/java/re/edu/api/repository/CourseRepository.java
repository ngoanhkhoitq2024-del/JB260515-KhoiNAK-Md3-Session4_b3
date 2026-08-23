package re.edu.api.repository;

import org.springframework.stereotype.Repository;
import re.edu.api.model.Course;
import re.edu.api.model.Enrollment;

import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = List.of(
            new Course("KH1", "Haki Quan Sát", "active", "GV1"),
            new Course("KH2", "Haki Bá Vương", "active", "GV2"),
            new Course("KH3", "Haki Vũ Trang", "inactive", "GV3 ")
    );

    public List<Course> findAll() {
        return courses;
    }
}
