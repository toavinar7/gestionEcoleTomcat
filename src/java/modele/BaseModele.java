package modele;

public class BaseModele {
    private Integer id;

    public BaseModele() {
        super();
        this.setId(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BaseModele(Integer id) {
        this.setId(id);
    }
}