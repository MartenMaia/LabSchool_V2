package tech.devinhouse.labschool_spring.exceptions;

public class CpfJaCadastradoException extends RuntimeException {

    public CpfJaCadastradoException(Long cpf, String classe){
        super("Pessoa com o CPF: "+ cpf + ", já cadastrada na base de dados de " + classe);
    }

}
