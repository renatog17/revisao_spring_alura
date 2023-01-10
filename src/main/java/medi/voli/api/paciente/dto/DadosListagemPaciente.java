package medi.voli.api.paciente.dto;

import medi.voli.api.paciente.Paciente;

public record DadosListagemPaciente(
		Long id,
		String nome,
		String email,
		String cpf) {

	public DadosListagemPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
	}
}
