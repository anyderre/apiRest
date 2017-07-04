package Services;

import Entities.Chequeo;
import Entities.Parada;
import Repository.ChequeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by anyderre on 01/07/17.
 */
@Service
public class ChequeoServices {
    @Autowired
    ChequeoRepository chequeoRepository;

    @Transactional
    public Chequeo guardarChequeo(Chequeo chequeo){
        return chequeoRepository.save(chequeo);
    }

    public List<Chequeo> buscarChequeoPorFechaRegistradaYPorTipo(Chequeo chequeo){
        return chequeoRepository.findAllBy_esEntradaAnd_fechaRegistrada(chequeo.is_esEntrada(), chequeo.get_fechaRegistrada());
    }

    public List<Chequeo> buscarChequeoEntreRangoFecha(long fecha1, long fecha2){
        return chequeoRepository.findAllBy_fechaRegistradaBetween(fecha1, fecha2);
    }

    public List<Chequeo> buscarChequeoDespuesDeUnaFecha(long fecha){
        return chequeoRepository.findAllBy_fechaRegistradaGreaterThan(fecha);
    }

    public List<Chequeo> buscarChequeAntesDeUnaFecha(long fecha){
        return  chequeoRepository.findAllBy_fechaRegistradaLessThan(fecha);
    }

    public List<Chequeo> buscarChequoPorParadaId(long id){
        return chequeoRepository.findChequeoBy_parada__idOrderBy_fechaRegistrada(id);
    }

    public List<Chequeo> buscarChequeoPorParadaIdAndCaracteristicas(Chequeo chequeo){
        return chequeoRepository.findChequeoBy_parada__idAnd_esEntradaAnd_fechaRegistrada(chequeo.get_parada().get_id(), chequeo.is_esEntrada(), chequeo.get_fechaRegistrada());
    }
    public Boolean eliminarChequeoPorFecha(long fecha){
        return chequeoRepository.deleteChequeoBy_fechaRegistrada(fecha);
    }

    public Boolean eliminarChequeoPorRangoDeFecha(long fecha1, long fecha2){
        return chequeoRepository.deleteChequeoBy_fechaRegistradaBetween(fecha1, fecha2);
    }

    public Boolean eliminarChequeoDespuesDeUnaFecha(long fecha){
        return chequeoRepository.deleteChequeoBy_fechaRegistradaGreaterThan(fecha);
    }
}

