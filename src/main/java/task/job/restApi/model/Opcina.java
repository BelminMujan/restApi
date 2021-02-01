package task.job.restApi.model;

import javax.persistence.*;

@Entity
@Table(name = "opcina")
public class Opcina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nazivOpcine")
    private String nazivOpcine;
    @Column(name="drzavaId")
    private long drzavaId;

    public Opcina(){};
    public Opcina(long id, String nazivOpcine, long drzavaId) {
        this.id = id;
        this.nazivOpcine = nazivOpcine;
        this.drzavaId = drzavaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazivOpcine() {
        return nazivOpcine;
    }

    public void setNazivOpcine(String nazivOpcine) {
        this.nazivOpcine = nazivOpcine;
    }

    public long getDrzavaId() {
        return drzavaId;
    }

    public void setDrzavaId(long drzavaId) {
        this.drzavaId = drzavaId;
    }
}
