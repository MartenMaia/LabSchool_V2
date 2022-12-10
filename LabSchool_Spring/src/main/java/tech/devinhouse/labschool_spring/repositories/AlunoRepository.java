package tech.devinhouse.labschool_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findByCpf(Long cpf);

    @Query("SELECT a FROM Aluno a WHERE a.situacao = :situacao")
    List<Aluno> findAllBySituacao(SituacaoEnum situacao);
}
