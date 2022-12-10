package tech.devinhouse.labschool_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschool_spring.models.Pedagogo;

import java.util.Optional;

@Repository
public interface PedagogoRepository extends JpaRepository<Pedagogo, Integer> {

    Optional<Pedagogo> findByCpf(Long cpf);

}
