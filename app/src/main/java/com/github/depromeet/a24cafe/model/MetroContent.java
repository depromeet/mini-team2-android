package com.github.depromeet.a24cafe.model;

public class MetroContent {
    String CafeName;
    int distance;

    public MetroContent(String cafeName, int distance) {
        CafeName = cafeName;
        this.distance = distance;
    }

    public String getCafeName() {
        return CafeName;
    }

    public void setCafeName(String cafeName) {
        CafeName = cafeName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
