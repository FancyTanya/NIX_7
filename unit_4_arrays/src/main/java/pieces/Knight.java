package pieces;

import chess.Board;
import chess.Square;

public class Knight extends Piece {
    public Knight(String colorIn) {
        super(colorIn, "knight");
        if (color.equals("white")) {
            symbol = "wKn";
        }
        else {
            symbol = "bKn";
        }
    }

    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        Square toSquare = Board.board[moveToY][moveToX];

        if (!testKing) {
            if (toSquare.getType().equals("king")) {
                return false;
            }
        }
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
                    }
                    else {
                        for (int displaceY = -1; displaceY <=1; displaceY += 2) {
                            if (moveToY == moveFromY + displaceY) {
                                locationPass = true;
                            }
                        }
                    }
                }
            }
        }
        if(locationPass){
            if((toSquare.getType().equals("blank")) || (!toSquare.getColor().equals(plyColor))){
                return true;
            }
        }
        return false;
    }
}
