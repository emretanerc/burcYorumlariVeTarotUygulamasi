package com.etcmobileapps.burcyorumlari2020.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;

import com.etcmobileapps.burcyorumlari2020.Api.ApiClient;
import com.etcmobileapps.burcyorumlari2020.Api.GunlukModel;
import com.etcmobileapps.burcyorumlari2020.Api.HayModel;
import com.etcmobileapps.burcyorumlari2020.Api.Interface;
import com.etcmobileapps.burcyorumlari2020.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BurcGHAY extends Fragment {
    String burc, mod = null;
    TextView burcYorumu;
    FloatingActionButton paylas;
    private List<GunlukModel> gunlukList;
    private List<HayModel> hayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // bu fragment'in layout'unu hazır hale getirelim
        View view = inflater.inflate(R.layout.burcgha, container, false);

        burcYorumu = view.findViewById(R.id.burcyorumu);
        paylas = view.findViewById(R.id.action);

        paylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String paylasMod=null;
                burc = burc.substring(0, 1).toUpperCase() + burc.substring(1).toLowerCase();
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                switch (mod) {
                    case "gunluk":
                        paylasMod="Günlük";
                        break;
                    case "haftalik":
                        paylasMod="Haftalık";
                        break;

                    case "aylik":
                        paylasMod="Aylık";


                        break;

                    case "yillik":
                        paylasMod="Yıllık";


                        break;
                }

                shareIntent.putExtra(Intent.EXTRA_TEXT, burc + " Burcunun " + paylasMod + " Yorumu \n \n" + burcYorumu.getText() + "\n \n Daha fazlası için mobil uygulamamızı indir. " + " \n bit.ly/burcyorumlari2021");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,burc + " Burcunun Yorumu");
                startActivity(Intent.createChooser(shareIntent, "Paylaş..."));

            }
        });


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            burc = bundle.getString("burc", "default");
            mod = bundle.getString("mod", "default");


        }




        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

       burcDetayGetir(mod);

    }


    public void burcDetayGetir(String mode) {

        switch (mode) {
            case "gunluk":
                 gunlukGetir();
                break;
            case "haftalik":

            hayGetir();
                break;

            case "aylik":
                hayGetir();

                break;

            case "yillik":
                hayGetir();

                break;

            default:
                break;

        }


    }


    public void gunlukGetir() {

        final Interface[] restInterface = new Interface[1];
        restInterface[0] = ApiClient.getClient().create(Interface.class);
        Call<List<GunlukModel>> call = restInterface[0].gunlukGetir(burc);
        call.enqueue(new Callback<List<GunlukModel>>() {
            @Override
            public void onResponse(Call<List<GunlukModel>> call, Response<List<GunlukModel>> response) {
                gunlukList = response.body();


                if(gunlukList.get(0).getGunlukYorum().toString().equals("")) {

                    burcYorumu.setText("Maalesef şuan burç yorumunuz hazır değil. Diğer yorumlarınıza bakabilirsiniz.");

                } else {
                    burcYorumu.setText(gunlukList.get(0).getGunlukYorum());
                }

            }

            @Override
            public void onFailure(Call<List<GunlukModel>> call, Throwable t) {
                Log.e("Hata", t.toString());
            }
        });

    }

    public void hayGetir() {

        final Interface[] restInterface = new Interface[1];
        restInterface[0] = ApiClient.getClient().create(Interface.class);
        Call<List<HayModel>> call=null;
        if (mod.equals("haftalik")) {
            call = restInterface[0].hayGetir(burc,mod);
        } else if (mod.equals("aylik")) {
            call = restInterface[0].hayGetir(burc,mod);
        } else if (mod.equals("yillik")){
            call = restInterface[0].hayGetir(burc,mod);
        }
        call.enqueue(new Callback<List<HayModel>>() {
            @Override
            public void onResponse(Call<List<HayModel>> call, Response<List<HayModel>> response) {
                hayList = response.body();

                if(hayList.get(0).getYorum().toString().equals("")) {

                    burcYorumu.setText("Maalesef şuan burç yorumunuz hazır değil. Diğer yorumlarınıza bakabilirsiniz.");


                } else {
                    burcYorumu.setText(hayList.get(0).getYorum());
                }

            }

            @Override
            public void onFailure(Call<List<HayModel>> call, Throwable t) {
                Log.e("Hata", t.toString());
            }
        });

    }

}

