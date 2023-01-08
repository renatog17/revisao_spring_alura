package medi.voli.api.controller;

import medi.voli.api.medico.Especialidade;
import medi.voli.api.medico.Medico;

public record DadosListagemMedico(
		Long id,
		String nome,
		String email,
		String crm,
		Especialidade especialidade
		) {

	public DadosListagemMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
