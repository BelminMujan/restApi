package task.job.restApi.model;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Entity
@Table(name="rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ocjena")
    private float ocjena;
    @Column(name = "znamenitostId")
    private long znamenitostId;

    public long getId() {
        return id;
    }

    public long getZnamenitostId() {
        return znamenitostId;
    }

    public void setZnamenitostId(long znamenitostId) {
        this.znamenitostId = znamenitostId;
    }

    public float getOcjena() {
        return ocjena;
    }

    public void setOcjena(float ocjena) {
        this.ocjena = ocjena;
    }
}
