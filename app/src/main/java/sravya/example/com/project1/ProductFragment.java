package sravya.example.com.project1;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRAVYA on 29-01-2018.
 */

public class ProductFragment extends android.support.v4.app.Fragment {
    List<Product> productList;
    ListView listView1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        List<Product> productList;
        ListView listView1;
        if(container!=null)
        {
            container.removeAllViews();

        }
       /* productList=new ArrayList<>();
        listView1=(ListView)findViewById(R.id.listView1);
        ProductListAdapter adapter=new ProductListAdapter(new MainActivity(),R.layout.product_mylist,productList);
        listView1.setAdapter(adapter);*/
        View v = inflater.inflate(R.layout.myproductlist, container, false);
        ListView lstItems = (ListView)v.findViewById(R.id.lvProducts);
        productList=new ArrayList<>();
        return v;
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.editbutton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getActivity(),"you edited item",Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.delbutton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getActivity(),"you deleted item",Toast.LENGTH_SHORT).show();
            }
        });



    }

}
