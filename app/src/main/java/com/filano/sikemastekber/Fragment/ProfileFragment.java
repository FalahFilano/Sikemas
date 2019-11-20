package com.filano.sikemastekber.Fragment;

import android.content.Context;
import android.content.Intent;
import android.icu.util.ValueIterator;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.filano.sikemastekber.Activity.BluetoothActivity;
import com.filano.sikemastekber.Activity.LoginActivity;
import com.filano.sikemastekber.R;


public class ProfileFragment extends Fragment {

    private Button button;
    private Context context;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        button = rootView.findViewById(R.id.btnLogout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(rootView.getContext(), LoginActivity.class);
                context.startActivity(intent);
                Toast.makeText(context, "Logout Success", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
