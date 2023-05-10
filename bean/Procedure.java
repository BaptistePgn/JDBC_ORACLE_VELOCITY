package bean;

import java.util.List;

public class Procedure {
    private String name;
    private List<Attribut> parametres;

    private String typeRetour;

    public Procedure(String name, List<Attribut> parametres, String typeRetour) {
        this.name = name;
        this.parametres = parametres;
        this.typeRetour = typeRetour;
    }

    public String getName() {
        return name;
    }

    public List getParametres() {
        return parametres;
    }

    public String getTypeRetour() {
        return typeRetour;
    }

}
