package sravya.example.com.project1;

import android.widget.Button;

/**
 * Created by SRAVYA on 29-01-2018.
 */

public class Product {
    int image;
    String s1,s2,s3;
    Button b1,b2;

    public Product(int image, String s1, String s2, String s3, Button b1, Button b2) {
        this.image = image;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.b1 = b1;
        this.b2 = b2;
    }

    public int getImage() {
        return image;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public String getS3() {
        return s3;
    }

    public Button getB1() {
        return b1;
    }

    public Button getB2() {
        return b2;
    }
}
