package re.edu.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.api.model.Enrollment;
import re.edu.api.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // Lấy full ds
    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.findAllEnrollments());
    }

    // Lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable String id) {
        Enrollment enrollment = enrollmentService.findEnrollmentById(id);
        if (enrollment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enrollment);
    }

    // Thêm
    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment newEnrollment = enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEnrollment);
    }

    // Cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable String id, @RequestBody Enrollment enrollment) {
        Enrollment updatedEnrollment = enrollmentService.updateEnrollment(id, enrollment);
        if (updatedEnrollment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEnrollment);
    }

    // Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<Enrollment> deleteEnrollment(@PathVariable String id) {
        Enrollment deletedEnrollment = enrollmentService.deleteEnrollmentById(id);
        if (deletedEnrollment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedEnrollment);
    }
}