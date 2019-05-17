package com.filano.sikemastekber.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.filano.sikemastekber.Activity.LoginActivity;
import com.filano.sikemastekber.R;
import com.filano.sikemastekber.Response.LogoutResponse;
import com.filano.sikemastekber.Retrofit.ApiClient;
import com.filano.sikemastekber.Retrofit.ApiInterface;
import com.filano.sikemastekber.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private TextView tvName, tvNoIdentitas;
    private Button btnLogout;

    private SessionManager sessionManager;
    private ApiInterface api;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        sessionManager = new SessionManager(getContext());
        api = ApiClient.getInstance().create(ApiInterface.class);

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvName = view.findViewById(R.id.tvName);
        tvNoIdentitas = view.findViewById(R.id.tvNoIdentitas);
        btnLogout = view.findViewById(R.id.btnLogout);

        tvName.setText(sessionManager.getName());
        tvNoIdentitas.setText(sessionManager.getNoIdentitas());
        btnLogout.setOnClickListener(this);

        return view;
    }

    public void logout() {
        api.logout(sessionManager.getToken()).enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                String status = response.body().getStatus();
                if (status.equals("success")) {
                    sessionManager.logout();
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                } else if (status.equals("error")) {
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogout:
                logout();
                break;
        }
    }
}
