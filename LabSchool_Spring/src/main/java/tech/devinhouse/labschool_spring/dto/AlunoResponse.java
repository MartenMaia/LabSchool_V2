package tech.devinhouse.labschool_spring.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;

import java.time.LocalDate;

@Data
public class AlunoResponse {

    private Integer codigo;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private Long cpf;
    private String situacao;
    private Float nota;
    private Integer atendimentos;

}
