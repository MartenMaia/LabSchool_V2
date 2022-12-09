package tech.devinhouse.labschool_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschool_spring.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
