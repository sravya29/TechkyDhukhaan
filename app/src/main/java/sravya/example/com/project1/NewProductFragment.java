package sravya.example.com.project1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by SRAVYA on 30-01-2018.
 */

public class NewProductFragment extends android.support.v4.app.Fragment{
    TextView head,type;
    Spinner protype,sage;
    TextView imghead,desc,age,pricehead;
    Button upload,submit;
    EditText descript,pricee;
    ImageView pic;
    List<Product1> item;
    private MobileServiceClient mClient;
    private MobileServiceTable<Product> mProductTable;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.newproduct_add, container, false);
        if(container!=null)
        {
            container.removeAllViews();

        }
        try {

            AzureMobileServiceAdapter.Initialize(getActivity());
            mClient = AzureMobileServiceAdapter.getInstance().getClient();

            mProductTable = mClient.getTable(Product.class);

            //mTextProdName = (EditText) findViewById(R.id.textProdName);
//            mTextProdPrice = (EditText) findViewById(R.id.textProdPrice);

        } catch (Exception e){

        }
        head= (TextView)v.findViewById(R.id.head);
        type=(TextView)v.findViewById(R.id.type);
        age=(TextView)v.findViewById(R.id.age);
        pricehead=(TextView)v.findViewById(R.id.pricehead);
        protype= (Spinner)v.findViewById(R.id.protype);
        sage=(Spinner)v.findViewById(R.id.sage);
        imghead=(TextView)v.findViewById(R.id.imghead);
        upload=(Button)v.findViewById(R.id.upload);
        desc=(TextView)v.findViewById(R.id.desc);
        submit=(Button)v.findViewById(R.id.submit);
        descript=(EditText)v.findViewById(R.id.descript);
        pricee=(EditText)v.findViewById(R.id.pricee);
        pic=(ImageView)v.findViewById(R.id.pic);
        String [] types={"NONE","REFERENCE BOOKS","STATIONARY","EQUIPMENTS","GUIDE BOOKS","WRITTEN NOTES","OTHERS"};
        String [] ages={"< 2 months","2 months","4 months","8 months","1 year","> 1 year"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_spinner_dropdown_item,types);
        protype.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_spinner_dropdown_item,ages);
        sage.setAdapter(adapter1);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });

      submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(descript.getText().toString())
                        ) {
                    Toast.makeText(getActivity(), "Please enter product description", Toast.LENGTH_SHORT).show();

                }
                Intent homeintent=new Intent(view.getContext(),MainActivity.class);
                startActivity(homeintent);

            }
        });

        return v;

    }

    public Product addItemInTable(Product item) throws ExecutionException, InterruptedException {
        return mProductTable.insert(item).get();
    }
    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

}
