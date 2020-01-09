package com.pojo;

import java.io.Serializable;

public class AccountDO implements Serializable {
    private Integer id;
    private String  name;
    private String money;

    @Override
    public String toString() {
        return "AccountDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
