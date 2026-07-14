package pe.com.fravadent.controller.generic;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.fravadent.service.generic.GenericoService;

public abstract class GenericoController<T> {
    protected abstract GenericoService<T> getServicio();
    protected abstract String getRuta();
    protected abstract String getVistaListar();
    protected abstract String getVistaRegistrar();
    protected abstract String getVistaActualizar();
    protected abstract String getVistaHabilitar();
    protected abstract String getNombreLista();
    protected abstract String getNombreObjeto();
    protected abstract T crearObjeto();
    protected void cargarCombos(Model modelo) {}

    @GetMapping("/listar")
    public String listar(Model modelo) {
        modelo.addAttribute(getNombreLista(), getServicio().findAllCustom());
        return getVistaListar();
    }

    @GetMapping("/registrar")
    public String registro(Model modelo) {
        modelo.addAttribute(getNombreObjeto(), crearObjeto());
        cargarCombos(modelo);
        return getVistaRegistrar();
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarVista(@PathVariable Long id, Model modelo) {
        modelo.addAttribute(getNombreObjeto(), getServicio().findById(id));
        cargarCombos(modelo);
        return getVistaActualizar();
    }

    @GetMapping("/habilitar_vista")
    public String habilitarVista(Model modelo) {
        modelo.addAttribute(getNombreLista(), getServicio().findAll());
        return getVistaHabilitar();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        getServicio().delete(id);
        return "redirect:/" + getRuta() + "/listar";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitar(@PathVariable Long id) {
        getServicio().enable(id);
        return "redirect:/" + getRuta() + "/habilitar_vista";
    }

    @GetMapping("/deshabilitar/{id}")
    public String deshabilitar(@PathVariable Long id) {
        getServicio().delete(id);
        return "redirect:/" + getRuta() + "/habilitar_vista";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute T obj) {
        getServicio().add(obj);
        return "redirect:/" + getRuta() + "/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@ModelAttribute T obj, @PathVariable Long id) {
        getServicio().update(obj, id);
        return "redirect:/" + getRuta() + "/listar";
    }
}
