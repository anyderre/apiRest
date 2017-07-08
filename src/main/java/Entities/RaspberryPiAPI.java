package Entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by anyderre on 28/06/17.
 */
@Entity
public class  RaspberryPiAPI implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    private String _numeroSerial;
    private String _ipAddress;
    private int _puerto;
    private String _macAddress;

    @OneToOne(mappedBy = "autobus")
    private Autobus _autobus;

    private RaspberryPiAPI(){

    }

    public RaspberryPiAPI(String _numeroSerial, String _ipAddress, int _puerto, String _macAddress, Autobus autobus) {
        this._numeroSerial = _numeroSerial;
        this._ipAddress = _ipAddress;
        this._puerto = _puerto;
        this._macAddress = _macAddress;
        this._autobus = autobus;
    }

    public String get_macAddress() {
        return _macAddress;
    }

    public void set_macAddress(String _macAddress) {
        this._macAddress = _macAddress;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_numeroSerial() {
        return _numeroSerial;
    }

    public void set_numeroSerial(String _numeroSerial) {
        this._numeroSerial = _numeroSerial;
    }

    public String get_ipAddress() {
        return _ipAddress;
    }

    public void set_ipAddress(String _ipAddress) {
        this._ipAddress = _ipAddress;
    }

    public int get_puerto() {
        return _puerto;
    }

    public void set_puerto(int _puerto) {
        this._puerto = _puerto;
    }

    public Autobus getAutobus() {
        return _autobus;
    }

    public void setAutobus(Autobus autobus) {
        this._autobus = autobus;
    }
}
