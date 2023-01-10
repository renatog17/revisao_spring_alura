package medi.voli.api.paciente.dto;

import jakarta.validation.constraints.NotNull;
import medi.voli.api.endereco.dto.DadosEndereco;

public record DadosAtualizaoPaciente(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco dadosEndereco) {

}
