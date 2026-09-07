package br.unesp.moisesolimpio.springjpatutorial.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name = "PessoaJuridica")
@Getter 
@Setter 
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true, includeFieldNames = true) 
public class Juridica extends Pessoa {

    @Column(name = "cnpj", unique = true)
    public String cnpj;


    public Juridica() {
        
    }
}
