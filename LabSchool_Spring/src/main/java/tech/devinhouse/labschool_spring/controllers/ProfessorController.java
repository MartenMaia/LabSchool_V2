package tech.devinhouse.labschool_spring.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschool_spring.dto.AlunoResponse;
import tech.devinhouse.labschool_spring.dto.ProfessorResponse;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Professor;
import tech.devinhouse.labschool_spring.services.ProfessorService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/professores")
@AllArgsConstructor
public class ProfessorController {

    private ProfessorService service;
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> get(){
        List<Professor> professores = service.consultar();
        List<ProfessorResponse> resp = new ArrayList<>();
        for (Professor professor : professores){
            resp.add(mapper.map(professor,ProfessorResponse.class));
        }
        return ResponseEntity.ok(resp);
    }


}
