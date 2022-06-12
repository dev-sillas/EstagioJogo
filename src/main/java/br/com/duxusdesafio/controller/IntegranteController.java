package br.com.duxusdesafio.controller;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.repository.IntegranteRepository;

@RestController
@RequestMapping("/api/integrante")
public class IntegranteController {

	@Autowired
	private IntegranteRepository integranteRepository;

	@GetMapping
	public List<Integrante> listAll() {

		List<Integrante> integrantes = integranteRepository.findAll();
		return integrantes;
	}

	@GetMapping("/{id}")
	public Integrante getById(@PathVariable Long id) {

		Integrante integrante = integranteRepository.findById(id).get();
		return integrante;
	}

	@PostMapping
	public Integrante insert(@RequestBody Integrante integrante) {

		Integrante integranteSave = integranteRepository.save(integrante);
		return integranteSave; 
	}

	@PutMapping("/{id}")
	public Integrante update(@RequestBody Integrante integrante, @PathVariable Long id) {
		Integrante integranteUpdate = integranteRepository.findById(id).get();
		integranteUpdate.setFranquia(integrante.getFranquia());
		integranteUpdate.setNome(integrante.getNome());
		integranteUpdate.setFuncao(integrante.getFuncao());
		integranteRepository.save(integranteUpdate);

			return integranteUpdate;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		Integrante integrante = integranteRepository.findById(id).get();
		integranteRepository.deleteById(id);
		return "Excluido com sucesso!";
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Integrante> getByNome(@PathVariable String nome) {

		Optional<Integrante> integrante = integranteRepository.findByNome(nome);

		if (integrante.isPresent()) {
			return ResponseEntity.ok(integrante.get());
		}

		return ResponseEntity.notFound().build();
	}


    /**
     * Vai retornar uma lista com os nomes dos integrantes do time daquela data
     */
	@GetMapping("/data/{date}")
	public ResponseEntity<Integrante> getBydata(@PathVariable LocalDate date) {

		Optional<Integrante> integrante = integranteRepository.findBydata(date);

		if (integrante.isPresent()) {
			return ResponseEntity.ok(integrante.get());
		}

		return ResponseEntity.notFound().build();
	}
	
	/*	@GetMapping("/data/{data}")
	public List<Integrante> getDaIntegrante(@PathVariable LocalDate date) {
		return  integranteRepository.findBydata(date);
	} */


	
}

