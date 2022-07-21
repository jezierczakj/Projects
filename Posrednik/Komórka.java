package com.company;

public class Komórka {
    private double zysk;
    private int dostawa;
    private boolean pierwszy;

    public Komórka(double zysk) {
        this.zysk = zysk;
        this.dostawa = 0;
        this.pierwszy = false;
    }

    @Override
    public String toString() {
        return "zysk=" + zysk +
                "\t dostawa=" + dostawa;
    }

    public double getZysk() {
        return zysk;
    }

    public int getDostawa() {
        return dostawa;
    }

    public void setDostawa(int dostawa) {
        this.dostawa = dostawa;
    }

    public boolean isPierwszy() {
        return pierwszy;
    }

    public void setPierwszy(boolean pierwszy) {
        this.pierwszy = pierwszy;
    }
    public double zysk()
    {
        double zysk;
        zysk = this.dostawa * this.zysk;
        return zysk;

    }
}