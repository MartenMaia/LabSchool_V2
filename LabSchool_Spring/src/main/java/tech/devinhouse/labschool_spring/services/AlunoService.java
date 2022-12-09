package tech.devinhouse.labschool_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.repositories.AlunoRepository;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepo;

    public Aluno criar(Aluno aluno){ //melhorar

        return alunoRepo.save(aluno);
    };

    public List<Aluno> consultar(){
        return alunoRepo.findAll();
    }

}
