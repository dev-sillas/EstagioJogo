package br.com.duxusdesafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.repository.ComposicaoTimeRepository;


@RestController
@RequestMapping("/api/composicaoTime")
public class ComposicaoTimeController {

	@Autowired
	private ComposicaoTimeRepository composicaoTimeRepository;

 	/* @GetMapping("/{id}")
	public ComposicaoTime getById(@PathVariable Long id) {

		ComposicaoTime composicao= composicaoTimeRepository.findById(id).get();
		return composicao;
	 }*/


	@PostMapping
	public ComposicaoTime insert(@RequestBody ComposicaoTime composicaoTime) {

		ComposicaoTime composicaoTimeSave = composicaoTimeRepository.save(composicaoTime);
		return composicaoTimeSave; 
	}


	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {

		ComposicaoTime composicaoTime = composicaoTimeRepository.findById(id).get();
		composicaoTimeRepository.deleteById(id);
		return "Excluido com sucesso!";
	}

	
}

