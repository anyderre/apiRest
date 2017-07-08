/**
 * Created by anyderre on 04/07/17.
 */
import Entities.*;
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
        if (autobus==null){
            return new Gson().toJson("no existe tal autobus");
        }
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
            return new Gson().toJson("Autobus guardado satisfactoriamentete");
        }
        return new Gson().toJson("no se ha podido guardar el autobus");
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
            return new Gson().toJson("Autobus modificado exitosamente");
        };
        return new Gson().toJson("no se pudo guardar el autobus");

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
            return new Gson().toJson("El autobus que quieres modificar no existe");
        }
        if(autobusServices.modificarEstadoAutobus(autobus)){
            return new Gson().toJson( "Autobus modificado exitosamente");
        };
        return new Gson().toJson(
        "no se pudo guardar el autobus");

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
            return new Gson().toJson("El autobus que quieres modificar no existe");
        }
        if(autobusServices.modificarCantidadPasajeros(autobus)){
            return new Gson().toJson("Autobus modificado exitosamente");
        };
        return new Gson().toJson("no se pudo guardar el autobus");

    }
//----------------------------------------Parada---------------------------------------
    @RequestMapping(value = "/api/paradas/ruta/{id}", method = RequestMethod.GET, produces = "application/json")
    public String buscarParadasRuta(@PathVariable long id){
        Ruta ruta = rutaServices.buscarRutaPorId(id);
        if(ruta==null){
            return new Gson().toJson("esta ruta no existe");
        }
        List<Parada> paradas = paradaServices.buscarParadaPorRutaId(id);
        if(paradas.isEmpty()){
            return new Gson().toJson("no se encontro ninguna parada para esta ruta");
        }
        return new Gson().toJson(paradas);
    }
//---------------------------------------Ruta-------------------------------------------
    @RequestMapping(value = "/api/ruta/{id}", method = RequestMethod.GET, produces = "application/json")
    public String buscarRuta(@PathVariable long id){
        Ruta ruta =rutaServices.buscarRutaPorId(id);
        if(ruta==null){
            return new Gson().toJson("Esta ruta no existe");
        }
        return  new Gson().toJson(ruta);
    }
//-------------------------------------Chequeo-----------------------------------------------

    @RequestMapping(value="/api/chequeo/guardar", method = RequestMethod.GET, consumes = "application/json")
    public String guardarChequeo(@RequestBody Chequeo chequeo){
        //obteniendo la parada mas cerca a ese punto
        chequeo.set_parada(getParadaReal(chequeo));

        chequeo.setRaspberryPiAPI(raspberryPiServices.buscarRaspberryPiPorMacAddress(chequeo.getRaspberryPiAPI().get_macAddress()));
        return new Gson().toJson(chequeoServices.guardarChequeo(chequeo));

    }
    private void updateEstadoYRutaAutobus(Parada parada){
        Autobus autobus = parada.
        autobus.set_ruta(parada.get_ruta());
//        autobusServices.modificarRutaAutobus(autobus);
    }
    private Parada getParadaReal(Chequeo chequeo){
        String macAddress = chequeo.getRaspberryPiAPI().get_macAddress();
        Autobus autobus = autobusServices.buscarAutobusPorRaspberryMacddress(macAddress);
        Ruta ruta = autobus.get_ruta();
        List<Parada> paradas = paradaServices.buscarParadaPorRutaId(ruta.get_id());
        int cont =1;
        double distancia=1000000000;
        double distanciaActual=0;
        int indexes=0;
        for(Parada parada:paradas){
            distanciaActual =Math.sqrt(Math.pow((parada.get_coordenada().get_latitude()-chequeo.get_parada().get_coordenada().get_latitude()), 2)+Math.pow((parada.get_coordenada().get_longitude()-chequeo.get_parada().get_coordenada().get_longitude()),2));
            if (distanciaActual<distancia){
                //distancia =distanciaActual;
                indexes = cont;
            }
            cont++;
        }
        Parada parada=paradas.get(indexes);
//
        return parada;
    }
}
