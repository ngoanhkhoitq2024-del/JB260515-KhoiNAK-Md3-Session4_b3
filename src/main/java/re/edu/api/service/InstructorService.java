package re.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.edu.api.model.Instructor;
import re.edu.api.repository.InstructorRepository;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // Lấy tất cả Instructor
    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    // Lấy theo ID
    public Instructor findInstructorById(String id) {
        return instructorRepository.findById(id);
    }

    // Thêm
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.create(instructor);
    }

    // Cập nhật
    public Instructor updateInstructor(
            String id,
            Instructor instructor) {

        return instructorRepository.update(id, instructor);
    }

    // Xóa theo ID
    public Instructor deleteInstructorById(String id) {
        return instructorRepository.deleteById(id);
    }
}
