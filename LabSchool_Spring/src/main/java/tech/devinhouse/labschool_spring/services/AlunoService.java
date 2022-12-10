package tech.devinhouse.labschool_spring.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool_spring.exceptions.CpfJaCadastradoException;
import tech.devinhouse.labschool_spring.exceptions.DadoInvalidoException;
import tech.devinhouse.labschool_spring.exceptions.RegistroNaoEncontradoException;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;
import tech.devinhouse.labschool_spring.repositories.AlunoRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepo;

    public Aluno criar(Aluno aluno){ //melhorar
        if(alunoRepo.findByCpf(aluno.getCpf()).isPresent())
            throw new CpfJaCadastradoException(aluno.getCpf(),Aluno.class.getSimpleName());
        return alunoRepo.save(aluno);
    };

    public List<Aluno> consultar() {
        return alunoRepo.findAll();
    }

    public List<Aluno> consultar(String situacao){
        if(situacao == null)
            return alunoRepo.findAll();
        try {
            List<Aluno> alunos = alunoRepo.findAllBySituacao(SituacaoEnum.valueOf(situacao));
            return alunos;
        }catch (Exception e){
            throw new DadoInvalidoException("> situacao <");
        }
    }

    public Aluno atualizar(Integer codigo,Map<String,String> map) {
        String situacao = map.get("situacao");
        Optional<Aluno> alunoOpt = alunoRepo.findById(codigo);
        if(alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException(codigo.toString());
        Aluno aluno = alunoOpt.get();
        try {
            aluno.setSituacao(SituacaoEnum.valueOf(situacao));
        }catch (Exception e){
            throw new DadoInvalidoException("> situacao <");
        }
        aluno = alunoRepo.save(aluno);
        return aluno;
    }
}
