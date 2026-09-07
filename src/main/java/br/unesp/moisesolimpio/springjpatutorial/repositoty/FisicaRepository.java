package br.unesp.moisesolimpio.springjpatutorial.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.moisesolimpio.springjpatutorial.entity.Fisica;

public interface FisicaRepository extends JpaRepository<Fisica, Long> {
    
    Fisica findByCpf(String cpf);
}
