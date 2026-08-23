package re.edu.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import re.edu.api.model.Enrollment;

import java.util.List;

@Repository
public class EnrollmentRepository {
    private List<Enrollment> enrollments = List.of(
            new Enrollment("DK1", "Luffy", "KH1"),
            new Enrollment("DK2", "Zoro", "KH1"),
            new Enrollment("DK3", "Nami", "KH2")
    );

    public List<Enrollment> findAll() {
        return enrollments;
    }
}
