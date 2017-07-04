/**
 * Created by anyderre on 04/07/17.
 */
import Entities.Autobus;
import Entities.Coordenada;
import Entities.RaspberryPiAPI;
import Entities.Ruta;
import Services.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController {
    @Autowired
    private AutobusServices autobusServices;
    @Autowired
    private ParadaServices paradaServices;
    @Autowired
    private ChequeoServices chequeoServices;
    @Autowired
    private CoordenadaServices coordenadaServices;
    @Autowired
    private RaspberryPiServices raspberryPiServices;
    @Autowired
    private RutaServices rutaServices;
    /*
     /**
     * Recuperando información desde la URL
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/autobus/buscar/{id}", method = RequestMethod.GET, produces = "application/json")
    public String autobus(@PathVariable long id){
        Autobus autobus = autobusServices.buscarUnAutobus(id);
        Gson gson = new Gson();
        return gson.toJson(autobus);
    }
    /**
     *
     * Obtener Listado de autobus de una Ruta
     * @param id
     * @return
     */
    @RequestMapping(value ="/api/autobuses/buscar/rutas", method = RequestMethod.GET, produces = "application/json")
    public String obetenerAutobusPorRuta(@RequestParam("id_ruta")long id){
        Ruta ruta =rutaServices.buscarRutaPorId(id);
        if(ruta==null){
            return new Gson().toJson("Esta ruta no existe");
        }
        List <Autobus> autobuses = autobusServices.buscarTodosLosAutobusporRuta(ruta.get_id());
        return new Gson().toJson(autobuses);
    }

    /**
     *
     * guardar un autobus
     * @return
     */
    @RequestMapping(value ="/api/autobus/guardar", method = RequestMethod.POST, consumes = "application/json")
    public String guardarAutobus(@RequestBody Autobus autobus){
        Autobus autobus1 = autobusServices.guardarAutobus(autobus);
        if(autobus1!=null){
            return "Autobus guardado satisfactoriamentete";
        }
        return "no se ha podido guardar el autobus";
    }

    /**
     *
     * modificar coordenada de un autobus
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/autobus/modificar/posicion/{id}", method =RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public String modificarCoordenadaAutobus(@PathVariable long id, @RequestBody Autobus autobus){
        Autobus autobus1 = autobusServices.buscarUnAutobus(id);
        if(autobus1 == null){
            return "El autobus que quieres modificar no existe";
        }
        if(autobusServices.modifcarCoordenadaAutobus(autobus)){
            return "Autobus modificado exitosamente";
        };
        return "no se pudo guardar el autobus";

    }
    /**
     *
     * modificar posicion de un autobus
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/autobus/modificar/estado/{id}", method =RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public String modificarPosicionAutobus(@PathVariable long id, @RequestBody Autobus autobus){
        Autobus autobus1 = autobusServices.buscarUnAutobus(id);
        if(autobus1 == null){
            return "El autobus que quieres modificar no existe";
        }
        if(autobusServices.modificarEstadoAutobus(autobus)){
            return "Autobus modificado exitosamente";
        };
        return "no se pudo guardar el autobus";

    }

    /**
     *
     * modificar posicion de un autobus
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/autobusmodificar/cantidadPasajeros/{id}", method =RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public String modificarCantiddadPasajerosAutobus(@PathVariable long id, @RequestBody Autobus autobus){
        Autobus autobus1 = autobusServices.buscarUnAutobus(id);
        if(autobus1 == null){
            return "El autobus que quieres modificar no existe";
        }
        if(autobusServices.modificarCantidadPasajeros(autobus)){
            return "Autobus modificado exitosamente";
        };
        return "no se pudo guardar el autobus";

    }
//----------------------------------------Parada

}
