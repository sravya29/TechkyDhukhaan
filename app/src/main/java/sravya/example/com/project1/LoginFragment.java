package sravya.example.com.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SRAVYA on 04-02-2018.
 */

public class LoginFragment  extends Fragment
{
    EditText etUserID, etPassword;
    Button btnSubmit, btnSignUp, btnSearch;
    Intent SignUpIntent, SubmitIntent, SearchIntent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.activity_login1, container, false);
        if(container!=null)
        {
            container.removeAllViews();

        }
        etUserID = (EditText) v.findViewById(R.id.etUserID);
        etPassword = (EditText) v.findViewById(R.id.etPassword);
        btnSubmit = (Button) v.findViewById(R.id.btnSubmit);
       // btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etUserID.getText()))
                    Toast.makeText(getActivity(), "Please enter User ID", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etPassword.getText()))
                    Toast.makeText(getActivity(), "Please enter Password", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(getActivity(),"logged in successfully",Toast.LENGTH_SHORT).show();
                    Intent homeintent=new Intent(view.getContext(),MainActivity.class);
                    startActivity(homeintent);
                }
            }
        });
        return v;
    }
}
