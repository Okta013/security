package ru.anikeeva.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anikeeva.security.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
