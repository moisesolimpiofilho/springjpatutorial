package br.unesp.moisesolimpio.springjpatutorial.entity;

import java.util.List;
import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@EqualsAndHashCode 
@ToString 
public class Pessoa {
    
    private long idPessoa;
    private String nome;
    private List<Endereco> endereco;
    private Acesso acesso;
    private Contato contato;

    public Pessoa() {
        this.endereco = new ArrayList<>();
    }

    public void setEndereco(Endereco endereco) {
        this.endereco.add(endereco);
    }
}
