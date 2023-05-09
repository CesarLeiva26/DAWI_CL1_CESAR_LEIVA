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

@Controller
@RequestMapping("/Especialidad")
public class EspecialidadController {

	@Autowired
	private EspecialidadService especialidadService;

	@GetMapping("/frmLista")
	public String frmlista(Model model) {
		model.addAttribute("listaespecialidad", especialidadService.listarEspecialidad());
		return "Especialidad/frmLista";
 
	}

	@GetMapping("/frmRegistro")
	public String frmRegEspecialidad(Model model) {
		model.addAttribute("especialidadForm", new Especialidad());
		model.addAttribute("visualizar", false);
		return "Especialidad/frmRegistro";
	}

	@PostMapping("frmRegistro")
	public String frmRegEspecialidad(@ModelAttribute("especialidadForm") Especialidad especialidad, Model model) {
		String mensaje = "Especialidad registrado correctamente";
		try {
			especialidadService.registrarEspecialidad(especialidad);
		} catch (Exception e) {
			mensaje = "Estado no registrado";
		}
		model.addAttribute("especialidadForm", new Especialidad());
		model.addAttribute("visualizar", true);
		model.addAttribute("respuesta", mensaje);
		return "Especialidad/frmRegistro";
	}


}