package sravya.example.com.project1;

/**
 * Created by SRAVYA on 31-01-2018.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SearchResultsActivity extends Activity {

    ListView lvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        lvProducts = (ListView) findViewById(R.id.lvProducts);

        List<Product1> productList = new ArrayList<>();
        productList.add(new Product1("Drafter", "2years", "200", R.drawable.books, "Stationary",
                "In good condition with all markings", "Chakku", "27194901", "ECIL", "VCE"));
        productList.add(new Product1("ECE Guide Books", "7months", "600", R.drawable.civil, "Reference Books",
                "Unused", "Jo", "27895126", "MEHDIPATNAM", "VBIT"));
        productList.add(new Product1("NodeMCU", "3 years", "100", R.drawable.electronics, "Electronics",
                "Working", "Nidhi", "27114906", "MAREDPALLY", "SNIST"));

        ProductsArrayAdapter productsAdapter = new ProductsArrayAdapter(SearchResultsActivity.this,
                R.layout.productlistviewlayout, productList);

        lvProducts.setAdapter(productsAdapter);

    }
}
