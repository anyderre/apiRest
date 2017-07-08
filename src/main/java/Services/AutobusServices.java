package Services;

import Entities.Autobus;
import Entities.Ruta;
import Repository.AutobusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by anyderre on 01/07/17.
 */
@Service
public class AutobusServices {
    @Autowired
    AutobusRepository autobusRepository;


    public List<Autobus> buscarTodoLosAutobus(){
        return autobusRepository.findAll();
    }

    public List<Autobus> buscarTodosLosAutobusporRuta(Long id){
        return autobusRepository.findAutobusesBy_ruta__id(id);
    }

    @Transactional
    public Autobus guardarAutobus(Autobus autobus){
        return autobusRepository.save(autobus);
    }

    public Autobus buscarAutobusPorId(Long id){
        return autobusRepository.findAutobusBy_id(id);
    }

    public boolean eliminarAutobusporId(long id){
        return autobusRepository.deleteAutobusBy_id(id);
    }

    @Transactional
    public Boolean modificarEstadoAutobus(Autobus autobus){
       return autobusRepository.modifyEstadoAutobusById(autobus.is_activo(), autobus.get_ultimaFechaModificada(), autobus.get_id());
    }

    @Transactional
    public Boolean modifcarCoordenadaAutobus(Autobus autobus){
        return  autobusRepository.modifyCoordenadaAutobusById(autobus.get_coordenada(), autobus.get_ultimaFechaModificada(), autobus.get_id());
    }

    @Transactional
    public Boolean modificarCantidadPasajeros(Autobus autobus){
        return autobusRepository.modifyCantidadPasajerosActualDelAutobusById(autobus.get_cantidadDePasajerosActual(), autobus.get_ultimaParada()
        ,autobus.get_ultimaFechaModificada(), autobus.get_id());
    }

    public Autobus buscarUnAutobus(long id){
        return autobusRepository.findAutobusBy_id(id);
    }

    public Autobus buscarAutobusPorRaspberryMacddress(String macAddress){
        return autobusRepository.findAutobusBy_raspberryPi_macAddress(macAddress);
    }

    public List<Autobus> buscarAutobusActivosYPorRuta(boolean activo, Ruta ruta){
        return  autobusRepository.findAllBy_activoAnd_ruta(activo, ruta);
    }

    public Boolean modificarRutaAutobus(Autobus autobus){
        return autobusRepository.modifyRutaActualAutobus(autobus.get_ruta(),autobus.get_id());
    }
}
