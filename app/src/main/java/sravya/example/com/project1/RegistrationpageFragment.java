package sravya.example.com.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by SRAVYA on 04-02-2018.
 */

public class RegistrationpageFragment extends Fragment {
    EditText etName, etUsername, etEmailID, etPasswordEntry, etPasswordReentry, etPhoneNumber;
    Spinner spnLocation, spnInstitution;
    Button btnRegSubmit;
    Intent RegSubmitIntent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.activity_registration_page, container, false);
        if(container!=null)
        {
            container.removeAllViews();

        }
        etName = (EditText) v.findViewById(R.id.etName);
        etUsername = (EditText)v.findViewById(R.id.etUsername);
        etEmailID = (EditText) v.findViewById(R.id.etEmailID);
        etPasswordEntry = (EditText) v.findViewById(R.id.etPasswordEntry);
        etPasswordReentry = (EditText)v. findViewById(R.id.etPasswordReentry);
        etPhoneNumber = (EditText)v. findViewById(R.id.etPhoneNumber);
        btnRegSubmit = (Button) v.findViewById(R.id.btnRegSubmit);
        spnLocation = (Spinner)v. findViewById(R.id.spnLocation);
        spnInstitution = (Spinner)v. findViewById(R.id.spnInstitution);

        String institutions[] = new String[]{
                "Choose your institusion",
                "VASAVI COLLEGE OF ENGINEERING",
                "VIGNAN BHARATHI INSTITUTE OF TECHNOLOGY",
                "J B INSTITUTE OF TECHNOLOGY",
                "SREENIDHI INSTITUTE OF SCIENCE AND TECHNOLOGY",
                "CHAITANYA BHARATHI INSTITUTE OF TECHNOLOGY",
                "MAHATMA GANDHI INSTITUTE OF TECHNOLOGY",
                "AURORA INSTITUTE OF TECHNOLOGY",
                "Others"
        };

        ArrayAdapter<String> institutionAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_spinner_dropdown_item, institutions);

        spnInstitution.setAdapter(institutionAdapter);

        String locations[] = new String[]{
                "Choose your Location",
                "A S RAO NAGAR",
                "KHAIRATHABAD",
                "MEHDIPATNAM",
                "SAFILGUDA",
                "AOC",
                "ECIL",
                "TANK BUND",
                "Others"
        };

        ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_spinner_dropdown_item, locations);

        spnLocation.setAdapter(locationAdapter);

        btnRegSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Registered successfully", Toast.LENGTH_SHORT).show();

                Intent homeintent=new Intent(view.getContext(),MainActivity.class);
                startActivity(homeintent);
            }
        });

        return v;
    }
}
