package com.dandanyc.entity;

/**
 * Created by prothezou on 2016/12/22.
 */
public class CanadaDTO {
    private String id;
    private String date;
    private String number;
    private String result;
    private String yuce;

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getResult() {
        return result;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getYuce() {
        return yuce;
    }

    public void setYuce(String yuce) {
        this.yuce = yuce;
    }


    public CanadaDTO() {
    }

    @Override
    public String toString() {
        return "CanadaDTO{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", number='" + number + '\'' +
                ", result='" + result + '\'' +
                ", yuce='" + yuce + '\'' +
                '}';
    }

    public CanadaDTO(String id, String date, String number, String result, String yuce) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.result = result;
        this.yuce = yuce;
    }
}
