package sravya.example.com.project1;

import android.content.Intent;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.newproduct_add, container, false);
        if(container!=null)
        {
            container.removeAllViews();

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

                }
                Intent homeintent=new Intent(view.getContext(),MainActivity.class);
                startActivity(homeintent);

                Toast.makeText(getActivity(), "Please enter product description", Toast.LENGTH_SHORT).show();


            }
        });

        return v;

    }
   /* @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                android.support.v4.app.Fragment fragment4 =new ProductFragment();
                 if(fragment4!=null)
                {
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    FragmentTransaction ft5=fragmentManager.beginTransaction();
                    ft5.replace(R.id.drawer_layout,fragment4);
                    ft5.commit();
                }
               /*DrawerLayout drawer = (DrawerLayout)view.findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);*/

               // Toast.makeText(getActivity(), "you submitted item", Toast.LENGTH_SHORT).show();
       /*     }
        });
    }*/
}
