package Repository;

import Entities.Chequeo;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by anyderre on 30/06/17.
 */
public interface ChequeoRepository extends CrudRepository<Chequeo, BigInteger> {

    Chequeo save (Chequeo chequeo);

    //List<Chequeo> findAll();

    List<Chequeo> findAllBy_esEntradaAnd_fechaRegistrada(boolean esEntrada, long fechaRegistrada);

    List<Chequeo> findAllBy_fechaRegistradaBetween(long fecha1, long fecha2);

    List<Chequeo> findAllBy_fechaRegistradaGreaterThan(long fechaRegistrada);

    List<Chequeo> findAllBy_fechaRegistradaLessThan(long fechaRegistrada);

    //Actividad en una parada
    List<Chequeo> findChequeoBy_parada__idOrderBy_fechaRegistrada(long id);


    List<Chequeo> findChequeoBy_parada__idAnd_esEntradaAnd_fechaRegistrada(long id, boolean esEntrada, long fechaRegistrada);


    Boolean deleteChequeoBy_fechaRegistrada(long fechaRegistrada);

    Boolean deleteChequeoBy_fechaRegistradaGreaterThan(Long fechaRegistrada);

    Boolean deleteChequeoBy_fechaRegistradaBetween(long fecha1, long fecha2);
}
