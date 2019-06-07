package br.com.senac.show.modelo;

public class Show {

    private  Long id;
    private String show;
    private String dias;
    private String horas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return getShow() +" - " + getDias()+" - "+ getHoras();
    }
}
