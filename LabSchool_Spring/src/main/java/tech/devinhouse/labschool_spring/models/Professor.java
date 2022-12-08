package tech.devinhouse.labschool_spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PROFESSORES")
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Pessoa{

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    @Enumerated(EnumType.STRING)
    private ExperienciaEnum experiencia;

    @Enumerated(EnumType.STRING)
    private FormacaoEnum formacao;

}
