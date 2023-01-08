package medi.voli.api.medico.dto;

import jakarta.validation.constraints.NotNull;
import medi.voli.api.endereco.dto.DadosEndereco;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id,
		String telefone,
		String nome,
		DadosEndereco dadosEndereco
		) {

}
