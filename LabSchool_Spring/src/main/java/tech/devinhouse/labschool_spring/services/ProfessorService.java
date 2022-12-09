package tech.devinhouse.labschool_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Professor;
import tech.devinhouse.labschool_spring.repositories.ProfessorRepository;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepo;

    public Professor criar(Professor professor){ //melhorar
        return professorRepo.save(professor);
    };

    public List<Professor> consultar(){
        return professorRepo.findAll();
    }

}
