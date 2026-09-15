package br.unesp.moisesolimpio.springjpatutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.unesp.moisesolimpio.springjpatutorial.entity.Fisica;
import br.unesp.moisesolimpio.springjpatutorial.repositoty.FisicaRepository;
import br.unesp.moisesolimpio.springjpatutorial.utils.InstanceGenerator;

@SpringBootTest 
public class FisicaServiceTest {

    private Fisica entity;

    private final FisicaRepository repository;

    public FisicaServiceTest(FisicaRepository repository) {
        this.repository = repository;

    }

    @Disabled 
    @Test
    void testDelete() {

    }

    @Disabled 
    @Test
    @DisplayName("FisicaService.findAll()") 
    void testFindAll() {
        System.out.println("findAll");

        Fisica expResult = null;
        System.out.println("-----------------------------------------------");
        System.out.println("Resultado do findAll:");
        System.out.println("-----------------------------------------------");
        List<Fisica> result = this.repository.findAll();

        for (Fisica f: result) {
            System.out.println("-----------------------------------------------");
            System.out.println("Fisica: " + f);
            System.out.println("-----------------------------------------------");
        }

        assertNotEquals(expResult, result);
    }

    @Disabled 
    @Test
    @DisplayName("FisicaService.findByCpf(cpf)")
    void testFindByCpf() {
        entity = InstanceGenerator.getPessoaFisica("222.333.444-55", "user1");

        String cpf = "222.333.444-55";
        Fisica f = this.repository.findByCpf(cpf);
        System.out.println("-----------------------------------------------");
        System.out.println("Resultado do findByCpf");
        System.out.println("-----------------------------------------------");
        System.out.println(f);
        System.out.println("-----------------------------------------------");
    }

    // @Disabled 
    @Test
    @DisplayName("FisicaService.save(Fisica)")
    void testSave() {
        entity = InstanceGenerator.getPessoaFisica("222.333.444-55", "user1");
        System.out.println(entity);

        Fisica f = this.repository.save(entity);
        System.out.println("-----------------------------------------------");
        System.out.println(f);
        System.out.println("-----------------------------------------------");
        assertEquals(entity, f);
    }

    @Disabled
    @Test
    void testUpdate() {

    }
}
