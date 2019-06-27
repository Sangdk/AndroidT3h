package com.example.myapplication;

public class Time {
    private long msText;
    private long scText;
    private long minText;
    private long hourText;

    public Time(long msText, long scText, long minText, long hourText) {
        this.msText = msText;
        this.scText = scText;
        this.minText = minText;
        this.hourText = hourText;
    }
    public String show(){
        String timeResult = String.format("%02d",hourText) + " :" +
                String.format("%02d",minText) + " :" +
                String.format("%02d",scText) + " :" +
                String.format("%02d",msText);
        return timeResult;
    }

    public void setMsText(long msText) {
        this.msText = msText;
    }

    public void setScText(long scText) {
        this.scText = scText;
    }

    public void setMinText(long minText) {
        this.minText = minText;
    }

    public void setHourText(long hourText) {
        this.hourText = hourText;
    }

    public long getMsText() {
        return msText;
    }

    public long getScText() {
        return scText;
    }

    public long getMinText() {
        return minText;
    }

    public long getHourText() {
        return hourText;
    }
}
