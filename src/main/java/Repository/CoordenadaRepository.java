package Repository;

import Entities.Coordenada;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by anyderre on 30/06/17.
 */
public interface CoordenadaRepository extends CrudRepository<Coordenada, Long> {

    List<Coordenada> findAll();

    Coordenada findBy_id(Long id);

    Coordenada save(Coordenada coordenada);
}
