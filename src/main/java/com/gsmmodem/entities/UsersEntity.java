package com.gsmmodem.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class UsersEntity {
    @PrimaryKey
    private Integer id;
    private Boolean isChecked;
    private String name;
    private String password;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public Boolean getChecked() {
        return this.isChecked;
    }

    public void setChecked(Boolean bool) {
        this.isChecked = bool;
    }
}
