package Services;

import Entities.Parada;
import Repository.ParadaRepository;
import org.hibernate.loader.collection.PaddedBatchingCollectionInitializerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by anyderre on 01/07/17.
 */
@Service
public class ParadaServices {
    @Autowired
    ParadaRepository paradaRepository;

    public Parada eliminarParadaPor(long id){
        return paradaRepository.deleteBy_id(id);
    }
    public boolean eliminarParadaPorRutaId(long id){
        return paradaRepository.deleteAllBy_ruta_id(id);
    }

    public Parada encontrarParadaPorId(long id){
        return paradaRepository.findBy_id(id);
    }

    @Transactional
    public Parada guardarParada(Parada parada){
        return paradaRepository.save(parada);
    }

    public List<Parada> buscarParadaPorRutaId(long id){
        return paradaRepository.findAllBy_ruta__id(id);
    }

    Boolean modificarParadaPorId(Parada parada){
        return paradaRepository.modifyParadaById(parada.get_coordenada(),parada.get_nombre(),parada.get_ruta(),parada.get_paradaAnterior(),parada.get_ParadaSiguiente(),parada.get_id());
    }
}
