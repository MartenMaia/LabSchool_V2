package tech.devinhouse.labschool_spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "PEDAGOGOS")
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogo extends Pessoa{

    private Integer atendimentos = 0;

    public Pedagogo(Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf, Integer atendimentos) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.atendimentos = atendimentos;
    }

}
