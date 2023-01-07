package medi.voli.api.endereco;

import jakarta.persistence.Embeddable;

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

}
