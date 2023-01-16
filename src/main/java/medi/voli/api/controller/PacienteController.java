package medi.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import medi.voli.api.controller.dto.medico.DadosListagemMedico;
import medi.voli.api.controller.dto.paciente.DadosAtualizaoPaciente;
import medi.voli.api.controller.dto.paciente.DadosCadastroPaciente;
import medi.voli.api.controller.dto.paciente.DadosListagemPaciente;
import medi.voli.api.domain.Paciente;
import medi.voli.api.repository.PacienteRepository;

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
	public Page<DadosListagemPaciente> listar(@PageableDefault(size=10, sort = {"nome"})Pageable paginacao){
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);		
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizaoPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		System.out.println(id);
		var paciente = repository.getReferenceById(id);
		paciente.excluir();
	}
}
