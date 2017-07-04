package Services;

import Entities.Coordenada;
import Repository.CoordenadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by anyderre on 01/07/17.
 */
@Service
public class CoordenadaServices {
    @Autowired
    public CoordenadaRepository coordenadaRepository;

    public Coordenada buscarUnaCoordenada(long id){
        return coordenadaRepository.findBy_id(id);
    }

    public Coordenada guardarCoordenada(Coordenada coordenada){
        return coordenadaRepository.save(coordenada);
    }

}
