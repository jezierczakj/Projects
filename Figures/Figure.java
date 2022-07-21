package com.company;

public abstract class Figure implements Printable {
int a;
public Figure(int a){
    this.a = a;
}
    public abstract double calculateArea(int a);

    public abstract double calculatePerimeter();

    @Override
    public void print() {
        System.out.println(calculateArea(a));
        System.out.println(calculatePerimeter());
    }


}
