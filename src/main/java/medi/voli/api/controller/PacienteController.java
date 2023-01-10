package medi.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import medi.voli.api.paciente.Paciente;
import medi.voli.api.paciente.PacienteRepository;
import medi.voli.api.paciente.dto.DadosAtualizaoPaciente;
import medi.voli.api.paciente.dto.DadosCadastroPaciente;
import medi.voli.api.paciente.dto.DadosListagemPaciente;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	PacienteRepository repository;
	
	@Transactional
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
		System.out.println(dados.email()+" "+dados.endereco().cidade());
		repository.save(new Paciente(dados));
	}
	
	@GetMapping
	public Page<DadosListagemPaciente> listar(Pageable paginacao){
		return null;
		
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizaoPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
	}
}
