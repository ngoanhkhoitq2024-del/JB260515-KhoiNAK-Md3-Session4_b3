package re.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.edu.api.model.Course;
import re.edu.api.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Lấy tất cả Course
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    // Lấy Course theo ID
    public Course findCourseById(String id) {
        return courseRepository.findById(id);
    }

    // Thêm Course
    public Course createCourse(Course course) {
        return courseRepository.create(course);
    }

    // Cập nhật Course
    public Course updateCourse(String id, Course course) {
        return courseRepository.update(id, course);
    }

    // Xóa Course
    public Course deleteCourseById(String id) {
        return courseRepository.deleteById(id);
    }
}