package tech.devinhouse.labschool_spring.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException{

    public RegistroNaoEncontradoException(String registro){
        super("Registro com identificador: "+ registro + " não encontrado!");
    }

}
