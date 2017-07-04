package Repository;

import Entities.RaspberryPiAPI;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by anyderre on 30/06/17.
 */
public interface ReaspberryPiRepository extends CrudRepository<RaspberryPiAPI, Long> {
    //Encontrar un raspberry por su id
    RaspberryPiAPI findRaspberryPiAPIBy_id(long id);

    RaspberryPiAPI findRaspberryPiAPIBy_macAddres(String macAddress);

    //Eliminar un raspberry por su id
    boolean deleteRaspberryPiAPIBy_macAddress(String macAddress);

    boolean deleteRaspberryPiAPIBy_id(long id);

    //Guardar un raspberry
    RaspberryPiAPI save(RaspberryPiAPI raspberryPiAPI);

    //encontrar todos los raspberry
    List<RaspberryPiAPI> findAll();

    //Encontrar raspberry de un autobus
    RaspberryPiAPI findRaspberryPiAPIByAutobus__id(long id);

    @Modifying
    @Query("UPDATE RaspberryPiAPI r SET r._ipAddress = :ipAddress, r._macAddress=:macAddress, r._numeroSerial=:numeroSerial, r._puerto=:puerto WHERE r.id = :id")
    Boolean modifyRutaById(@Param("ipAddress")String ipAddress, @Param("macAddress")String macAddress, @Param("numeroSerial")String numeroSerial, @Param("puerto")int puerto , @Param("id") long id);


}
