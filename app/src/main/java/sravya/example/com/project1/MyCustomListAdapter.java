package sravya.example.com.project1;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by SRAVYA on 21-01-2018.
 */

public class MyCustomListAdapter extends ArrayAdapter<Hero> {

    Context ctxt;
    int resource;
    List<Hero> herolist;
    public MyCustomListAdapter(Context ctxt,int resource,List<Hero> herolist)
    {
        super(ctxt,resource,herolist);
        this.ctxt=ctxt;
        this.resource=resource;
        this.herolist=herolist;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(ctxt);
        View view=inflater.inflate(resource,null,false);
        ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
        Hero hero=herolist.get(position);
        imageView.setImageDrawable(ctxt.getResources().getDrawable(hero.getImage()));
        return view;
    }
}
