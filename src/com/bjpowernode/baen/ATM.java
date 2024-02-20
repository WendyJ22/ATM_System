package com.bjpowernode.baen;

import java.util.Objects;

public class ATM {
    private int atmId;
    private String atmCode;
    private String atmPwd;
    private String atmName;
    private double atmMoney;

    public ATM(int atmId, String atmCode, String atmPwd, String atmName, double atmMoney) {
        this.atmId = atmId;
        this.atmCode = atmCode;
        this.atmPwd = atmPwd;
        this.atmName = atmName;
        this.atmMoney = atmMoney;
    }

    public ATM() {
    }

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public String getAtmCode() {
        return atmCode;
    }

    public void setAtmCode(String atmCode) {
        this.atmCode = atmCode;
    }

    public String getAtmPwd() {
        return atmPwd;
    }

    public void setAtmPwd(String atmPwd) {
        this.atmPwd = atmPwd;
    }

    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String atmName) {
        this.atmName = atmName;
    }

    public double getAtmMoney() {
        return atmMoney;
    }

    public void setAtmMoney(double atmMoney) {
        this.atmMoney = atmMoney;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "atmId=" + atmId +
                ", atmCode='" + atmCode + '\'' +
                ", atmPwd='" + atmPwd + '\'' +
                ", atmName='" + atmName + '\'' +
                ", atmMoney=" + atmMoney +
                '}';
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return atmId == atm.atmId &&
                Double.compare(atm.atmMoney, atmMoney) == 0 &&
                Objects.equals(atmCode, atm.atmCode) &&
                Objects.equals(atmPwd, atm.atmPwd) &&
                Objects.equals(atmName, atm.atmName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atmId, atmCode, atmPwd, atmName, atmMoney);
    }
}
