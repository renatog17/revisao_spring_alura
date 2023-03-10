package medi.voli.api.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medi.voli.api.controller.dto.paciente.DadosAtualizaoPaciente;
import medi.voli.api.controller.dto.paciente.DadosCadastroPaciente;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private Boolean ativo;
	@Embedded
	private Endereco endereco;
	
	public Paciente(DadosCadastroPaciente dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());
		this.ativo = true;
	}

	public void atualizarInformacoes(@Valid DadosAtualizaoPaciente dados) {
		if (dados.nome() != null)
			this.nome = dados.nome();
		if (dados.telefone() != null)
			this.telefone = dados.telefone();
		if (dados.dadosEndereco() != null) {
			this.endereco.atualizarInformacoes(dados.dadosEndereco());
		}
	}

	public void excluir() {
		this.ativo = false;
	}
}
