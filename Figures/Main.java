package com.company;

public class Main {

    public static void main(String[] args) {
Triangle triangle = new Triangle(10, 10, 10, 4);
triangle.calculateArea(10);
triangle.calculatePerimeter();
triangle.print();

        Prism prism = new Prism(10, 2, 4);
        prism.calculateArea(10);
        prism.calculatePerimeter();
        prism.print();
    }
}
