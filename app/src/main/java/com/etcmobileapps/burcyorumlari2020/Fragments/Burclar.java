package com.etcmobileapps.burcyorumlari2020.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.etcmobileapps.burcyorumlari2020.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Burclar extends Fragment {
    LinearLayout kocLy,bogaLy,ikizlerLy,yengecLy,aslanLy,basakLy,teraziLy,akrepLy,yayLy,oglakLy,kovaLy,balikLy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // bu fragment'in layout'unu hazır hale getirelim
        View view = inflater.inflate(R.layout.burclar_fragment, container, false);

        kocLy = view.findViewById(R.id.kocLy);
        bogaLy = view.findViewById(R.id.bogaLy);
        ikizlerLy = view.findViewById(R.id.ikizlerLy);
        yengecLy = view.findViewById(R.id.yengecLy);
        aslanLy = view.findViewById(R.id.aslanLy);
        basakLy = view.findViewById(R.id.basakLy);
        teraziLy = view.findViewById(R.id.teraziLy);
        akrepLy = view.findViewById(R.id.akrepLy);
        yayLy = view.findViewById(R.id.yayLy);
        kovaLy = view.findViewById(R.id.kovaLy);
        oglakLy = view.findViewById(R.id.oglakLy);
        balikLy = view.findViewById(R.id.balikLy);

        kocLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"koc");

            }
        });

        bogaLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"boga");

            }
        });

        ikizlerLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"ikizler");

            }
        });

        yengecLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"yengec");

            }
        });

        aslanLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"aslan");

            }
        });

        basakLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"basak");

            }
        });


        teraziLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"terazi");

            }
        });

        akrepLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"akrep");

            }
        });

        yayLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"yay");

            }
        });


        oglakLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"oglak");

            }
        });

        kovaLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"kova");

            }
        });

        balikLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragments(BurcDetay.class,"balik");

            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();




    }


    public void replaceFragments(Class fragmentClass,String burc) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Bundle bundle = new Bundle();
        bundle.putString("burc", burc);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().addToBackStack("main").replace(R.id.fragmentLayout, fragment)
                .commit();
    }

}