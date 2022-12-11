package tech.devinhouse.labschool_spring.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool_spring.dto.AtendimentoResponse;
import tech.devinhouse.labschool_spring.exceptions.RegistroNaoEncontradoException;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Pedagogo;
import tech.devinhouse.labschool_spring.repositories.AlunoRepository;
import tech.devinhouse.labschool_spring.repositories.PedagogoRepository;

import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AtendimentoService {

    @Autowired
    private AlunoRepository repoAluno;
    private PedagogoRepository repoPed;

    public AtendimentoResponse atendimento(Map<String, Integer> map){
        Integer idAluno = map.get("codigoAluno");
        Integer idPedagogo = map.get("codigoPedagogo");

        AtendimentoResponse response = new AtendimentoResponse();
        Optional<Aluno> alunoOpt = repoAluno.findById(idAluno);
        Optional<Pedagogo> pedagogoOpt = repoPed.findById(idPedagogo);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException(Aluno.class.getSimpleName()+" "+idAluno);
        if (pedagogoOpt.isEmpty())
            throw new RegistroNaoEncontradoException(Pedagogo.class.getSimpleName()+" "+idPedagogo);

        Aluno aluno = alunoOpt.get();
        Pedagogo pedagogo = pedagogoOpt.get();

        aluno.atender();
        pedagogo.atender();

        repoAluno.save(aluno);
        repoPed.save(pedagogo);

        response.setAluno(aluno);
        response.setPedagogo(pedagogo);
        return response;

    }

}
