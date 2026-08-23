package re.edu.api.repository;

import org.springframework.stereotype.Repository;
import re.edu.api.model.Instructor;

import java.util.List;

@Repository
public class InstructorRepository {
    private List<Instructor> instructors = List.of(
            new Instructor("GV1", "Shank tóc đỏ", "shank@gmail.com"),
            new Instructor("GV2", "Garp Galaxy Impact", "garp@gmail.com")
    );

    public List<Instructor> findAll() {
        return instructors;
    }
}
