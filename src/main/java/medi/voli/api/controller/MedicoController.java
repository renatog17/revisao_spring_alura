package medi.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import medi.voli.api.medico.DadosCadastroMedico;
import medi.voli.api.medico.Medico;
import medi.voli.api.medico.MedicoRepository;


@RestController
@RequestMapping("medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;
	
	@PostMapping
	@Transactional //isso quer dizer que eu preciso ter uma conexão ativa com o db
	public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
		
		repository.save(new Medico(dados));
	}
}
