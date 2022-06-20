package model;

public class Time {
    private int idTime;
    private String pais;

    public Time() {
    }

    public Time(String pais) {
        this.pais = pais;
    }

    public Time(int idTime, String pais) {
        this.idTime = idTime;
        this.pais = pais;
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public void mostrarDados() {
        System.out.println("Nome do time: " + getPais() + "\nId do time: " + getIdTime());
    }
}
