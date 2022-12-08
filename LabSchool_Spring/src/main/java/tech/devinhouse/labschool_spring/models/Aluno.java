package tech.devinhouse.labschool_spring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ALUNOS")
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Pessoa{

    @Enumerated(EnumType.STRING)
    private SituacaoEnum situacaoEnum;

    private Double nota;

    private Integer atendimentos = 0;

}
