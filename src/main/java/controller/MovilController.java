package controller;

import model.Movil;
import model.SistemaOperativo;
import model.TipoPantalla;
import service.MovilService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/moviles")
public class MovilController {

    private final MovilService service;

    public MovilController(MovilService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("moviles", service.listar());
        return "moviles/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("movil", new Movil());
        cargarOpciones(model);
        return "moviles/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("movil", service.buscarPorId(id));
        cargarOpciones(model);
        return "moviles/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("movil") Movil movil,
                          BindingResult result,
                          Model model,
                          RedirectAttributes flash) {
        if (result.hasErrors()) {
            cargarOpciones(model);
            return "moviles/formulario";
        }
        boolean esNuevo = movil.getId() == null;
        service.guardar(movil);
        flash.addFlashAttribute("ok", esNuevo ? "Móvil creado correctamente" : "Móvil actualizado correctamente");
        return "redirect:/moviles";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        service.eliminar(id);
        flash.addFlashAttribute("ok", "Móvil eliminado correctamente");
        return "redirect:/moviles";
    }

    private void cargarOpciones(Model model) {
        model.addAttribute("sistemas", SistemaOperativo.values());
        model.addAttribute("pantallas", TipoPantalla.values());
    }
}