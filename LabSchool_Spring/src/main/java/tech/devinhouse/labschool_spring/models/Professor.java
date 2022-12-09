package tech.devinhouse.labschool_spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.labschool_spring.models.Enuns.EstadoEnum;
import tech.devinhouse.labschool_spring.models.Enuns.ExperienciaEnum;
import tech.devinhouse.labschool_spring.models.Enuns.FormacaoEnum;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;

import java.time.LocalDate;

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

    public Professor(Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf, EstadoEnum estado, ExperienciaEnum experiencia, FormacaoEnum formacao) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.estado = estado;
        this.experiencia = experiencia;
        this.formacao = formacao;
    }

}
