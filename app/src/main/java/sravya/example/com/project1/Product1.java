package sravya.example.com.project1;

/**
 * Created by SRAVYA on 31-01-2018.
 */

import java.io.Serializable;

public class Product1 implements Serializable {
    String name, age, price, type, desc, ownrname, ownrcntct, ownradd, ownrinstn;
    int photo;

    public Product1(String name, String age, String price, int photo, String type,
                   String desc, String ownrname, String ownrcntct, String ownradd, String ownrinstn) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.photo = photo;
        this.type = type;
        this.desc = desc;
        this.ownrname = ownrname;
        this.ownrcntct = ownrcntct;
        this.ownradd = ownradd;
        this.ownrinstn = ownrinstn;
    }
}
