package ru.anikeeva.security.mappers;

import org.mapstruct.Mapper;
import ru.anikeeva.security.dto.StudentDTO;
import ru.anikeeva.security.models.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentDTO studentDTO);
}
