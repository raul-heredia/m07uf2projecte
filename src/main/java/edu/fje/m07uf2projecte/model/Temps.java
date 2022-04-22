package edu.fje.m07uf2projecte.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Classe Entitat Temps
 */

@Entity
public class Temps {
    /**
     * Propietats per al identificador del objecte a la base de dades,
     * el nom de la ciutat, la data, la temperatura i la icona que utilitzarà
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ciutat;
    private Date data;
    private int temperatura;
    private String icon;

    /**
     * Constructor de la classe Temps
     */

    public Temps() {}

    /**
     * Contructor de la classe Temps
     * @param ciutat Nom de la CIutat
     * @param data Data de la predicció
     * @param temperatura Temperatura de la predicció
     * @param icon Icona que tindrà la predicció
     */

    public Temps(String ciutat, Date data, int temperatura, String icon) {
        this.ciutat = ciutat;
        this.data = data;
        this.temperatura = temperatura;
        this.icon = icon;
    }

    /**
     * Getter de la propiedad Id
     * @return Long id
     */

    public Long getId() {
        return id;
    }

    /**
     * Setter de la propietat Id
     * @param id Estableix el id de la Predicción
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter de la propietat ciutat
     * @return String ciutat
     */

    public String getCiutat() {
        return ciutat;
    }

    /**
     * Setter de la propiedad ciutat
     * @param ciutat Estableix la ciutat de la Predicció
     */

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    /**
     * Getter de la Fecha
     * @return Date data
     */

    public Date getData() {
        return data;
    }

    /**
     * Setter de la propiedad data
     * @param data Estableix la data de la Predicció
     */

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Getter de la Temperatiura
     * @return int temperatura
     */

    public int getTemperatura() {
        return temperatura;
    }

    /**
     * Setter de la propiedad temperatura
     * @param temperatura Estableix la temperatura de la Predicció
     */

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Getter de la Icona
     * @return String icon
     */

    public String getIcon() {
        return icon;
    }

    /**
     * Setter de la propiedad icon
     * @param icon Estableix la icona de la Predicció
     */

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Mètode que compara si dos objectes son iguals
     * @param o Retorna boolean si son iguals o no
     * @return boolean equals
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temps)) return false;
        Temps temps = (Temps) o;
        return getCiutat().equals(temps.getCiutat()) && getData().equals(temps.getData());
    }

    /**
     * Mètode que retorna un int amb els primers digits del seu hash
     * @return int hashCode
     */

    @Override
    public int hashCode() {
        return Objects.hash(getCiutat(), getData());
    }

    /**
     * Mètode que retorna un String amb totes les dades del objecte
     * @return String object properties
     */

    @Override
    public String toString() {
        return "Temps{" +
                "id=" + id +
                ", ciutat='" + ciutat + '\'' +
                ", data=" + data +
                ", temperatura=" + temperatura +
                ", icon='" + icon + '\'' +
                '}';
    }
}
