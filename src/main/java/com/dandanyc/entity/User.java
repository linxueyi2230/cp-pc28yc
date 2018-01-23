package com.dandanyc.entity;

import java.util.Date;

public class User {
    private Integer eggsId;

    private String eggsUsername;

    private String eggsPassword;

    private String eggsKey;

    private Date eggsDate;

    private String eggsType;

    private String eggsIp;

    private String eggsFlag;

    private String eggsQq;

    private String eggsName;

    public Integer getEggsId() {
        return eggsId;
    }

    public void setEggsId(Integer eggsId) {
        this.eggsId = eggsId;
    }

    public String getEggsUsername() {
        return eggsUsername;
    }

    public void setEggsUsername(String eggsUsername) {
        this.eggsUsername = eggsUsername == null ? null : eggsUsername.trim();
    }

    public String getEggsPassword() {
        return eggsPassword;
    }

    public void setEggsPassword(String eggsPassword) {
        this.eggsPassword = eggsPassword == null ? null : eggsPassword.trim();
    }

    public String getEggsKey() {
        return eggsKey;
    }

    public void setEggsKey(String eggsKey) {
        this.eggsKey = eggsKey == null ? null : eggsKey.trim();
    }

    public Date getEggsDate() {
        return eggsDate;
    }

    public void setEggsDate(Date eggsDate) {
        this.eggsDate = eggsDate;
    }

    public String getEggsType() {
        return eggsType;
    }

    public void setEggsType(String eggsType) {
        this.eggsType = eggsType == null ? null : eggsType.trim();
    }

    public String getEggsIp() {
        return eggsIp;
    }

    public void setEggsIp(String eggsIp) {
        this.eggsIp = eggsIp == null ? null : eggsIp.trim();
    }

    public String getEggsFlag() {
        return eggsFlag;
    }

    public void setEggsFlag(String eggsFlag) {
        this.eggsFlag = eggsFlag == null ? null : eggsFlag.trim();
    }

    public String getEggsQq() {
        return eggsQq;
    }

    public void setEggsQq(String eggsQq) {
        this.eggsQq = eggsQq == null ? null : eggsQq.trim();
    }

    public String getEggsName() {
        return eggsName;
    }

    public void setEggsName(String eggsName) {
        this.eggsName = eggsName == null ? null : eggsName.trim();
    }

    public User() {
    }

    public User(Integer eggsId, String eggsUsername, String eggsPassword, String eggsKey, Date eggsDate, String eggsType, String eggsIp, String eggsFlag, String eggsQq, String eggsName) {
        this.eggsId = eggsId;
        this.eggsUsername = eggsUsername;
        this.eggsPassword = eggsPassword;
        this.eggsKey = eggsKey;
        this.eggsDate = eggsDate;
        this.eggsType = eggsType;
        this.eggsIp = eggsIp;
        this.eggsFlag = eggsFlag;
        this.eggsQq = eggsQq;
        this.eggsName = eggsName;
    }
}
