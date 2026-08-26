package re.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import re.edu.api.model.StudentEnrollment;
import re.edu.api.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    // Lấy danh sách có phân trang
    public Page<StudentEnrollment> findAllEnrollments(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return enrollmentRepository.findAll(pageable);
    }

    // Lấy theo ID
    public StudentEnrollment findEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    // Thêm
    public StudentEnrollment createEnrollment(StudentEnrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    // Cập nhật
    public StudentEnrollment updateEnrollment(Long id, StudentEnrollment enrollment) {
        StudentEnrollment existing = enrollmentRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        return enrollmentRepository.save(existing);
    }

    // Xóa
    public StudentEnrollment deleteEnrollmentById(Long id) {
        StudentEnrollment enrollment =
                enrollmentRepository.findById(id).orElse(null);

        if (enrollment == null) {
            return null;
        }

        enrollmentRepository.deleteById(id);
        return enrollment;
    }
}