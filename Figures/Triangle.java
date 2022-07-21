package com.company;

public class Triangle extends Figure implements Printable{
    float wysokosc, ramie1, ramie2;

    public Triangle(int a, int ramie1, int ramie2, int wysokosc) {
        super(a);
        this.wysokosc = wysokosc;
        this.ramie1 = ramie1;
        this.ramie2 = ramie2;
    }

    @Override
    public double calculateArea(int a) {
        return a * wysokosc / 2;
    }

    @Override
    public double calculatePerimeter() {
        return a + ramie1 + ramie2;
    }

}
