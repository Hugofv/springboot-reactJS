package com.star.wars.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "localizacao")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    public double latitude;

    public double longitude;

    @OneToMany(mappedBy = "localizacao", cascade = CascadeType.ALL)
    private Set<Rebelde> rebeldes;

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

    /**
     * @return current rebeldes
     */
    public Set<Rebelde> getRebeldes() {
        return rebeldes;
    }

    /**
     * @param rebeldes to set
     */
    public void setRebeldes(Set<Rebelde> rebeldes) {
        this.rebeldes = rebeldes;
    }
}
