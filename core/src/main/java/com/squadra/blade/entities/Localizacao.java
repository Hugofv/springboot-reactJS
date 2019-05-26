package com.squadra.blade.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localizacao")
public class Localizacao {

    @Id
    @GeneratedValue
    private long id;

    private String nome;

    public double latitude;

    public double longitude;

    /**
     * @return current id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return current nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return current latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return current longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
