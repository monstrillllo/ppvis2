package com.company;

public class MyData {
    private String name;
    private int Account;
    private String Address;
    private long Mob_Phone;
    private int Home_phone;

    MyData(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return Account;
    }

    public void setAccount(int Account) {
        this.Account = Account;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public long getMob_Phone() {
        return Mob_Phone;
    }

    public void setMob_Phone(long Mob_Phone) {
        this.Mob_Phone = Mob_Phone;
    }

    public int getHome_phone() {
        return Home_phone;
    }

    public void setHome_phone(int Home_Phone) {
        this.Home_phone = Home_Phone;
    }

    MyData(String name, int Account, String Address, long Mob_Phone, int Home_Phone){
        this.name = name;
        this.Account = Account;
        this.Address = Address;
        this.Mob_Phone = Mob_Phone;
        this.Home_phone = Home_Phone;
    }
}
