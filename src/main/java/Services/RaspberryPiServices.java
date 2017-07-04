package Services;

import Entities.RaspberryPiAPI;
import Repository.ReaspberryPiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by anyderre on 01/07/17.
 */
@Service
public class RaspberryPiServices {
    @Autowired
    ReaspberryPiRepository reaspberryPiRepository;

    public RaspberryPiAPI buscarRaspberryPiPorid(long id){
        return reaspberryPiRepository.findRaspberryPiAPIBy_id(id);
    }
    public RaspberryPiAPI buscarRaspberryPiPorMacAddress(String macAddress){
        return reaspberryPiRepository.findRaspberryPiAPIBy_macAddres(macAddress);
    }
    public boolean eliminarRaspberryPiPorId(long id){
        return reaspberryPiRepository.deleteRaspberryPiAPIBy_id(id);
    }
    public boolean eliminarRapsberryPorMacAddress(String macAddress){
        return reaspberryPiRepository.deleteRaspberryPiAPIBy_macAddress(macAddress);
    }
    public RaspberryPiAPI guardarRaspberryPi(RaspberryPiAPI raspberryPiAPI){
        return reaspberryPiRepository.save(raspberryPiAPI);
    }
    public RaspberryPiAPI buscarRaspberryPiPorIdAutobus(long id){
        return reaspberryPiRepository.findRaspberryPiAPIByAutobus__id(id);
    }
}
