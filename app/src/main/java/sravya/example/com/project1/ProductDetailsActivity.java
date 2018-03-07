package sravya.example.com.project1;

/**
 * Created by SRAVYA on 31-01-2018.
 */

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailsActivity extends Activity {

    TextView name, age, price, type, desc, ownrname, ownrcntct, ownradd, ownrinstn;
    ImageView photo;
    Button btnInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_details);

        init();
    }

    private void init() {
        name = (TextView) findViewById(R.id.tvProdName);
        age = (TextView) findViewById(R.id.tvProdAge);
        price = (TextView) findViewById(R.id.tvProdPrice);
        type = (TextView) findViewById(R.id.tvProdType);
        desc = (TextView) findViewById(R.id.tvProdDsc);
        ownrname = (TextView) findViewById(R.id.ProdOwner);
        ownrcntct = (TextView) findViewById(R.id.ProdCntct);
        ownradd = (TextView) findViewById(R.id.ProdAdd);
        ownrinstn = (TextView) findViewById(R.id.ProdInstn);
        photo = (ImageView) findViewById(R.id.imgProd);
        btnInterest = (Button) findViewById(R.id.btnInterest);

        final Product1 temp = (Product1) getIntent().getExtras().get("item");

        name.setText(temp.name);
        age.setText(temp.age);
        price.setText(temp.price);
        type.setText(temp.type);
        desc.setText(temp.desc);
        ownrname.setText(temp.ownrname);
        ownrcntct.setText(temp.ownrcntct);
        ownradd.setText(temp.ownradd);
        ownrinstn.setText(temp.ownrinstn);
        photo.setImageResource(temp.photo);

        btnInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetailsActivity.this, "Notification sent to seller. You'll be contacted shortly", Toast.LENGTH_LONG);
            }
        });
    }
}
