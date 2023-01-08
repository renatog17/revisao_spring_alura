package medi.voli.api.medico.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medi.voli.api.endereco.dto.DadosEndereco;
import medi.voli.api.medico.Especialidade;

public record DadosCadastroMedico( 
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email,
		@NotBlank
		String telefone,
		@NotBlank 
		@Pattern(regexp = "\\d{4,6}")
		String crm, 
		@NotNull //não preciso validar os enuns, o spring fará isso
		Especialidade especialidade,
		@NotNull
		@Valid //essa anotação serve para informar ao spring que dentro do objeto a seguir tbm haverá anotações de validação
		DadosEndereco endereco) {

}
