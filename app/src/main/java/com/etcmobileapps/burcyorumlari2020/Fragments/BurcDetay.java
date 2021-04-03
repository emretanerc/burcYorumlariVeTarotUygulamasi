package com.etcmobileapps.burcyorumlari2020.Fragments;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.etcmobileapps.burcyorumlari2020.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class BurcDetay extends Fragment {
 String burc=null;
 TextView burcTarihleriTxt,burcAdiTxt,gezegenTxt,elementTxt,mottoTxt;
 ImageView burcGorsel;
FrameLayout frameLayout;
TabItem fr1,fr2,fr3,fr4;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] pageTitle = {"Günlük", "Haftalık", "Aylık"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // bu fragment'in layout'unu hazır hale getirelim
        View view = inflater.inflate(R.layout.burclardetay_fragment, container, false);

        burcGorsel = view.findViewById(R.id.burcGorsel);
        burcAdiTxt = view.findViewById(R.id.burcAdiTxt);
        gezegenTxt = view.findViewById(R.id.gezegenTxt);
        elementTxt = view.findViewById(R.id.elementTxt);
        mottoTxt = view.findViewById(R.id.mottoTxt);
        burcTarihleriTxt = view.findViewById(R.id.burcTarihleriTxt);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
             burc = bundle.getString("burc", "default");
        }

        frameLayout = view.findViewById(R.id.fragmentLayout);
        tabLayout = view.findViewById(R.id.tab_layout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0) {
                    burcDetayGetir(BurcGHAY.class,burc,"gunluk");
                } else if (tab.getPosition()==1) {
                    burcDetayGetir(BurcGHAY.class,burc,"haftalik");
                } else if (tab.getPosition()==2) {
                    burcDetayGetir(BurcGHAY.class,burc,"aylik");
                } else if (tab.getPosition()==3) {
                    burcDetayGetir(BurcGHAY.class,burc,"yillik");
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        burcDetayGetir(BurcGHAY.class,burc,"gunluk");



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        burcGetir(burc);


    }




    public void burcGetir(String burc) {

        switch(burc) {
            case "koc":
                burcGorsel.setImageResource(R.drawable.koc);
                burcAdiTxt.setText("Koç");
                gezegenTxt.setText("Gezegen: Mars");
                elementTxt.setText("Element: Ateş");
                mottoTxt.setText("Motto: Yeter ki hevesim kırılmasın!");
                burcTarihleriTxt.setText("Tarihler: 21 Mart - 20 Nisan");
                break;

            case "boga":
                burcGorsel.setImageResource(R.drawable.boga);
                burcAdiTxt.setText("Boğa");
                gezegenTxt.setText("Gezgen: Venüs");
                elementTxt.setText("Element: Toprak");
                mottoTxt.setText("Motto: İyi bir hayat için huzur gerekir!");
                burcTarihleriTxt.setText("Tarihler: 21 Nisan - 20 Mayıs");
                break;

            case "ikizler":
                burcGorsel.setImageResource(R.drawable.ikizler);
                burcAdiTxt.setText("İkizler");
                gezegenTxt.setText("Gezegen: Merkür");
                elementTxt.setText("Element: Hava");
                mottoTxt.setText("Motto: Arkadaşlarım benim için her zaman önceliklidir!");
                burcTarihleriTxt.setText("Tarihler: 21 Mayıs - 21 Haziran");
                break;

            case "yengec":
                burcGorsel.setImageResource(R.drawable.yengec);
                burcAdiTxt.setText("Yengeç");
                gezegenTxt.setText("Gezegen: Ay");
                elementTxt.setText("Element: Su");
                mottoTxt.setText("Motto: Merhametsiz insanları hayatım boyunca anlamayacağım!");
                burcTarihleriTxt.setText("Tarihler: 22 Haziran - 22 Temmuz");
                break;

            case "aslan":
                burcGorsel.setImageResource(R.drawable.aslan);
                burcAdiTxt.setText("Aslan");
                gezegenTxt.setText("Gezegen: Güneş");
                elementTxt.setText("Element: Ateş");
                mottoTxt.setText("Motto: Benim dediklerim sonunda her zaman doğru çıkar!");
                burcTarihleriTxt.setText("Tarihler: 23 Temmuz - 22 Ağustos");
                break;

            case "basak":
                burcGorsel.setImageResource(R.drawable.basak);
                burcAdiTxt.setText("Başak");
                gezegenTxt.setText("Gezegen: Merkür");
                elementTxt.setText("Element: Toprak");
                mottoTxt.setText("Motto: Planları uyguladığımda başarılıyımdır.");
                burcTarihleriTxt.setText("Tarihler: 23 Ağustos - 22 Eylül");
                break;

            case "terazi":
                burcGorsel.setImageResource(R.drawable.terazi);
                burcAdiTxt.setText("Terazi");
                gezegenTxt.setText("Gezegen: Venüs");
                elementTxt.setText("Element: Hava");
                mottoTxt.setText("Motto: Lütfen benim dengemi bozmayınız!");
                burcTarihleriTxt.setText("Tarihler: 23 Eylül - 23 Ekim");
                break;


            case "akrep":
                burcGorsel.setImageResource(R.drawable.akrep);
                burcAdiTxt.setText("Akrep");
                gezegenTxt.setText("Gezegen: Mars,Pluton");
                elementTxt.setText("Element: Su");
                mottoTxt.setText("Motto: Herkes bu dünyaya yalnız gelir, yalnız gider!");
                burcTarihleriTxt.setText("Tarihler: 24 Ekim - 22 Kasım");
                break;

            case "yay":
                burcGorsel.setImageResource(R.drawable.yay);
                burcAdiTxt.setText("Yay");
                gezegenTxt.setText("Gezegen: Jupiter");
                elementTxt.setText("Element: Ateş");
                mottoTxt.setText("Motto: İyi bakarsan iyi görürsün.");
                burcTarihleriTxt.setText("Tarihler: 23 Kasım - 22 Aralık");
                break;

            case "oglak":
                burcGorsel.setImageResource(R.drawable.oglak);
                burcAdiTxt.setText("Oğlak");
                gezegenTxt.setText("Gezegen: Satürn");
                elementTxt.setText("Element: Toprak");
                mottoTxt.setText("Motto: Emek olmadan yemek olmaz!");
                burcTarihleriTxt.setText("Tarihler: 22 Aralık - 20 Ocak");
                break;

            case "kova":
                burcGorsel.setImageResource(R.drawable.kova);
                burcAdiTxt.setText("Kova");
                gezegenTxt.setText("Gezegen: Uranüs");
                elementTxt.setText("Element: Hava");
                mottoTxt.setText("Motto: Özgür olmayı biliyorum.");
                burcTarihleriTxt.setText("Tarihler: 21 Ocak - 18 Şubat");
                break;

            case "balik":
                burcGorsel.setImageResource(R.drawable.balik);
                burcAdiTxt.setText("Balık");
                gezegenTxt.setText("Gezegen: Neptün");
                elementTxt.setText("Element: Su");
                mottoTxt.setText("Motto: İnanmak yaşamın en anlamlı noktasıdır.");
                burcTarihleriTxt.setText("Tarihler: 19 Şubat - 20 Mart");
                break;
            default:
                // code block
        }
    }



    public void burcDetayGetir(Class fragmentClass,String burc,String mod) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Bundle bundle = new Bundle();
        bundle.putString("burc", burc);
        bundle.putString("mod", mod);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.detayLayout, fragment)
                .commit();
    }



}