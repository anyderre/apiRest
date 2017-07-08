package Entities;

import javax.persistence.*;
import java.io.DataInput;
import java.io.Serializable;
import java.sql.Date;

//import javax.persistence.*;

/**
 * Created by anyderre on 28/06/17.
 */
@Entity
@Table(name = "autobus")
public class Autobus implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    private String _modelo;
    private int _cantidadDeAsientos;
    private float _peso;
    @ManyToOne
    private Ruta _ruta; //Updatable
    @ManyToOne
    private Parada _ultimaParada; // Updatable
    private int _anoFabricacion;
    private boolean _activo;  //Updatable
    private String _conductor;
    private long _fechaCreada; //fecha agregada en la base de datos
    private long _ultimaFechaModificada; // Updatable
    private int _precio;
    private boolean _tieneAireAcondicionado;
    private int _cantidadDePasajerosActual; //Updatable
    @OneToOne
    private Coordenada _coordenada; //Updatable
    @OneToOne(cascade = CascadeType.ALL)
    private RaspberryPiAPI _raspberryPi;

    public Autobus(String _modelo, int _cantidadDeAsientos, RaspberryPiAPI _raspberryPi, float _peso, Ruta _ruta, Parada _ultimaParada, int _anoFabricacion, boolean _activo, String _conductor, long _fechaCreada, long _ultimaFechaModificada, int _precio, boolean _tieneAireAcondicionado, int _cantidadDePasajerosActual, Coordenada _coordenada) {
        this._modelo = _modelo;
        this._cantidadDeAsientos = _cantidadDeAsientos;
        this._peso = _peso;
        this._ruta = _ruta;
        this._ultimaParada = _ultimaParada;
        this._anoFabricacion = _anoFabricacion;
        this._activo = _activo;
        this._conductor = _conductor;
        this._fechaCreada = _fechaCreada;
        this._ultimaFechaModificada = _ultimaFechaModificada;
        this._precio = _precio;
        this._tieneAireAcondicionado = _tieneAireAcondicionado;
        this._cantidadDePasajerosActual = _cantidadDePasajerosActual;
        this._coordenada = _coordenada;
        this._raspberryPi = _raspberryPi;
    }

    private Autobus(){

    }

    public RaspberryPiAPI get_raspberryPi() {
        return _raspberryPi;
    }

    public void set_raspberryPi(RaspberryPiAPI _raspberryPi) {
        this._raspberryPi = _raspberryPi;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_modelo() {
        return _modelo;
    }

    public void set_modelo(String _modelo) {
        this._modelo = _modelo;
    }

    public int get_cantidadDeAsientos() {
        return _cantidadDeAsientos;
    }

    public void set_cantidadDeAsientos(int _cantidadDeAsientos) {
        this._cantidadDeAsientos = _cantidadDeAsientos;
    }

    public float get_peso() {
        return _peso;
    }

    public void set_peso(float _peso) {
        this._peso = _peso;
    }

    public Ruta get_ruta() {
        return _ruta;
    }

    public void set_ruta(Ruta _ruta) {
        this._ruta = _ruta;
    }

    public Parada get_ultimaParada() {
        return _ultimaParada;
    }

    public void set_ultimaParada(Parada _ultimaParada) {
        this._ultimaParada = _ultimaParada;
    }

    public int get_anoFabricacion() {
        return _anoFabricacion;
    }

    public void set_anoFabricacion(int _anoFabricacion) {
        this._anoFabricacion = _anoFabricacion;
    }

    public boolean is_activo() {
        return _activo;
    }

    public void set_activo(boolean _activo) {
        this._activo = _activo;
    }

    public String get_conductor() {
        return _conductor;
    }

    public void set_conductor(String _conductor) {
        this._conductor = _conductor;
    }

    public long get_fechaCreada() {
        return _fechaCreada;
    }

    public void set_fechaCreada(long _fechaCreada) {
        this._fechaCreada = _fechaCreada;
    }

    public long get_ultimaFechaModificada() {
        return _ultimaFechaModificada;
    }

    public void set_ultimaFechaModificada(long _ultimaFechaModificada) {
        this._ultimaFechaModificada = _ultimaFechaModificada;
    }

    public int get_precio() {
        return _precio;
    }

    public void set_precio(int _precio) {
        this._precio = _precio;
    }

    public boolean is_tieneAireAcondicionado() {
        return _tieneAireAcondicionado;
    }

    public void set_tieneAireAcondicionado(boolean _tieneAireAcondicionado) {
        this._tieneAireAcondicionado = _tieneAireAcondicionado;
    }

    public int get_cantidadDePasajerosActual() {
        return _cantidadDePasajerosActual;
    }

    public void set_cantidadDePasajerosActual(int _cantidadDePasajerosActual) {
        this._cantidadDePasajerosActual = _cantidadDePasajerosActual;
    }

    public Coordenada get_coordenada() {
        return _coordenada;
    }

    public void set_coordenada(Coordenada _coordenada) {
        this._coordenada = _coordenada;
    }
}
