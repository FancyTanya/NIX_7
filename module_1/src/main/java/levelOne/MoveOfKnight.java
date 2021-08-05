package levelOne;

import java.util.Scanner;

public class MoveOfKnight {

    public static void knightMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the position where the knight will be");
        System.out.println("Please enter move from X");
        int moveFromX = scanner.nextInt();
        System.out.println("Please enter move from Y");
        int moveFromY = scanner.nextInt();
        System.out.println("Please enter the coordinates of the knight's movement");
        System.out.println("Please enter move to X");
        int moveToX = scanner.nextInt();
        System.out.println("Please enter move to Y");
        int moveToY = scanner.nextInt();

        if (!checkMove(moveFromX, moveFromY, moveToX, moveToY)) {
            System.out.println("The Move is not possible");
        } else {
            System.out.println("Move is possible");
        }
    }

    public static boolean checkMove(int moveFromX, int moveFromY, int moveToX, int moveToY) {
        boolean locationPass = false;
        for (int displaceX = -2; displaceX <= 2; displaceX++) {
            if (displaceX != 0) {
                if (moveToX == moveFromX + displaceX) {
                    if (Math.abs(displaceX) == 1) {
                        for (int displaceY = -2; displaceY <= 2; displaceY += 4) {
                            if (moveToY == moveFromY + displaceY) {
                                locationPass = true;
                            }
                        }
                    } else {
                        for (int displaceY = -1; displaceY <= 1; displaceY += 2) {
                            if (moveToY == moveFromY + displaceY) {
                                locationPass = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
