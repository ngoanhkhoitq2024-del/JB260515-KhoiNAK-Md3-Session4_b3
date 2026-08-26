package re.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.api.model.StudentEnrollment;
import re.edu.api.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<Page<StudentEnrollment>> getAllEnrollments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(enrollmentService.findAllEnrollments(page, size)
        );
    }

    // Lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<StudentEnrollment> getEnrollmentById(@PathVariable Long id) {
        StudentEnrollment enrollment = enrollmentService.findEnrollmentById(id);
        if (enrollment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enrollment);
    }

    // Thêm
    @PostMapping
    public ResponseEntity<StudentEnrollment> createEnrollment(
            @RequestBody StudentEnrollment enrollment) {
        StudentEnrollment newEnrollment = enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEnrollment);
    }

    // Cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<StudentEnrollment> updateEnrollment(
            @PathVariable Long id,
            @RequestBody StudentEnrollment enrollment) {
        StudentEnrollment updatedEnrollment = enrollmentService.updateEnrollment(id, enrollment);
        if (updatedEnrollment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEnrollment);
    }

    // Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentEnrollment> deleteEnrollment(@PathVariable Long id) {
        StudentEnrollment deletedEnrollment = enrollmentService.deleteEnrollmentById(id);
        if (deletedEnrollment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedEnrollment);
    }
}