package sravya.example.com.project1;

/**
 * Created by SRAVYA on 31-01-2018.
 */

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductsArrayAdapter extends ArrayAdapter <Product1> {
    Intent detailsIntent;
    Context context;
    int resource;
    List<Product1> objects;

    public ProductsArrayAdapter(@NonNull Context context, int resource, @NonNull List<Product1> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(this.context).inflate(this.resource, parent, false);

        TextView ProductName = (TextView) view.findViewById(R.id.tvProductName);
        ImageView Photo = (ImageView) view.findViewById(R.id.imgPhoto);
        TextView PriceValue = (TextView) view.findViewById(R.id.tvPriceValue);
        TextView ProductAgeValue = (TextView) view.findViewById(R.id.tvProductAgeValue);
        Button btnDetails = (Button) view.findViewById(R.id.btnDetails);



        ProductName.setText(objects.get(position).name);
        Photo.setImageResource(objects.get(position).photo);
        PriceValue.setText(objects.get(position).price);
        ProductAgeValue.setText(objects.get(position).age);



        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               detailsIntent = new Intent(context, ProductDetailsActivity.class);
                detailsIntent.putExtra("item", objects.get(position));
                context.startActivity(detailsIntent);
            }
        });

        return view;
    }


    public int getCount() {
        return objects.size();
    }


}
