package tech.devinhouse.labschool_spring.exceptions;

public class DadoInvalidoException extends RuntimeException{

    public DadoInvalidoException(String tipo){
        super("Dado de " + tipo +" inválido!");
    }

}
