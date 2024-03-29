package com.t3h.subjectmanage;

import android.support.annotation.DrawableRes;

public class Subject {
    private int image;
    private String subjectName;
    private String name;
    private float point;

    public Subject(@DrawableRes int image, String subjectName, String name, float point) {
        this.image = image;
        this.subjectName = subjectName;
        this.name = name;
        this.point = point;
    }

    public int getImage() {
        return image;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getName() {
        return name;
    }

    public float getPoint() {
        return point;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(float point) {
        this.point = point;
    }
}
