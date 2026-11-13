package repository;

import model.Movil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovilRepository extends JpaRepository<Movil, Long> {
}
