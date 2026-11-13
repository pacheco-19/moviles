package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ManejadorGlobalDeExcepciones {

    @ExceptionHandler(MovilNoEncontradoException.class)
    public String movilNoEncontrado(MovilNoEncontradoException ex, RedirectAttributes flash) {
        flash.addFlashAttribute("error", ex.getMessage());
        return "redirect:/moviles";
    }
}