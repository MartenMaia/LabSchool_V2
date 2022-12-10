package tech.devinhouse.labschool_spring.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschool_spring.dto.AlunoRequest;
import tech.devinhouse.labschool_spring.dto.AlunoResponse;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.services.AlunoService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
public class AlunoController {

    private AlunoService service;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<AlunoResponse> post(@RequestBody @Valid AlunoRequest request){
        Aluno aluno = mapper.map(request, Aluno.class);
        aluno = service.criar(aluno);
        AlunoResponse resp = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(resp.getNome())).body(resp);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<AlunoResponse> put(@PathVariable("codigo") Integer codigo, @RequestBody @Valid Map<String,String> map){
        Aluno aluno = service.atualizar(codigo,map);
        AlunoResponse resp = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(resp);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> get(@RequestParam(value = "situacao",required = false) String situacao){
        List<Aluno> alunos = service.consultar(situacao);
        List<AlunoResponse> resp = new ArrayList<>();
        for (Aluno aluno : alunos){
            resp.add(mapper.map(aluno,AlunoResponse.class));
        }
        return ResponseEntity.ok(resp);
    }

}
