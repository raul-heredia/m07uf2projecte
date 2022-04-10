package edu.fje.m07uf2projecte.serveis;

import org.springframework.stereotype.Service;
import edu.fje.m07uf2projecte.model.Temps;
import edu.fje.m07uf2projecte.repositories.TempsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Service
public class TempsService {

    @Autowired
    private TempsRepository temps;

    public List<Temps> trobarTots(){
        var it = temps.findAll();
        var temps = new ArrayList<Temps>();
        it.forEach(temps::add);
        return temps;
    }

    public Long comptar() {
        return temps.count();
    }

    public void modificarPerId(Long TempsId) {
        temps.deleteById(TempsId);
    }

    public Temps trobarPerId(Long TempsId){
        return temps.findById(TempsId).get();
    }

    public void afegirTemps(String ciutat, Date data, int temperatura, String icon){
        var t = new Temps(ciutat, data, temperatura, icon);
        temps.save(t);
    }
    public void afegirTemps(Temps t){
        temps.save(t);
    }
}
