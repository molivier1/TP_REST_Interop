package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.IntroRestApplication;
import fr.ensim.interop.introrest.model.Equipe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class EquipeController {

    private static HashMap<Integer, Equipe> map = new HashMap<>();
    private static int cmpt = 1;

    public EquipeController() {
        map.put(cmpt, new Equipe(cmpt, "equipeTest", 10));

        cmpt++;
        //System.out.println(map.get(1).nom);
    }

    /*public ResponseEntity<String> creerEquipe(@RequestParam("name") String nom,
    @RequestParam(required = false) Integer nbJoueurs) {*/

    //System.out.println("Test de log bien degueulasse\nnom = " + nom + " & nbJoueurs = " + nbJoueurs);
    //IntroRestApplication.map.put(IntroRestApplication.cmpt++, new EquipeModel(nom, nbJoueurs == null ? 0 : nbJoueurs));
    //return ResponseEntity.ok("id = " + (IntroRestApplication.cmpt - 1));

    @PostMapping("/teams")
    public ResponseEntity<Equipe> creerEquipe(@RequestBody Equipe equipe) {

        if (!StringUtils.hasText(equipe.getName())) {
            return ResponseEntity.badRequest().build();
        }

        if (map.values().stream().anyMatch(e -> e.getName().equals(equipe.getName()))) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if (map.values().stream().anyMatch(e -> e.getId() == equipe.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        map.put(equipe.getId(), equipe);

        return ResponseEntity.ok(equipe);
    }

    @GetMapping("teams/{id}")
    public ResponseEntity<Equipe> recupererEquipe(@PathVariable("id") int id) {
        if (map.containsKey(id)) {
            return ResponseEntity.ok(map.get(id));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /*@GetMapping("teams")
    public ResponseEntity<Collection<Equipe>> listerEquipe(@RequestParam()) {

        return null;
    }*/
}
