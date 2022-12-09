package tech.devinhouse.labschool_spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;
import tech.devinhouse.labschool_spring.services.AlunoService;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class LabSchoolSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSchoolSpringApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    CommandLineRunner run(AlunoService alunoService) {
        return args -> {  // inserting data after application is up
            if (alunoService.consultar().isEmpty()) {
                alunoService.criar(new Aluno(null,null,null,null,null, SituacaoEnum.ATIVO,null,null));
            }
        };

    }
}
