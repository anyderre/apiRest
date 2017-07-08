package Repository;

import Entities.Coordenada;
import Entities.Parada;
import Entities.Ruta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by anyderre on 30/06/17.
 */
public interface ParadaRepository extends CrudRepository<Parada, Long> {
    //Eliminar una parada
    Parada deleteBy_id(long id);

    //mostrar todas las paradas
    List<Parada> findAll();

    Parada save(Parada parada);


    Parada findParadaBy_coordenada(Coordenada coordenada);

    //mostrar las paradas de una ruta dada
    List<Parada> findAllBy_ruta__id(long id);

    //Eliminar las paradas de una ruta
    Boolean deleteAllBy_ruta_id(long id);

    //Mostrar una parada
    Parada findBy_id(long id);

    //modificar una parada
    @Modifying
    @Query("UPDATE Parada p SET p._coordenada = :coordenada, p._nombre=:nombre, p._ruta=:ruta,p._paradaAnterior=:paradaAnterior, p._ParadaSiguiente=:paradaSiguiente WHERE p._id=:id")
    Boolean modifyParadaById(@Param("coordenada")Coordenada coordenada, @Param("nombre")String nombre, @Param("ruta") Ruta ruta, @Param("paradaAnterior")Parada paradaAnterior, @Param("paradaSiguiente")Parada paradaSiguiente, @Param("id")Long id);


}