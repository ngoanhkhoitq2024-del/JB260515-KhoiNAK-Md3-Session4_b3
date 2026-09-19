package re.edu.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorCreateRequest {
    private String name;
    private String email;
}
