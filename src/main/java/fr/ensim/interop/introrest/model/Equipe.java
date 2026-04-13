package fr.ensim.interop.introrest.model;

public class Equipe {
    private Integer id;
    private String name;
    private int nbJoueurs;

    public Equipe(Integer id, String name, int nbJoueurs) {
        this.id = id;
        this.name = name;
        this.nbJoueurs = nbJoueurs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }
}
