package medi.voli.api.controller;

import jakarta.validation.constraints.NotNull;
import medi.voli.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id,
		String telefone,
		String nome,
		DadosEndereco dadosEndereco
		) {

}
