package tech.devinhouse.labschool_spring.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labschool_spring.dto.PedagogoResponse;
import tech.devinhouse.labschool_spring.dto.ProfessorResponse;
import tech.devinhouse.labschool_spring.models.Pedagogo;
import tech.devinhouse.labschool_spring.models.Professor;
import tech.devinhouse.labschool_spring.services.PedagogoService;
import tech.devinhouse.labschool_spring.services.ProfessorService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/pedagogos")
@AllArgsConstructor
public class PedagogoController {

    private PedagogoService service;
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PedagogoResponse>> get(){
        List<Pedagogo> pedagogos = service.consultar();
        List<PedagogoResponse> resp = new ArrayList<>();
        for (Pedagogo pedagogo : pedagogos){
            resp.add(mapper.map(pedagogo,PedagogoResponse.class));
        }
        return ResponseEntity.ok(resp);
    }
}
