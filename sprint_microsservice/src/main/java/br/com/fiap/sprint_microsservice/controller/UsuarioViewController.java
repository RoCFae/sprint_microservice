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

import br.com.fiap.sprint_microsservice.model.Usuario;
import br.com.fiap.sprint_microsservice.repository.UsuarioRepository;

@Controller
@RequestMapping("usuarios")
public class UsuarioViewController {

	private UsuarioRepository usuarioRepository;

	public UsuarioViewController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping
	public String listUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "usuario/list";
	}

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
	}

	@GetMapping("/{id}")
	public String findById(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", usuarioRepository.findById(id).get());
		return "usuario/form";
	}

	@GetMapping("/{id}/delete")
	public RedirectView delete(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		RedirectView redirectView = new RedirectView("/usuarios");
		return redirectView;
	}

	@PostMapping("/save")
	public RedirectView saveUsuario(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attrs) {
		// salvar o usuario

		Usuario savedUsuario = usuarioRepository.save(usuario);

		// redirecionar para a tela de cadastros GET /addUsuario
		
		attrs.addFlashAttribute("addUsuarioSucess", true);
		attrs.addFlashAttribute("savedUsuario", savedUsuario);

		RedirectView redirectView = new RedirectView("/usuarios");
		return redirectView;
	}

}