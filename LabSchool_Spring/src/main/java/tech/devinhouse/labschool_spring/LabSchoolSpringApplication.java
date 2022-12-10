package tech.devinhouse.labschool_spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tech.devinhouse.labschool_spring.models.Aluno;
import tech.devinhouse.labschool_spring.models.Enuns.EstadoEnum;
import tech.devinhouse.labschool_spring.models.Enuns.ExperienciaEnum;
import tech.devinhouse.labschool_spring.models.Enuns.FormacaoEnum;
import tech.devinhouse.labschool_spring.models.Enuns.SituacaoEnum;
import tech.devinhouse.labschool_spring.models.Pedagogo;
import tech.devinhouse.labschool_spring.models.Professor;
import tech.devinhouse.labschool_spring.services.AlunoService;
import tech.devinhouse.labschool_spring.services.PedagogoService;
import tech.devinhouse.labschool_spring.services.ProfessorService;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class LabSchoolSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSchoolSpringApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    CommandLineRunner run(AlunoService alunoService, ProfessorService professorService, PedagogoService pedagogoService) {
        return args -> {  // inserting data after application is up
            if (alunoService.consultar().isEmpty()) {
                alunoService.criar(new Aluno(null,"Bart Simpson","11-11111-1212",LocalDate.of(2014,10,29),11839750073L,SituacaoEnum.IRREGULAR,3.5F));
                alunoService.criar(new Aluno(null,"Lisa Simpson","11-22222-2222",LocalDate.of(2012,10,29),17158947076L,SituacaoEnum.ATIVO,10F));
                alunoService.criar(new Aluno(null,"Meggie Simpson","12-20002-2200",LocalDate.of(2019,10,29),63701210020L,SituacaoEnum.ATIVO,9F));
                alunoService.criar(new Aluno(null,"Milhouse Van Houten","11-33333-2222",LocalDate.of(2014,10,29),30119137062L,SituacaoEnum.ATIVO,8F));
                alunoService.criar(new Aluno(null,"Nelson Muntz","11-44333-4444",LocalDate.of(2007,10,29),95704094015L,SituacaoEnum.INATIVO,2F));
            }
            if (professorService.consultar().isEmpty()) {
                professorService.criar(new Professor(null,"Walter White","14-22998-1882",LocalDate.of(1982,10,30),40539019011L, EstadoEnum.ATIVO, ExperienciaEnum.FULL_STACK, FormacaoEnum.MESTRADO));
                professorService.criar(new Professor(null,"Jesse Pinkman","44-11111-1992",LocalDate.of(1997,10,30),96107295097L,EstadoEnum.ATIVO,ExperienciaEnum.BACK_END,FormacaoEnum.GRADUACAO_INCOMPLETA));
                professorService.criar(new Professor(null,"Hank Schrader","44-11111-1002",LocalDate.of(1984,10,30),70685977005L,EstadoEnum.ATIVO,ExperienciaEnum.FULL_STACK,FormacaoEnum.MESTRADO));
                professorService.criar(new Professor(null,"Gustavo Fring","44-11001-1002",LocalDate.of(1977,10,30),57408927085L,EstadoEnum.INATIVO,ExperienciaEnum.FRONT_END,FormacaoEnum.GRADUACAO_COMPLETA));
                professorService.criar(new Professor(null,"Saul Goodman","44-11998-1882",LocalDate.of(1980,10,30),86940162062L,EstadoEnum.ATIVO,ExperienciaEnum.FULL_STACK,FormacaoEnum.MESTRADO));
            }
            if (pedagogoService.consultar().isEmpty()) {
                pedagogoService.criar(new Pedagogo(null,"John Snow","11-67333-4454",LocalDate.of(2000,10,30),62316840086L,0));
                pedagogoService.criar(new Pedagogo(null,"Sansa Stark","22-22333-4454",LocalDate.of(2004,10,30),49850253053L,0));
                pedagogoService.criar(new Pedagogo(null,"Tyrion Lannister","33-77333-4454",LocalDate.of(1990,10,30),39125106015L,0));
                pedagogoService.criar(new Pedagogo(null,"Sandor Clegane","11-33333-2222",LocalDate.of(1995,10,30),89089606009L,0));
            }
        };

    }
}
