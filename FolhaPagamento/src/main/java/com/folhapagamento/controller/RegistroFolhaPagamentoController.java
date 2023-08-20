package com.folhapagamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.folhapagamento.exception.RegistroFolhaPagamentoNotFoundException;
import com.folhapagamento.model.RegistroFolhaPagamento;
import com.folhapagamento.repository.RegistroFolhaPagamentoRepository;

@RestController
@RequestMapping("api/folha-pagamento")
public class RegistroFolhaPagamentoController {
    private RegistroFolhaPagamentoRepository registroRepository;
    
	private RegistroFolhaPagamentoController(RegistroFolhaPagamentoRepository registroRepository) {
		super();
		this.registroRepository = registroRepository;
	}
    
    @GetMapping()
    public List<RegistroFolhaPagamento> getAllEmployees() {
        return registroRepository.findAll();
    }

    @GetMapping("/{id}")
    public RegistroFolhaPagamento getRegistro(@PathVariable long id) {
        return registroRepository.findById(id).orElse(null);
    }

    @PostMapping
    public RegistroFolhaPagamento createRegistro(@RequestBody RegistroFolhaPagamento registro) {
        return registroRepository.save(registro);
    }

    @PutMapping("/{id}")
    public RegistroFolhaPagamento updateRegistro(@PathVariable long id, @RequestBody RegistroFolhaPagamento updatedRegistro) {
        RegistroFolhaPagamento existingRegistro = registroRepository.findById(id).orElseThrow(() -> new RegistroFolhaPagamentoNotFoundException(id));
        if (existingRegistro != null) {
            existingRegistro.setEmpresa(updatedRegistro.getEmpresa());
            existingRegistro.setMes(updatedRegistro.getMes());
            existingRegistro.setAno(updatedRegistro.getAno());
            return registroRepository.save(existingRegistro);
        }
        return null; // Ou lançar uma exceção informando que o registro não foi encontrado
    }

    @DeleteMapping("/{id}")
    public void deleteRegistro(@PathVariable Long id) {
    	var existingRegistro = registroRepository.findById(id)
                .orElseThrow(() -> new RegistroFolhaPagamentoNotFoundException(id));

        registroRepository.delete(existingRegistro);
    }

    @GetMapping("/por-cargo")
    public List<RegistroFolhaPagamento> getByCargo(@RequestParam String cargo) {
        return registroRepository.findByCargo(cargo);
    }

    @GetMapping("/por-ano")
    public List<RegistroFolhaPagamento> getByNome(@RequestParam int ano) {
        return registroRepository.findByAno(ano);
    }

    @GetMapping("/por-empresa")
    public List<RegistroFolhaPagamento> getByEmpresa(@RequestParam String empresa) {
        return registroRepository.findByEmpresa(empresa);
    }


}
