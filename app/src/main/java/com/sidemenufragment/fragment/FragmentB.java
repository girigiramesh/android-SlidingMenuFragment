package com.sidemenufragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sidemenufragment.R;

/**
 * Created by Ramesh on 8/30/16.
 */
public class FragmentB extends Fragment {
    public FragmentB() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_2, container, false);
        return rootview;
    }
}
