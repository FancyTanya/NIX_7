package ua.com.alevel.model;

public class Route {
    private  int id;
    private int fromId;
    private int toId;
    private int cost;

    public int getId() {
        return id;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Route(int id, int fromId, int toId, int cost) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.cost = cost;
    }

    public Route() {
    }

    public Route(int fromId, int toId, int cost) {
        id =(int) System.currentTimeMillis();
        this.fromId = fromId;
        this.toId = toId;
        if (cost > 0 && cost < 200000) {
            this.cost = cost;
        }
    }


}
