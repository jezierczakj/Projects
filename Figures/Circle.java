package com.company;

public class Circle extends Figure implements Printable{
    int r;
    public Circle(int a, int r){
        super(a);
        this.r = r;
    }
    @Override
    public double calculateArea(int a) {
        return (r * 3) * r;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * r;
    }
}
