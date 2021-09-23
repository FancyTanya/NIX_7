package ua.com.alevel.entity;

import java.util.List;

public class Vertex {

    public String cityName;
    public boolean isInTree;

    public Vertex(String cityName) {
        this.cityName = cityName;
        isInTree = false;
    }

    public Vertex() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
