package tech.devinhouse.labschool_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschool_spring.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
