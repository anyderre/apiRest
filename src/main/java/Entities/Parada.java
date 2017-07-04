package Entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by anyderre on 28/06/17.
 */
@Entity
@Table(name = "parada")
public class Parada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    private String _nombre;
    @ManyToOne
    private Ruta _ruta;
    @OneToOne
    private Parada _paradaAnterior;
    @OneToOne
    private Parada _ParadaSiguiente;
    @OneToOne
    private Coordenada _coordenada;

    public Parada(String _nombre, Ruta _ruta, Parada _paradaAnterior, Parada _ParadaSiguiente, Coordenada _coordenada) {
        this._nombre = _nombre;
        this._ruta = _ruta;
        this._paradaAnterior = _paradaAnterior;
        this._ParadaSiguiente = _ParadaSiguiente;
        this._coordenada = _coordenada;
    }
    public Parada(){

    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Ruta get_ruta() {
        return _ruta;
    }

    public void set_ruta(Ruta _ruta) {
        this._ruta = _ruta;
    }

    public Parada get_paradaAnterior() {
        return _paradaAnterior;
    }

    public void set_paradaAnterior(Parada _paradaAnterior) {
        this._paradaAnterior = _paradaAnterior;
    }

    public Parada get_ParadaSiguiente() {
        return _ParadaSiguiente;
    }

    public void set_ParadaSiguiente(Parada _ParadaSiguiente) {
        this._ParadaSiguiente = _ParadaSiguiente;
    }

    public Coordenada get_coordenada() {
        return _coordenada;
    }

    public void set_coordenada(Coordenada _coordenada) {
        this._coordenada = _coordenada;
    }
}
