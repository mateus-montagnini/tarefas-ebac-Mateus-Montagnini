package br.mrocha.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
    @SequenceGenerator(name = "acessorio_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "ar_condicionado", nullable = false)
    private boolean ar;

    @Column(name = "automatico", nullable = false)
    private boolean automatico;

    @Column(name = "gps", nullable = false)
    private boolean gps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAr() {
        return ar;
    }

    public void setAr(boolean ar) {
        this.ar = ar;
    }

    public boolean isAutomatico() {
        return automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }
}
