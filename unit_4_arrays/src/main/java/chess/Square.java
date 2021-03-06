package chess;

public abstract class Square {

    protected String symbol;
    public String color;
    public String type;

    public Square(String typeIn) {
        this.type = typeIn;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public abstract boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing);
}
