package medi.voli.api.domain;

import jakarta.persistence.Embeddable;
import medi.voli.api.controller.dto.endereco.DadosEndereco;

@Embeddable
public class Endereco {

	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;

	public Endereco(String logradouro, String bairro, String cep, String numero, String complemento, String cidade,
			String uf) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Endereco() {
		super();
	}

	public Endereco(DadosEndereco endereco) {
		this.bairro = endereco.bairro();
		this.cep = endereco.cep();
		this.cidade = endereco.cidade();
		this.complemento = endereco.complemento();
		this.logradouro = endereco.logradouro();
		this.numero = endereco.numero();
		this.uf = endereco.uf();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public void atualizarInformacoes(DadosEndereco dadosEndereco) {
		if (dadosEndereco.logradouro() != null)
			this.logradouro = dadosEndereco.logradouro();

		if (dadosEndereco.bairro() != null)
			this.bairro = dadosEndereco.bairro();

		if (dadosEndereco.cep() != null)
			this.cep = dadosEndereco.cep();

		if (dadosEndereco.cidade() != null)
			this.cidade = dadosEndereco.cidade();

		if (dadosEndereco.complemento() != null)
			this.complemento = dadosEndereco.complemento();

		if (dadosEndereco.numero() != null)
			this.numero = dadosEndereco.numero();

		if (dadosEndereco.uf() != null)
			this.uf = dadosEndereco.uf();

	}

}
