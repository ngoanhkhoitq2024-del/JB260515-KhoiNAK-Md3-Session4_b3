package re.edu.api.repository;

import org.springframework.stereotype.Repository;
import re.edu.api.model.Course;
import re.edu.api.model.Instructor;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>( List.of(
            new Course("KH1", "Haki Quan Sát", "active", "GV1"),
            new Course("KH2", "Haki Bá Vương", "active", "GV2"),
            new Course("KH3", "Haki Vũ Trang", "inactive", "GV3 ")
    ));

    // Lấy toàn bộ dữ liệu
    public List<Course> findAll() {
        return courses;
    }

    // Lấy dữ liệu theo id
    public Course findById(String id) {
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Thêm dữ liệu
    public Course create(Course course) {
        courses.add(course);
        return course;
    }

    // Cập nhật theo id
    public Course update(String id, Course course) {
        int index = getIndexById(id);
        if (index == -1) {
            return null;
        }
        // Giữ nguyên ID của bản ghi đang được cập nhật
        course.setId(id);
        courses.set(index, course);
        return course;
    }

    // Xóa theo id
    public Course deleteById(String id) {
        int index = getIndexById(id);
        if (index == -1) {
            return null;
        }
        return courses.remove(index);
    }

    // Tìm vị trí phần tử theo ID
    private int getIndexById(String id) {
        Course course = courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (course == null) {
            return -1;
        }
        return courses.indexOf(course);
    }
}
