package medi.voli.api.controller.dto.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import medi.voli.api.controller.dto.endereco.DadosEndereco;

public record DadosCadastroPaciente(
		@NotBlank
		String nome, 
		@NotBlank
		@Email
		String email, 
		@NotBlank
		String telefone, 
		@NotBlank
		@Size(max = 11, min = 11)
		String cpf,
		@NotNull
		@Valid
		DadosEndereco endereco) {
}
