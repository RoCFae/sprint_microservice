package br.com.fiap.sprint_microsservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.fiap.sprint_microsservice.model.Veiculo;
import br.com.fiap.sprint_microsservice.repository.VeiculoRepository;

@Controller
@RequestMapping("veiculos")
public class VeiculoViewController {

	private VeiculoRepository veiculoRepository;

	public VeiculoViewController(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	@GetMapping
	public String listVeiculos(Model model) {
		model.addAttribute("veiculos", veiculoRepository.findAll());
		return "veiculo/list";
	}

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("veiculo", new Veiculo());
		return "veiculo/form";
	}

	@GetMapping("/{id}")
	public String findById(@PathVariable Long id, Model model) {
		model.addAttribute("veiculo", veiculoRepository.findById(id).get());
		return "veiculo/form";
	}

	@GetMapping("/{id}/delete")
	public RedirectView delete(@PathVariable Long id) {
		veiculoRepository.deleteById(id);
		RedirectView redirectView = new RedirectView("/veiculos");
		return redirectView;
	}

	@PostMapping("/save")
	public RedirectView saveVeiculo(@ModelAttribute("veiculo") Veiculo veiculo, RedirectAttributes attrs) {
		// salvar o veiculo

		Veiculo savedVeiculo = veiculoRepository.save(veiculo);

		// redirecionar para a tela de cadastros GET /addVeiculo
		
		attrs.addFlashAttribute("addVeiculoSucess", true);
		attrs.addFlashAttribute("savedVeiculo", savedVeiculo);

		RedirectView redirectView = new RedirectView("/veiculos");
		return redirectView;
	}

}
