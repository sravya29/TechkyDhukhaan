package sravya.example.com.project1;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by SRAVYA on 30-01-2018.
 */

public class ProductListAdapter extends ArrayAdapter<Product> {
    Context ctxt;
    int resource;
    List<Product> productList;
    public ProductListAdapter(Context ctxt,int resource,List<Product> productList)
    {
        super(ctxt,resource,productList);
        this.ctxt=ctxt;
        this.resource=resource;
        this.productList=productList;
    }

}
