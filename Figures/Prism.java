package com.company;

public class Prism extends Figure{
int h, H;
public Prism(int a, int h, int H){
    super(a);
    this.h = h;
    this.H = H;
}
    @Override
    public double calculateArea(int a) {
        return a * h /2;
    }

    @Override
    public double calculatePerimeter() {
        return 1;
    }

    public double calculateVolume() {
        return calculateArea(a) * H;
    }
}
