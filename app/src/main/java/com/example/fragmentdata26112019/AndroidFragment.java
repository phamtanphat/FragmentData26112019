package com.example.fragmentdata26112019;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AndroidFragment extends Fragment {

    View v;
    EditText edtAndroid;
    Button btnAndroid;

    public AndroidFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_android, container, false);
        edtAndroid = v.findViewById(R.id.edittextAndroid);
        btnAndroid = v.findViewById(R.id.buttonAndroid);
        Bundle bundle = getArguments();
        String value = bundle.getString("text");
        edtAndroid.setText(value);
        return v;
    }
}
