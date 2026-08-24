package re.edu.api.repository;

import org.springframework.stereotype.Repository;
import re.edu.api.model.Instructor;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {
    private List<Instructor> instructors = new ArrayList<>( List.of(
            new Instructor("GV1", "Shank tóc đỏ", "shank@gmail.com"),
            new Instructor("GV2", "Garp Galaxy Impact", "garp@gmail.com")
    ));

    // Lấy toàn bộ dữ liệu
    public List<Instructor> findAll() {
        return instructors;
    }

    // Lấy dữ liệu theo id
    public Instructor findById(String id) {
        return instructors.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Thêm dữ liệu
    public Instructor create(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }

    // Cập nhật theo id
    public Instructor update(String id, Instructor instructor) {
        int index = getIndexById(id);
        if (index == -1) {
            return null;
        }
        instructor.setId(id);
        instructors.set(index, instructor);
        return instructor;
    }

    // Xóa theo id
    public Instructor deleteById(String id) {
        int index = getIndexById(id);
        if (index == -1) {
            return null;
        }
        return instructors.remove(index);
    }

    // Tìm vị trí phần tử theo ID
    private int getIndexById(String id) {
        Instructor instructor = instructors.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (instructor == null) {
            return -1;
        }
        return instructors.indexOf(instructor);
    }
}
