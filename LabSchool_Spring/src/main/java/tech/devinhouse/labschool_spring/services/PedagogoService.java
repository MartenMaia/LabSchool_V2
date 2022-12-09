package tech.devinhouse.labschool_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Pedagogo;
import tech.devinhouse.labschool_spring.repositories.PedagogoRepository;

import java.util.List;

@Service
public class PedagogoService {

    @Autowired
    private PedagogoRepository pedagogoRepo;

    public Pedagogo criar(Pedagogo pedagogo){ //melhorar
        return pedagogoRepo.save(pedagogo);
    };

    public List<Pedagogo> consultar(){
        return pedagogoRepo.findAll();
    }

}
