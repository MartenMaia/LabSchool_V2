package tech.devinhouse.labschool_spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PEDAGOGOS")
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogo extends Pessoa{

    private Integer atendimentos = 0;

}
