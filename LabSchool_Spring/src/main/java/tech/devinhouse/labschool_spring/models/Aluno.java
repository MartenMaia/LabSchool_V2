package tech.devinhouse.labschool_spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    private Float nota;

    private Integer atendimentos = 0;

    public Aluno(Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf,SituacaoEnum situacao,Float nota) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.situacao = situacao;
        this.nota = nota;
        this.atendimentos = 0;
    }

    public void atender(){
        this.atendimentos++;
    }

}
