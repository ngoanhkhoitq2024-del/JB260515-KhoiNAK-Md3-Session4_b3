package re.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.edu.api.model.Enrollment;
import re.edu.api.repository.EnrollmentRepository;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    // Lấy tất cả Enrollment
    public List<Enrollment> findAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Lấy Enrollment theo ID
    public Enrollment findEnrollmentById(String id) {
        return enrollmentRepository.findById(id);
    }

    // Thêm Enrollment
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.create(enrollment);
    }

    // Cập nhật Enrollment
    public Enrollment updateEnrollment(String id, Enrollment enrollment) {
        return enrollmentRepository.update(id, enrollment);
    }

    // Xóa Enrollment
    public Enrollment deleteEnrollmentById(String id) {
        return enrollmentRepository.deleteById(id);
    }
}