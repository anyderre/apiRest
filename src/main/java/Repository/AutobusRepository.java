package Repository;

import Entities.Autobus;
import Entities.Coordenada;
import Entities.Parada;
import Entities.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by anyderre on 29/06/17.
 */
public interface AutobusRepository extends CrudRepository<Autobus,Long> {

    //buscar un autobus por id
    Autobus findAutobusBy_id(long id);

    //buscando la lista de los autobus que hay en un ruta
    List<Autobus> findAutobusesBy_ruta__id(long id);

    //agregando un autobus en la base de datos
    Autobus save(Autobus autobus);

    //leer todos los autobuses
    List<Autobus> findAll();

    //buscar un autobus por macAddress del raspberry
    Autobus findAutobusBy_raspberryPi_macAddress(String macAddress);

    //buscar los autobus que son activos
    List<Autobus> findAllBy_activoAnd_ruta(boolean esActivo, Ruta ruta);

    //eliminando un autobus
    Boolean deleteAutobusBy_id(long id);

    //Modificando el estado del autobus
    @Modifying
    @Query("UPDATE Autobus a SET a._activo = :activo, a._ultimaFechaModificada=:ultimaFechaModificada WHERE a.id = :id")
    Boolean modifyEstadoAutobusById(@Param("activo") boolean activo, @Param("ultimaFechaModificada") long ultimaModificacion, @Param("id") long id);

    //Modificando posicion actual del autobus
    @Modifying
    @Query("UPDATE Autobus a SET a._coordenada = :coordenada, a._ultimaFechaModificada=:ultimaFechaModificada WHERE a.id = :id")
    Boolean modifyCoordenadaAutobusById(@Param("coordenada") Coordenada coordenada, @Param("ultimaFechaModificada") long ultimaModificacion, @Param("id") long id);

    //Modificando cantidad de pasajeros actual actual del autobus
    @Modifying
    @Query("UPDATE Autobus a SET a._cantidadDePasajerosActual = :cantidadActual,a._ultimaParada=ultimaParada, a._ultimaFechaModificada=:ultimaFechaModificada WHERE a.id = :id")
    Boolean modifyCantidadPasajerosActualDelAutobusById(@Param("cantidadActual") int cantidadActual, @Param("ultimaParada") Parada ultimaParada, @Param("ultimaFechaModificada") long ultimaModificacion, @Param("id") long id);

    //Modificando cantidad de pasajeros actual actual del autobus
    @Modifying
    @Query("UPDATE Autobus a SET a._ruta = :ruta WHERE a.id = :id")
    Boolean modifyRutaActualAutobus(@Param("ruta") Ruta ruta, @Param("id") long id);

}