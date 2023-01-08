package medi.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import medi.voli.api.paciente.Paciente;
import medi.voli.api.paciente.PacienteRepository;
import medi.voli.api.paciente.dto.DadosCadastroPaciente;

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
}
