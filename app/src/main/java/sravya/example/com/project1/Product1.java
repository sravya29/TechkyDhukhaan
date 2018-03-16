package sravya.example.com.project1;

/**
 * Created by SRAVYA on 31-01-2018.
 */

import java.io.Serializable;

public class Product1 implements Serializable {
    String name, age, price, type, desc, ownrname, ownrcntct, ownradd, ownrinstn;
    int photo;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOwnrname() {
        return ownrname;
    }

    public void setOwnrname(String ownrname) {
        this.ownrname = ownrname;
    }

    public String getOwnrcntct() {
        return ownrcntct;
    }

    public void setOwnrcntct(String ownrcntct) {
        this.ownrcntct = ownrcntct;
    }

    public String getOwnradd() {
        return ownradd;
    }

    public void setOwnradd(String ownradd) {
        this.ownradd = ownradd;
    }

    public String getOwnrinstn() {
        return ownrinstn;
    }

    public void setOwnrinstn(String ownrinstn) {
        this.ownrinstn = ownrinstn;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
