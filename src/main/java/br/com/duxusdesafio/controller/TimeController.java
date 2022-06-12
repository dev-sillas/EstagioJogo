package br.com.duxusdesafio.controller;

import java.util.Optional;

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

import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.model.repository.TimeRepository;

@RestController
@RequestMapping("/api/time")
public class TimeController {

	@Autowired
	private TimeRepository timeRepository;

	@GetMapping("/{id}")
	public Time getById(@PathVariable Long id) {

		Time time = timeRepository.findById(id).get();
		return time;
	}

	@PostMapping
	public Time insert(@RequestBody Time time) {

		Time timeSave = timeRepository.save(time);
		return timeSave; 
	}

	@PutMapping("/{id}")
	public Time update(@RequestBody Time time, @PathVariable Long id) {

		
		Time timeUpdate = timeRepository.findById(id).get();

		// Atualiza os dados
		timeUpdate.setData(time.getData());

		// Salvar a atualizacao
		timeRepository.save(timeUpdate);

		return timeUpdate;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {

		Time time = timeRepository.findById(id).get();
		timeRepository.deleteById(id);
		return "Excluido com sucesso!";
	}
	
}

