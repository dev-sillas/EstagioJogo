package br.com.duxusdesafio.model.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.duxusdesafio.model.Integrante;


public interface IntegranteRepository extends JpaRepository<Integrante, Long> {

	Optional<Integrante> findByNome(String nome);
	/* @Query("select g.nome, c.data from integrante g join composicao_time a"
	+"on g.id=a.integrante_id"
	+"join time c "
	+"on c.id= a.time_id"
	+"where c.data = :data")
	List<Integrante> findBydata(@Param("data") LocalDate date);
*/
}