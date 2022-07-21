package com.company;

public class Square extends Figure implements Printable{
    int b;
    public Square(int a, int b){
        super(a);
        this.a = a;
        this.b = b;
    }
    @Override
    public double calculateArea(int a) {
        return a * b;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    public void print() {
        System.out.println(calculateArea(a));
        System.out.println(calculatePerimeter());
    }
}
