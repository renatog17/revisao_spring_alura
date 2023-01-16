package medi.voli.api.controller.dto.medico;

import medi.voli.api.domain.Medico;
import medi.voli.api.domain.enumeracoes.Especialidade;

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
