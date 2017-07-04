package Entities;

import javax.persistence.*;

/**
 * Created by anyderre on 28/06/17.
 */
@Entity
@Table(name = "coordenada")
public class Coordenada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    private double _latitude;
    private double _longitude;

    public Coordenada(double latitude, double longitude) {
        this._latitude = latitude;
        this._longitude = longitude;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long id) {
        this._id = id;
    }

    public double get_latitude() {
        return _latitude;
    }

    public void set_latitude(double latitude) {
        this._latitude = latitude;
    }

    public double get_longitude() {
        return _longitude;
    }

    public void set_longitude(double longitude) {
        this._longitude = longitude;
    }
}
