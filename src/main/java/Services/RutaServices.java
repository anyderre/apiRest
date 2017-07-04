package Services;

import Entities.Ruta;
import Repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anyderre on 01/07/17.
 */
@Service
public class RutaServices {
    @Autowired
    RutaRepository rutaRepository;

    public List<Ruta> buscarRutaPorNombreCorredor(String nombre){
        return rutaRepository.findAllBy_nombreCorredor(nombre);
    }

    public List<Ruta> buscarTodasLasRutas(){
        return rutaRepository.findAll();
    }

    public Ruta buscarRutaPorId(long id){
        return rutaRepository.findRutaBy_id(id);
    }

    public Ruta guardarRuta(Ruta ruta){
        return rutaRepository.save(ruta);
    }

    public Ruta eliminarRutaPorId(long id){
        return rutaRepository.deleteBy(id);
    }

    public boolean modificarRutaPorId(Ruta ruta){
        return rutaRepository.modifyRutaById(ruta.get_distanciaTotal(), ruta.is_esDireccionSubida(),ruta.get_fechaUltimaModificacion(),ruta.get_nombreCorredor(),ruta.get_id());
    }
}
