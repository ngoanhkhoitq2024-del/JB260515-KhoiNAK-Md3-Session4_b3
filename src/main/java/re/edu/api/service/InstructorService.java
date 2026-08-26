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
    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElse(null);
    }

    // Thêm
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Cập nhật
    public Instructor updateInstructor(Long id, Instructor instructor) {
        if (!instructorRepository.existsById(id)) {
            return null;
        }
        instructor.setId(id);
        return instructorRepository.save(instructor);
    }

    // Xóa theo ID
    public Instructor deleteInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElse(null);
        if (instructor == null) {
            return null;
        }
        instructorRepository.deleteById(id);
        return instructor;
    }
}
