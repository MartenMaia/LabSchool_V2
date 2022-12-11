package tech.devinhouse.labschool_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool_spring.exceptions.CpfJaCadastradoException;
import tech.devinhouse.labschool_spring.exceptions.DadoInvalidoException;
import tech.devinhouse.labschool_spring.models.Professor;
import tech.devinhouse.labschool_spring.repositories.ProfessorRepository;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepo;

    public Professor criar(Professor professor){
        if(professorRepo.findByCpf(professor.getCpf()).isPresent())
            throw new CpfJaCadastradoException(professor.getCpf(),Professor.class.getSimpleName());
        return professorRepo.save(professor);
    };

    public List<Professor> consultar(){
        try {
            List<Professor> professores = professorRepo.findAll();
            return professores;
        }catch (Exception e){
            throw new DadoInvalidoException(" > busca < ");
        }
    }

}
