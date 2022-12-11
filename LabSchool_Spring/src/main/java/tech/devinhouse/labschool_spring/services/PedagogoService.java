package tech.devinhouse.labschool_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool_spring.exceptions.CpfJaCadastradoException;
import tech.devinhouse.labschool_spring.exceptions.DadoInvalidoException;
import tech.devinhouse.labschool_spring.models.Pedagogo;
import tech.devinhouse.labschool_spring.repositories.PedagogoRepository;

import java.util.List;

@Service
public class PedagogoService {

    @Autowired
    private PedagogoRepository pedagogoRepo;

    public Pedagogo criar(Pedagogo pedagogo){
        if(pedagogoRepo.findByCpf(pedagogo.getCpf()).isPresent())
            throw new CpfJaCadastradoException(pedagogo.getCpf(),Pedagogo.class.getSimpleName());
        return pedagogoRepo.save(pedagogo);
    };

    public List<Pedagogo> consultar(){
        try {
            List<Pedagogo> pedagogos = pedagogoRepo.findAll();
            return pedagogos;
        }catch (Exception e){
            throw new DadoInvalidoException(" > busca < ");
        }
    }

}
