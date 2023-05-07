package pe.edu.cibertec.DAWI_CL1_CESAR_LEIVA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.DAWI_CL1_CESAR_LEIVA.model.bd.Especialidad;
import pe.edu.cibertec.DAWI_CL1_CESAR_LEIVA.service.EspecialidadService;

@RequestMapping("/Especialidad")
@Controller
public class EspecialidadController {

	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping ("/frmLista")
	public String frmlista(Model model) {
		model.addAttribute("listaespecialidad", especialidadService.listarEspecialidad());
		return "Especialidad/frmLista";
	}

	@GetMapping("/frmRegEspe")
	public String frmRegEstado(Model model) {
		model.addAttribute("especForm", new Especialidad());
		model.addAttribute("visualizar", false);
		return "Estado/frmRegEstado";
	}

	@PostMapping("frmRegEspe")
	public String registrarEstado(@ModelAttribute("especForm") Especialidad especialidad, Model model) {
		String mensaje = "Estado registrado correctamente";
		try {
			especialidadService.registrarEspecialidad(especialidad);
		} catch (Exception e) {
			mensaje = "Estado no registrado";
		}
		model.addAttribute("estadoForm", new Especialidad());
		model.addAttribute("visualizar", true);
		model.addAttribute("respuesta", mensaje);
		return "Estado/frmRegEstado";
	}
}
