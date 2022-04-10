package edu.fje.m07uf2projecte.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Temps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ciutat;
    private Date data;
    private int temperatura;
    private String icon;

    public Temps() {}

    public Temps(String ciutat, Date data, int temperatura, String icon) {
        this.ciutat = ciutat;
        this.data = data;
        this.temperatura = temperatura;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temps)) return false;
        Temps temps = (Temps) o;
        return getCiutat().equals(temps.getCiutat()) && getData().equals(temps.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCiutat(), getData());
    }

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
