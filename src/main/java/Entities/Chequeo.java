package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by anyderre on 28/06/17.
 */
@Entity
@Table(name = "chequeo")
public class Chequeo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger _id; //to be thinking
    private long _fechaRegistrada;
    @ManyToOne
    private RaspberryPiAPI _raspberryPiAPI;
    @ManyToOne
    private Parada _parada;
    private boolean _esEntrada;

    public Chequeo(long _fechaRegistrada, RaspberryPiAPI raspberryPiAPI, Parada _parada, boolean _esEntrada) {
        this._fechaRegistrada = _fechaRegistrada;
        this._raspberryPiAPI = raspberryPiAPI;
        this._parada = _parada;
        this._esEntrada = _esEntrada;
    }

    public Chequeo(){

    }

    public RaspberryPiAPI getRaspberryPiAPI() {
        return _raspberryPiAPI;
    }

    public void setRaspberryPiAPI(RaspberryPiAPI raspberryPiAPI) {
        this._raspberryPiAPI = raspberryPiAPI;
    }



    public BigInteger get_id() {
        return _id;
    }

    public void set_id(BigInteger id) {
        this._id = id;
    }

    public long get_fechaRegistrada() {
        return _fechaRegistrada;
    }

    public void set_fechaRegistrada(long fechaRegistrada) {
        this._fechaRegistrada = fechaRegistrada;
    }

    public Parada get_parada() {
        return _parada;
    }

    public void set_parada(Parada parada) {
        this._parada = parada;
    }

    public boolean is_esEntrada() {
        return _esEntrada;
    }

    public void set_esEntrada(boolean esEntrada) {
        this._esEntrada = esEntrada;
    }
}
