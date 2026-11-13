package service;

import model.Movil;

import java.util.List;

public interface MovilService {
    List<Movil> listar();

    Movil buscarPorId(Long id);

    Movil guardar(Movil movil);

    void eliminar(Long id);
}
