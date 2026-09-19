package re.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.edu.api.model.Course;
import re.edu.api.repository.ICourseRepository;

import java.util.List;

@Service
public class CourseService {
    private final ICourseRepository courseRepository;

    @Autowired
    public CourseService(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Lấy tất cả Course
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    // Lấy Course theo ID
    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Thêm Course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Cập nhật Course
    public Course updateCourse(Long id, Course course) {
        if (!courseRepository.existsById(id)) {
            return null;
        }

        course.setId(id);
        return courseRepository.save(course);
    }

    // Xóa Course
    public Course deleteCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return null;
        }
        courseRepository.deleteById(id);
        return course;
    }
}