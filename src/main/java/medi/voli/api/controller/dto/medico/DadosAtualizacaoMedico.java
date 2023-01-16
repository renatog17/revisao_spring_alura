package medi.voli.api.controller.dto.medico;

import jakarta.validation.constraints.NotNull;
import medi.voli.api.controller.dto.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id,
		String telefone,
		String nome,
		DadosEndereco dadosEndereco
		) {

}
