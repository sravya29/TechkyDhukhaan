
package sravya.example.com.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class search_products extends AppCompatActivity {
    ListView search_products;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_products);
        search_products=(ListView)findViewById(R.id.search_products);
        ArrayList<String> arrayProducts=new ArrayList<>();
        arrayProducts.addAll(Arrays.asList(getResources().getStringArray(R.array.my_products)));
        adapter=new ArrayAdapter<String>(
                search_products.this,
                android.R.layout.simple_list_item_1,
                arrayProducts
        );
        search_products.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem item=menu.findItem(R.id.search_products);
        SearchView searchView= (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
      return super.onCreateOptionsMenu(menu);
    }
}

