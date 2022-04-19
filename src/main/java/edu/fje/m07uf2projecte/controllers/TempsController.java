package edu.fje.m07uf2projecte.controllers;

import edu.fje.m07uf2projecte.model.Temps;
import edu.fje.m07uf2projecte.serveis.TempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

/**
 * Controlador principal del projecte
 * Implementa un senzill mapping GET, amb paràmetre opcional.
 * Ho fem servir per a la demo de JPA
 * Reducciona a la vista salutacio de ThymeLeaf
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 24.02.21
 */
@Controller
public class TempsController {
    @Autowired
    private TempsService temps;

    @GetMapping("/")
    public String llistaTemps(Model model) {
        model.addAttribute("temps", temps.trobarTots());
        return "index";
    }
    @GetMapping("/admin")
    public String llistaTempsAdmin(Model model) {
        model.addAttribute("temps", temps.trobarTots());
        return "admin";
    }

    @PostMapping("/esborrarTemps")
    public String esborrarTemps(
            @RequestParam String id,
            Model model) {

        Long idTemps = Long.parseLong(id);
        temps.modificarPerId(idTemps);
        model.addAttribute("temps", temps.trobarTots());
        return "admin";
    }

    @PostMapping("/afegirTemps")
    public String afegirTemps(
            @RequestParam String ciutat,
            @RequestParam Date data,
            @RequestParam int temperatura,
            @RequestParam String icon,
            Model model) {
        temps.afegirTemps(ciutat, data, temperatura, icon);
        model.addAttribute("temps", temps.trobarTots());
        return "admin";
    }
    @PostMapping("/modificarTemps")
    public String modificarTemps(
            @RequestParam String id,
            @RequestParam String ciutat,
            @RequestParam Date data,
            @RequestParam int temperatura,
            @RequestParam String icon,
            Model model) {

        Long idTemps = Long.parseLong(id);
        Temps te = temps.trobarPerId(idTemps);
        te.setCiutat(ciutat);
        te.setData(data);
        te.setTemperatura(temperatura);
        te.setIcon(icon);
        temps.afegirTemps(te);
        model.addAttribute("temps", temps.trobarTots());
        return "admin";
    }
}
