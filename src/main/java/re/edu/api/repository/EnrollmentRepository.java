package re.edu.api.repository;

import org.springframework.stereotype.Repository;
import re.edu.api.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>( List.of(
            new Enrollment("DK1", "Luffy", "KH1"),
            new Enrollment("DK2", "Zoro", "KH1"),
            new Enrollment("DK3", "Nami", "KH2")
    ));

    public List<Enrollment> findAll() {
        return enrollments;
    }

    // Lấy dữ liệu theo id
    public Enrollment findById(String id) {
        return enrollments.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Thêm dữ liệu
    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    // Cập nhật theo id
    public Enrollment update(String id, Enrollment enrollment) {
        int index = getIndexById(id);
        if (index == -1) {
            return null;
        }
        // Giữ nguyên ID của bản ghi đang được cập nhật
        enrollment.setId(id);
        enrollments.set(index, enrollment);
        return enrollment;
    }

    // Xóa theo id
    public Enrollment deleteById(String id) {
        int index = getIndexById(id);
        if (index == -1) {
            return null;
        }
        return enrollments.remove(index);
    }

    // Tìm vị trí phần tử theo ID
    private int getIndexById(String id) {
        Enrollment enrollment = enrollments.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (enrollment == null) {
            return -1;
        }
        return enrollments.indexOf(enrollment);
    }
}
