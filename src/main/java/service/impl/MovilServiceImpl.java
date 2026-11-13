package service.impl;

import exception.MovilNoEncontradoException;
import model.Movil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MovilRepository;
import service.MovilService;

import java.util.List;

@Service
@Transactional
public class MovilServiceImpl implements MovilService {

    private final MovilRepository repository;

    public MovilServiceImpl(MovilRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movil> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movil buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MovilNoEncontradoException(id));
    }

    @Override
    public Movil guardar(Movil movil) {
        return repository.save(movil);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new MovilNoEncontradoException(id);
        }
        repository.deleteById(id);
    }
}