package tech.devinhouse.labschool_spring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "ALUNOS")
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Pessoa{

    @Enumerated(EnumType.STRING)
    private SituacaoEnum situacao;

    private Double nota;

    private Integer atendimentos = 0;

    public Aluno(Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf,SituacaoEnum situacao,Double nota,Integer atendimentos) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.situacao = situacao;
        this.nota = nota;
        this.atendimentos = atendimentos;
    }

}
