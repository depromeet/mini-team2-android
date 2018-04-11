package com.github.depromeet.a24cafe.model;

import java.io.Serializable;

public class CafeContent implements Serializable {
    private int id;
    private int boardId;
    private String title;
    private String content;
    private double latitude;
    private double longitude;
    private String createAt;
    private int openedAt;
    private int closedAt;
    private String phone;
    private int nearestExit;

    public CafeContent(int id, int boardId, String title, String content, double latitude, double longitude, String createAt, int openedAt, int closedAt, String phone, int nearestExit) {
        this.id = id;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createAt = createAt;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.phone = phone;
        this.nearestExit = nearestExit;
    }


    public CafeContent(int boardId, String title, String content, double latitude, double longitude, String createAt, int openedAt, int closedAt, String phone, int nearestExit) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createAt = createAt;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.phone = phone;
        this.nearestExit = nearestExit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(int openedAt) {
        this.openedAt = openedAt;
    }

    public int getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(int closedAt) {
        this.closedAt = closedAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNearestExit() {
        return nearestExit;
    }

    public void setNearestExit(int nearestExit) {
        this.nearestExit = nearestExit;
    }
}
