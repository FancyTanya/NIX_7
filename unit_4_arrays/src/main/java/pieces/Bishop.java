package pieces;

import chess.Board;
import chess.Square;

public class Bishop extends Piece {
    public Bishop(String colorIn) {
        super(colorIn, "bishop");
        if (color.equals("white")) {
            symbol = "wBi";
        }
        else {
            symbol = "bBi";
        }
    }

    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {

        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        Square toSquare = Board.board[moveToY][moveToX];

        int moveDistance = Math.abs(moveToX - moveFromX);

        if (!testKing) {
            if (toSquare.getType().equals("king")) {
                return false;
            }
        }

        String direction;

        if (moveToX > moveFromX) {
            if (moveToY < moveFromY) {
                direction = "topRite";
            } else {
                direction = "botRite";
            }
        } else {
            if (moveToY < moveFromY) {
                direction = "topLeft";
            } else {
                direction = "botLeft";
            }
        }
        Square testSquare;

        for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){
            if(direction.equals("topRite")) {
                testSquare = Board.board[moveFromY - diagMoveAway][moveFromX + diagMoveAway];
            }
            else if(direction.equals("botRite")){
                testSquare = Board.board[moveFromY + diagMoveAway][moveFromX + diagMoveAway];
            }
            else if(direction.equals("topLeft")){
                testSquare = Board.board[moveFromY - diagMoveAway][moveFromX - diagMoveAway];
            }
            else{
                testSquare = Board.board[moveFromY + diagMoveAway][moveFromX - diagMoveAway];
            }

            if((!testSquare.getType().equals("blank")) && (diagMoveAway != moveDistance)){
                return false;
            }
            else if((diagMoveAway == moveDistance) && ((!testSquare.getColor().equals(plyColor)) || (testSquare.getType().equals("blank")))){
                return true;
            }
        }
        return false;
    }
}
