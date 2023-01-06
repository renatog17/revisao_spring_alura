package medi.voli.api.medico;

import medi.voli.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
		DadosEndereco endereco) {

}
