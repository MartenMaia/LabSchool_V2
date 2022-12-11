package tech.devinhouse.labschool_spring.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschool_spring.dto.AlunoResponse;
import tech.devinhouse.labschool_spring.dto.AtendimentoResponse;
import tech.devinhouse.labschool_spring.services.AtendimentoService;

import java.util.Map;

@RestController
@RequestMapping("api/atendimentos")
@AllArgsConstructor
public class AtendimentoController {

    private AtendimentoService service;

    @PutMapping()
    public ResponseEntity<AtendimentoResponse> put(@RequestBody @Valid Map<String, Integer> request){
        AtendimentoResponse resp = service.atendimento(request);
        return ResponseEntity.ok(resp);
    }

}
