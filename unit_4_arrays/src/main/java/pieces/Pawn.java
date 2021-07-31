package pieces;

import chess.Board;
import chess.Square;

public class Pawn extends Piece{

    public Pawn(String colorIn) {
        super(colorIn, "pawn");

        if(color.equals("white")){
            symbol = "wPa";
        }
        else{
            symbol = "bPa";
        }
    }

    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {

        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        int moveForwardTwo;
        int moveForwardOne;
        int pawnRowOnPlySide;

        Square toSquare = Board.board[moveToY][moveToX];

        if(!testKing){
            if(toSquare.getType().equals("king")){
                return false;
            }
        }
        if(plyColor.equals("white")){
            moveForwardTwo = -2;
            moveForwardOne = -1;
            pawnRowOnPlySide = 6;
        }
        else{
            moveForwardTwo = 2;
            moveForwardOne = 1;
            pawnRowOnPlySide = 1;
        }

        if(moveToY == moveFromY + moveForwardOne){

            if((moveToX == moveFromX - 1) || (moveToX == moveFromX + 1)){
                if((!toSquare.getType().equals("blank")) && (!toSquare.getColor().equals(plyColor))){
                    return true;
                }
            }
            else if((moveToX == moveFromX) && (toSquare.getType().equals("blank"))){
                return true;
            }
        }
        else if((moveToY == moveFromY + moveForwardTwo) && (moveToX == moveFromX) && (toSquare.getType().equals("blank"))){
            if(moveFromY == pawnRowOnPlySide){
                return true;
            }
        }

        return false;
    }
}