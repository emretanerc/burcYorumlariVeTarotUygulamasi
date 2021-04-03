package com.etcmobileapps.burcyorumlari2020;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.etcmobileapps.burcyorumlari2020.Fragments.Burclar;
import com.etcmobileapps.burcyorumlari2020.Fragments.NameUyum;
import com.etcmobileapps.burcyorumlari2020.Fragments.TarotFal;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    FrameLayout fragmentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentLayout = findViewById(R.id.fragmentLayout);





        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new Burclar());


    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new Burclar();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new TarotFal();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new Burclar();
                    break;
                case R.id.navigation_notificationss:
                    selectedFragment = new NameUyum();
                    break;
            }
            loadFragment(selectedFragment);
            return true;
        }
    };




    public void replaceFragments(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentLayout, fragment)
                .commit();
    }

    private void loadFragment(Fragment fragment) { //fragmentlarımızı çağırdığımız fonksiyon

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentLayout, fragment);
        transaction.addToBackStack("q");
        transaction.commit();
    }


}