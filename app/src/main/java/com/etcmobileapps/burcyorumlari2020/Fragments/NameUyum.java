package com.etcmobileapps.burcyorumlari2020.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;

import com.etcmobileapps.burcyorumlari2020.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class NameUyum extends Fragment {
    LinearLayout tarotLy,isimSonucLy;
    Integer sozcukToplamı = 0;
    EditText isim1,isim2;
    TextView isim1Sonuc,sozcukBaslik;
    FloatingActionButton paylas;
    Button bul;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // bu fragment'in layout'unu hazır hale getirelim
        View view = inflater.inflate(R.layout.isimuyumu_fragment, container, false);

        isim1 =view.findViewById(R.id.isim1);


        isim1Sonuc =view.findViewById(R.id.isim1Sonuc);
        sozcukBaslik =view.findViewById(R.id.sozcukBaslik);
        paylas = view.findViewById(R.id.floatingActionButton2);

        isimSonucLy = view.findViewById(R.id.isimSonucLy);

        bul = view.findViewById(R.id.button);


        paylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = String.valueOf(isim1.getText());
                username = username.toLowerCase();
                username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, username + " isminin Kader Anlamı " + isim1Sonuc.getText() + "\n \n Daha fazlası için mobil uygulamamızı indir. " + " \n bit.ly/burcyorumlari2021");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,username + " İsminin Kader Anlamı");
                startActivity(Intent.createChooser(shareIntent, "Paylaş..."));


            }
        });
        bul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ((isim1.getText().equals("") || (isim1.getText().length() < 3))){


                    Toast.makeText(getContext(), "Uzunluk " + isim1.getText().length(), Toast.LENGTH_SHORT).show();

                    Toast.makeText(getContext(), "Lütfen isim bölümünü boş bırakmayınız.", Toast.LENGTH_SHORT).show();




                } else {

                    String sonuc1 = String.valueOf(sonuc(isim1.getText().toString().toLowerCase()));

                    String username = String.valueOf(isim1.getText());
                    username = username.toLowerCase();
                    username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase();

                    isim1Sonuc.setText(anlam(Integer.parseInt(sonuc1)));

                    sozcukBaslik.setText(username + " İsminin Kaderi");

                    isimSonucLy.setVisibility(View.VISIBLE);


                }

                InputMethodManager imm = (InputMethodManager)getContext().getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

            }
        });




        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


    }


    public static int harfDegeri(String harf) {


        if (harf.equals("a") || harf.equals("j") || harf.equals("s") || harf.equals("ş")) {
            return 1;
        } else if (harf.equals("b") || harf.equals("k") || harf.equals("t")) {

            return 2;
        } else if (harf.equals("c") || harf.equals("ç") || harf.equals("l") || harf.equals("u") || harf.equals("ü")) {

            return 3;
        } else if (harf.equals("d") || harf.equals("m") || harf.equals("v")) {

            return 4;
        } else if (harf.equals("e") || harf.equals("n") || harf.equals("w")) {

            return 5;
        } else if (harf.equals("f") || harf.equals("o") || harf.equals("ö") || harf.equals("x")) {

            return 6;
        } else if (harf.equals("g") || harf.equals("ğ") || harf.equals("p") || harf.equals("y")) {

            return 7;
        } else if (harf.equals("h") || harf.equals("q") || harf.equals("z")) {

            return 8;
        } else if (harf.equals("ı") || harf.equals("i") || harf.equals("r")) {
            return 9;
        }

        return 0;
    }


    public int sonuc(String metin) {

        String dizi[] = new String[metin.length()];
        for (int i = 0; i < metin.length(); i++) {
            String harf = metin.substring(i, i + 1);
            dizi[i] = harf;
        }


        for (int a = 0; a < metin.length(); a++) {
            sozcukToplamı = sozcukToplamı + harfDegeri(dizi[a]);

            //  System.out.println(harfDegeri(dizi[a]));
            //     System.out.println(metin.length());
            if (a + 1 == metin.length()) {

                System.out.println(sozcukToplamı);


                if (sozcukToplamı >= 10) {
                    Integer sayıToplamı = 0;
                    while (sozcukToplamı > 0) {

                        // Mod ile son rakamı sonuc değişkenine ekliyoruz.
                        sayıToplamı += (sozcukToplamı % 10);

                        /** 10'a bölerek son rakamı virgül sonrasına atıyoruz.
                         * int değerlerde virgülden sonrasını almadığı için otomatikman
                         * son rakam siliniyor ve tekrar modu alınarak aynı işlem
                         * uygulanıyor.
                         */
                        sozcukToplamı = sozcukToplamı / 10;


                    }


                    System.out.println(metin + " " + "Girdiğiniz sayının rakamları toplamı: " + sayıToplamı);
                    return sayıToplamı;
                } else {
                    Integer sayıToplamı=null;
                    while (sozcukToplamı > 0) {



                    return sozcukToplamı;}

                }


            }

        }
        return 0;
    }


    public String anlam(Integer deger) {

        switch (deger) {
            case 1: return "Bağımsızlığına ve özgürlüğüne düşkündür. Yaratıcıdır ve egoları yüksektir. Kendine düşkündür. Bu insanların liderlik özellikleri ön plandadır. Oldukça hırslıdır ve iş hayatında aşırılıktan kaçınmalıdır.  Hem aceleci davranmaktan hem de hükmedici davranmaktan uzak durmalılar.";

            case 2:
                return "Sezgileri kuvvetlidir. İş birlikçidir ve aşırı duyarlıdır. Tasarım ve kavrama yeteneği vardır. Bu insan hem barış yanlısıdır hem de sevgi doludur. Eleştirici biridir ve ortaklık için en çok idealdir. Detaylara fazla takılıp kalmamalı ve yalnız kalmamaya özen göstermelidir.";

            case 3:
                return "Sanatsal anlamda çok kabiliyetlidir. Sosyal bir kişiliğe sahiptir. Dost canlısıdır ve yüzeysel düşünür. Dışa dönük bir insandır. Eğlenceyi sever ve hayattan zevk alır. Monotonluğu sevmez, yaratıcı ve duyarlıdır. Disiplin konusunda sıkıntıları vardır  ve disiplinli olmayı öğrenmelidir.";

            case 4:
                return "Sağlam bir karakteri vardır. Pratik bir insandır ve oldukça güvenilirdir. Çalışma konusunda oldukça disiplinlidir. Başarılı olmak için her şeyi yapar. Çok iyi bir arkadaştır. Aşırı güvenlik duygusunun kaçınmalıdır.";

            case 5:
                return "Özgürlüğüne düşkündür ve gezmeyi çok sever. Uyum içinde yaşamayı bilir. Erotizme de eğilimli biridir. Cesaret konusunda iyidir ve ikna kabiliyeti yüksektir. Güzel şeyleri kendisinde toplamayı sever. Can sıkıntısına hiç gelemez. Bu yüzden dikkatli olmalıdır ve amacından sapmamalıdır. ";

            case 6:
                return "Aşk adamıdır ve sorumluluklarının farkındadır. Anlayışlıdır ve her şeye karışır. Aşık olduğu kadar kıskançtır. Mutlu ve sıcak bir kişiliğe sahiptir. Güvenilir, koruyucu ve sağlam kişiliğe sahiptir. Sevdiği için her şeyi yapar. Fedakarlıktan kaçınmaz. Başkaları tarafından ihmal edilmiş olma duygusunda ve aşırı kötümser hissetmekten kaçınmalıdır.";

            case 7:
                return "Zeki ve ruhsal yönden kuvvetlidir. Zihin analizini iyi yapar ve eleştiren bir kişiliğe sahiptir. Oldukça baskındır ve sır saklamayı bilir. Düşünür gibi derinlere dalar. Değişken bir yapısı vardır. İyi şeyleri elde edememe ve yalnız kalma duygusunu bir kenara atmalı. Soğuk ve mesafeli durmaktan kaçınmalıdır.";

            case 8:
                return "Yöneticilik yetenekleri ön planda olur. Organizasyon yeteneği oldukça yüksektir. Güçlü bir kişiliğe sahiptir ve maddi anlamda oldukça güçlüdür. Kararlı ve sonuca odaklı bir kişiliğe sahiptir. Parasal anlamda oldukça başarılıdır. Amacına giden yolda karşısında gördüğü insanlara karşı vurdumduymaz ve duygusuz davranmaktan kaçınmalıdır. ";

            case 9:
                return "Sanatsal anlamda yeteneklidir. Hümanist bir kişiliğe sahiptir. Romantizm ve duygusallık onun işidir. Konforu seven biridir. Sezgileri oldukça kuvvetlidir. Duyarlı ve yaratıcı özelliklere sahiptir. Kendisini ispatlamak için her şeyi yapar. Tek yapması gereken kötü alışkanlıklarını terketmek ve küçük detayları takılıp kalmamaktır. ";

            case 11:
                return "Sezgi gücü gelişmiştir. Ülkücü özellikleri ön plandadır. Keşif yeteneği gelişmiş ve oldukça duyarlıdır. Aynı zamanda fanatiktir. Hayal eder ve öngörüleri oldukça iyidir. Sanatsal özellikleri de öne çıkar. Gergin olmamalı ve aşırı duyarlı olmamaya gayret etmelidir.";



            default:
                return "";

        }

    }
}