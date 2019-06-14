package com.example.kindersmart.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.example.kindersmart.R;

public class ConnectionErrorFragment extends Fragment {
    private LottieAnimationView NoInternet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater,container,savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_connection_error,container,false);
        NoInternet = v.findViewById(R.id.animation_view);

        return v;
    }
}