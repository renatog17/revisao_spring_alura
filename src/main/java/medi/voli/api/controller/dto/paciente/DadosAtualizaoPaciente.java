package medi.voli.api.controller.dto.paciente;

import jakarta.validation.constraints.NotNull;
import medi.voli.api.controller.dto.endereco.DadosEndereco;

public record DadosAtualizaoPaciente(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco dadosEndereco) {

}
