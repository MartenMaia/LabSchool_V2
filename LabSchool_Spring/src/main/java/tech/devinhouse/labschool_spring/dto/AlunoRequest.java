package tech.devinhouse.labschool_spring.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;

import java.time.LocalDate;

@Data
public class AlunoRequest {

    @NotEmpty(message = "{campo.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    private String telefone;

    @NotNull(message = "{campo.obrigatorio}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    @NotNull(message = "{campo.obrigatorio}")
    private Long cpf;

    @NotNull(message = "{campo.obrigatorio}")
    @Pattern(regexp = "ATIVO|IRREGULAR|ATENDIMENTO_PEDAGOGICO|INATIVO", flags = Pattern.Flag.CASE_INSENSITIVE, message = "{campo.invalido}")
    private String situacao;

    @NotNull(message = "{campo.obrigatorio}")
    @Range(min=0, max=10)
    private Float nota;



}
