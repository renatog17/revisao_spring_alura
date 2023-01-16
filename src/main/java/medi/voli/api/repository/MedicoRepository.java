package medi.voli.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import medi.voli.api.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	Page<Medico> findAllByAtivoTrue(Pageable paginacao);

	
}
