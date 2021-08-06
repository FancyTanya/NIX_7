import levelThree.GameOfLife;

import static levelOne.UniqueNumber.doTask1;
import static levelOne.MoveOfKnight.knightMove;
import static levelOne.TriangleSquare.triangleSquare;
import static levelTwo.isCorrectString.testIsCorrectString;
import static levelThree.GameOfLife.runGameOfLive;

public class App {
    public static void main(String[] args) {

        doTask1();
        System.out.println("--------------------");
        knightMove();
        System.out.println("--------------------");
        triangleSquare();
        System.out.println("--------------------");
        testIsCorrectString();
        System.out.println("--------------------");
        runGameOfLive();
        System.out.println("--------------------");
    }
}
