package tech.devinhouse.labschool_spring.dto;

import lombok.Data;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Pedagogo;

@Data
public class AtendimentoResponse {

    private Aluno aluno;
    private Pedagogo pedagogo;

}
