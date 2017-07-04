package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by anyderre on 28/06/17.
 */
@Entity
@Table(name ="ruta")
public class Ruta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    private float _distanciaTotal;
    private long _fechaCreada;
    private long _fechaUltimaModificacion;
    private String _ciudad;
    private String _nombreCorredor;
    private boolean _esDireccionSubida;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List <Coordenada> _coordenadas;

    private Ruta(){

    }

    public Ruta(float _distanciaTotal, long _fechaCreada, long _fechaUltimaModificacion, String _ciudad, String _nombreCorredor, boolean _esDireccionSubida, List<Coordenada> _coordenadas) {
        this._distanciaTotal = _distanciaTotal;
        this._fechaCreada = _fechaCreada;
        this._fechaUltimaModificacion = _fechaUltimaModificacion;
        this._ciudad = _ciudad;
        this._nombreCorredor = _nombreCorredor;
        this._esDireccionSubida = _esDireccionSubida;
        this._coordenadas = _coordenadas;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public float get_distanciaTotal() {
        return _distanciaTotal;
    }

    public void set_distanciaTotal(float _distanciaTotal) {
        this._distanciaTotal = _distanciaTotal;
    }

    public long get_fechaCreada() {
        return _fechaCreada;
    }

    public void set_fechaCreada(long _fechaCreada) {
        this._fechaCreada = _fechaCreada;
    }

    public long get_fechaUltimaModificacion() {
        return _fechaUltimaModificacion;
    }

    public void set_fechaUltimaModificacion(long _fechaUltimaModificacion) {
        this._fechaUltimaModificacion = _fechaUltimaModificacion;
    }

    public String get_ciudad() {
        return _ciudad;
    }

    public void set_ciudad(String _ciudad) {
        this._ciudad = _ciudad;
    }

    public String get_nombreCorredor() {
        return _nombreCorredor;
    }

    public void set_nombreCorredor(String _nombreCorredor) {
        this._nombreCorredor = _nombreCorredor;
    }

    public boolean is_esDireccionSubida() {
        return _esDireccionSubida;
    }

    public void set_esDireccionSubida(boolean _esDireccionSubida) {
        this._esDireccionSubida = _esDireccionSubida;
    }

    public List<Coordenada> get_coordenadas() {
        return _coordenadas;
    }

    public void set_coordenadas(List<Coordenada> _coordenadas) {
        this._coordenadas = _coordenadas;
    }
}
