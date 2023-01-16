package medi.voli.api.controller.dto.medico;

import medi.voli.api.domain.Endereco;
import medi.voli.api.domain.Medico;
import medi.voli.api.domain.enumeracoes.Especialidade;

public record DadosDetalhamentoMedico(Long id, 
		String nome, 
		String email, 
		String crm, 
		String telefone, 
		Especialidade especialidade, 
		Endereco endereco){

	public DadosDetalhamentoMedico(Medico medico) {
		this(medico.getId(), 
				medico.getNome(), 
				medico.getEmail(), 
				medico.getCrm(), 
				medico.getTelefone(), 
				medico.getEspecialidade(),
				medico.getEndereco());
	}


}
