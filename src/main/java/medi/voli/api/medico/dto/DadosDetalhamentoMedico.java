package medi.voli.api.medico.dto;

import medi.voli.api.endereco.Endereco;
import medi.voli.api.medico.Especialidade;
import medi.voli.api.medico.Medico;

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
