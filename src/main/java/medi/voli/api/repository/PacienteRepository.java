package medi.voli.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import medi.voli.api.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}
