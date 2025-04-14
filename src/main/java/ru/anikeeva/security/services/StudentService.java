package ru.anikeeva.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anikeeva.security.dto.StudentDTO;
import ru.anikeeva.security.mappers.StudentMapper;
import ru.anikeeva.security.models.Student;
import ru.anikeeva.security.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toStudentDTO).toList();
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toStudent(studentDTO);
        return studentMapper.toStudentDTO(studentRepository.save(student));
    }
}
