package sravya.example.com.project1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRAVYA on 30-01-2018.
 */

public class HomeFragment extends android.support.v4.app.Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List<Hero> herolist;
        ListView listView;

        if(container!=null) {
            container.removeAllViews();
        }

        View v = inflater.inflate(R.layout.activity_main, container, false);
        ListView lstItems = (ListView)v.findViewById(R.id.listView);
        herolist=new ArrayList<>();
        herolist.add(new Hero(R.drawable.ic_menu_gallery));
        herolist.add(new Hero(R.drawable.ic_menu_camera));
        herolist.add(new Hero((R.drawable.ic_menu_gallery)));
        herolist.add(new Hero(R.drawable.books));
        herolist.add(new Hero(R.drawable.electronics));
        herolist.add(new Hero(R.drawable.civil));
        herolist.add(new Hero(R.drawable.software));
        herolist.add(new Hero(R.drawable.mechanical));
       // ArrayList<String> prueba = new ArrayList<String>();
       /* prueba.add("Element1");
        prueba.add("Element2");
        prueba.add("Element3");*/
        MyCustomListAdapter allItemsAdapter = new MyCustomListAdapter(getActivity().getBaseContext(),R.layout.my_list,herolist);
        lstItems.setAdapter(allItemsAdapter);
        return v;
        }


}
