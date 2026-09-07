package br.unesp.moisesolimpio.springjpatutorial.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true, includeFieldNames = true) 
public class Juridica extends Pessoa {
    
    public String cnpj;


    public Juridica() {
        
    }
}
