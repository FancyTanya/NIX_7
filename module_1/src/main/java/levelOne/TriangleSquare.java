package levelOne;

import java.util.Scanner;

public class TriangleSquare {

    public static void main(String[] args) {
        triangleSquare();
    }

    public static void triangleSquare() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the value of the coordinates of the vertex of the triangle");
        System.out.println("X value of vertex A");
        int xA = input.nextInt();
        System.out.println("Y value of vertex A");
        int yA = input.nextInt();

        System.out.println("X value of vertex B");
        int xB = input.nextInt();
        System.out.println("Y value of vertex B");
        int yB = input.nextInt();

        System.out.println("X value of vertex C");
        int xC = input.nextInt();
        System.out.println("Y value of vertex C");
        int yC = input.nextInt();

        // d = √ ((х2 - х1 )² + (у2 - у1 )²
        double sideAB = Math.pow(((xA - xB) * (xA - xB) + (yA - yB) * (yA - yB)), 1 / 2);
        double sideBA = Math.pow(((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA)), 1 / 2);
        double sideBC = Math.pow(((xB - xC) * (xB - xC) + (yB - yC) * (yB - yC)), 1 / 2);
        double polyPerimeter = (sideAB + sideBA + sideBC) / 2;

        // S = √(p(p-a)(p-b)(p-c)).
        double square = Math.pow(polyPerimeter * (polyPerimeter - sideAB) * (polyPerimeter - sideBA) * (polyPerimeter - sideBC), 1 / 2);

        System.out.println("The square of triangle is " + square);

    }
}
