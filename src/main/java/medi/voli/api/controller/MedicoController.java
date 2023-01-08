package medi.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){
		//o spring tem um pageable padrão, a anotação pageable default vai apenas mudar esse padrão.
		return repository.findAll(paginacao).map(DadosListagemMedico::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
		var medico = repository.getReferenceById(dados.id());
		medico.atualizarInformacoes(dados);
		// não será preciso fazer mais nada para salvar os dados do médico, pois este método está dentro de uma transação
	}
}
