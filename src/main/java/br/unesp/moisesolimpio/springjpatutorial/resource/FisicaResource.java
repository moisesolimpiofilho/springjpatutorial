package br.unesp.moisesolimpio.springjpatutorial.resource;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unesp.moisesolimpio.springjpatutorial.dto.FisicaDTO;
import br.unesp.moisesolimpio.springjpatutorial.dto.assembler.FisicaAssembler;
import br.unesp.moisesolimpio.springjpatutorial.entity.Fisica;
import br.unesp.moisesolimpio.springjpatutorial.entity.mapper.FisicaMapper;
import br.unesp.moisesolimpio.springjpatutorial.service.FisicaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController 
@RequestMapping("/entidade/v1")
public class FisicaResource {

    private final FisicaService fisicaService;

    FisicaResource(FisicaService fisicaService) {
        this.fisicaService = fisicaService;
    }

    @GetMapping("/")
    public List<Fisica> getAllFisica() {
        return fisicaService.findAll();
    }

    @GetMapping("/{cpf}")
    public Fisica getFisicaByCpf(@PathVariable(value = "cpf") String cpf) {
        Fisica fisica = fisicaService.findByCpf(cpf);
        return fisica;
    }

    @DeleteMapping("/{cpf}")
    public boolean delete(@PathVariable(value = "cpf") String cpf) {
        boolean delete = false;
        Fisica fisicaDelete = fisicaService.findByCpf(cpf);

        if (fisicaDelete != null) {
            fisicaService.delete(fisicaDelete);
            delete = true;
        }

        return delete;
    }
    
    @PostMapping("/")
    public boolean saveFisica(@RequestBody FisicaDTO fisicaDTO) {
        boolean insert = false;

        Fisica fisica = FisicaAssembler.dtoToEntityModel(fisicaDTO);
        Fisica fisicaInsert = fisicaService.save(fisica);

        if (fisicaInsert != null) {
            insert = true;
        }
        
        return insert;
    }
    
    @PutMapping("/")
    public boolean update(@RequestBody FisicaDTO fisicaDTO) {
        boolean update = false;
        
        Fisica newFisica = FisicaAssembler.dtoToEntityModel(fisicaDTO);
        Fisica fisicaUpdate = fisicaService.findByCpf(newFisica.getCpf());
        
        FisicaMapper.update(fisicaUpdate, newFisica);
        Fisica fisicaUpdated = fisicaService.update(fisicaUpdate);

        if (fisicaUpdated != null) {
            update = true;
        }
        return update;
    }
}
