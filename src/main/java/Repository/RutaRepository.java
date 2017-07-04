package Repository;

import Entities.Ruta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by anyderre on 30/06/17.
 */
public interface RutaRepository extends CrudRepository<Ruta, Long> {
    //Encontrar ruta por nombre Corredor
    List<Ruta> findAllBy_nombreCorredor(String nombre);

    //Encontrar todas las rutas
    List<Ruta> findAll();

    //encontrar ruta con id
    Ruta findRutaBy_id(Long id);

    //Guardar Ruta
    Ruta save(Ruta ruta);

    //eliminar una ruta por su id
    Ruta deleteBy(Long id);

    @Modifying
    @Query("UPDATE Ruta r SET r._distanciaTotal = :distanciaTotal, r._esDireccionSubida=:esDireccionSubida, r._fechaUltimaModificacion=:_fechaUltimaModificacion, r._nombreCorredor=:nombreCorredor WHERE c.id = :id")
    Boolean modifyRutaById(@Param("distanciaTotal")float distanciaTotal, @Param("esDireccionSubida")boolean esDireccionSubida, @Param("_fechaUltimaModificacion")long fechaUltimaModificacion , @Param("nombreCorredor") String nombreCorredor, @Param("id") long id);




}
