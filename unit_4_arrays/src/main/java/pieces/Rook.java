package pieces;

import chess.Board;
import chess.Square;
public class Rook extends Piece {
    public Rook(String colorIn) {
        super(colorIn, "rook");
        if (color.equals("white")) {
            symbol = "wRo";
        }
        else {
            symbol = "bRo";
        }
    }

    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        Square toSquare = Board.board[moveToY][moveToX];

        String direction;

        if (!testKing) {
            if(toSquare.getType().equals("king")) {
                return false;
            }
        }
        if (moveToX == moveFromY) {
            if (moveToX > moveFromX) {
                direction = "rite";
            }
            else {
                direction = "left";
            }
        }
        else if (moveToX == moveFromX) {
            if (moveToY > moveFromY) {
                direction = "bot";
            }
            else {
                direction = "top";
            }
        }
        else {
            return false;
        }
        Square testSquare;

        if (direction.equals("rite") ||direction.equals("left")) {
            int displaceMax = Math.abs(moveToX - moveFromX);

            for (int displace = 1; displace <= displaceMax; displace++) {
                if (direction.equals("rite")) {
                    testSquare = Board.board[moveFromY][moveFromX + displace];

                    if (!testSquare.getType().equals("blank") && displace != displaceMax) {
                        return false;
                    }
                    else if (displace == displaceMax && testSquare.getType().equals("blank") || !testSquare.getColor().equals(plyColor)) {
                        return true;
                    }
                }
            }
        }
        else {
            int displaceMax = Math.abs(moveToY - moveFromY);
            for (int displace = 1; displace <= displaceMax; displace++) {
                if (direction.equals("top")) {
                    testSquare = Board.board[moveFromY - displace][moveFromX];

                    if (!testSquare.getType().equals("blank") && displace != displaceMax) {
                        return false;
                    }
                    else if (displace == displaceMax && testSquare.getType().equals("blank") || !testSquare.getColor().equals(plyColor)) {
                        return true;
                    }
                }
                else {
                    testSquare = Board.board[moveFromY + displace][moveFromX];

                    if (!testSquare.getType().equals("blank") && displace != displaceMax) {
                        return false;
                    }
                    else if (displace == displaceMax && testSquare.getType().equals("blank") && !testSquare.getColor().equals(plyColor)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
