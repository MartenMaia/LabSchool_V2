package tech.devinhouse.labschool_spring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA") // Verificar se isso é necessario!
    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    private Long cpf;

    public Pessoa(Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Pessoa() {
        this.codigo = null;
        this.nome = null;
        this.telefone = null;
        this.dataNascimento = null;
        this.cpf = null;
    }
}
