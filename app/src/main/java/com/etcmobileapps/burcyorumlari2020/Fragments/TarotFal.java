package com.etcmobileapps.burcyorumlari2020.Fragments;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import com.etcmobileapps.burcyorumlari2020.Api.ApiClient;
import com.etcmobileapps.burcyorumlari2020.Api.GunlukModel;
import com.etcmobileapps.burcyorumlari2020.Api.HayModel;
import com.etcmobileapps.burcyorumlari2020.Api.Interface;
import com.etcmobileapps.burcyorumlari2020.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TarotFal extends Fragment {
    LinearLayout tarotLy,sonucLy;
    ImageView tarotKarti;
    TextView kartAnlami,sonucTxtValue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // bu fragment'in layout'unu hazır hale getirelim
        View view = inflater.inflate(R.layout.tarot_fragment, container, false);

        tarotLy = view.findViewById(R.id.tarotLy);
        tarotKarti = view.findViewById(R.id.imageView);
        sonucLy = view.findViewById(R.id.sonucLy);
        kartAnlami =view.findViewById(R.id.kartAnlami);
        sonucTxtValue = view.findViewById(R.id.sonucTxtValue);

        tarotLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kartSec();

            }
        });





        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


      //  Toast.makeText(getContext(), "1 adet Tarot Kartı seç ve falını gör.", Toast.LENGTH_SHORT).show();


    }


public void kartSec() {

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),
            R.style.Theme_MaterialComponents_Dialog);
    builder.setTitle("UYARI");
    builder.setMessage("Bu kartı seçmek istediğine emin misin?");
    builder.setNegativeButton("Hayır", null);
    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            rastgeleKartSec();



        }
    });
    builder.show();

}

@SuppressLint("SetTextI18n")
public void rastgeleKartSec() {

        tarotLy.setVisibility(View.GONE);
        sonucLy.setVisibility(View.VISIBLE);

    int min = 1;
    int max = 158;
    //Generate random double value from 50 to 100

    double random = Math.random() * (max - min + 1) + min;




        switch ((int) random) {
            case 1:
                sonucTxtValue.setText("Adelet Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/adaletinkarti.png").into(tarotKarti);
            kartAnlami.setText("Dengeyi ve olumlu kararları simgeler. Özellikle hayatın dengesini kuran hareket, bu kartı ifade eder. Bu kartı seçen kişi; kalp, zihin, ruh sağlığı, materyalizm, iş ve hareket için eşit zaman garantisiyle hayatını düzenlemeye başlar. Bu kişi, adaleti sağlamak için iç dürtülerini kullanır. “Ne ekersen onu biçersin” adalet kartının temel anlamıdır. Ayrıca bu kart, okulu sembolize eder.");
            break;

            case 2:
                sonucTxtValue.setText("Ters Adelet Kartı ");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/adaletinkarti.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Adaletsizlik, dengesizlik anlamlarını taşır. Yanlış bir kararı da gösterebilir. Bu kartı seçen kişi, haksızlıkla ve ön yargılı tavırlarla karşılaşabilir. Eğitimde problemler yaşanabilir. Öğrenme sorunu, öğretmen-öğrenci uyuşmazlığı, okul değişimi gerçekleşebilir. Merhametsiz, ön yargılı biriyle karşılaşma olasılığı yüksektir. Bu kartı seçen kişi, iç sesini dinlemez. Duygu, düşünce, iş ve eğlence yaşamında bir dengesizlik vardır.");
            break;
            case 3:
                sonucTxtValue.setText("Savaş Arabası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/savasarabasi.png").into(tarotKarti);
                kartAnlami.setText("Hislerin ve isteklerin kontrolü anlamına gelir. Bu kart, sorunların çözüldüğüne ve sıkıntılardan zaferle çıkıldığına işaret eder. Bu kartı seçen kişiler, düşüncelerinin duyarlılığını, kendilerini sorgularlar. Savaş arabası, negatif düşüncelerden uzak, tehlikenin üstesinden gelen kişilere yöneliktir. Kartın ana teması, tüm zorluklardan başarıyla çıkmaktır.");
                break;
            case 4:
                sonucTxtValue.setText("Ters Savaş Arabası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/savasarabasi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Yenilgiyi temsil eder. Bu kartta duyguların dengesi bozulur ve kontrol zor sağlanır. Olumsuzluk alışkanlıklara, bağımlılığa işaret eder. Bu kartı seçen kişi kendi kendini yer.");
                break;

            case 5:
                sonucTxtValue.setText("Asaların Altılısı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinaltilisi.png").into(tarotKarti);
                kartAnlami.setText("Başarı ve zaferi müjdeleyen bu kart, harcanılan emeklerin ödülleneceğini anlatır. Seçimlerinizin ya da çaba harcadığınız bir idealin daha iyi konumlarda çözümlenmesi beklenir. Azimli tavrınız ve güçlü isteğiniz yüzünüzü güldürecektir.");
                break;
            case 6:
                sonucTxtValue.setText("Ters Asaların Altılısı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinaltilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Başarı için çaba harcadığınız bir konu, başka biri üzerinden ilerleyebilir. İş, aşk ya da aile ilişkilerinizde kendinizi önemsiz hissettiğiniz bir dönemde de bu kart ile karşılaşabilirsiniz.");
                break;
            case 7:
                sonucTxtValue.setText("Asaların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinbeslisi.png").into(tarotKarti);
                kartAnlami.setText("Bu kartın hakim olduğu duygu rekabet ve çekişmedir. Karşılaşma olasılığınız olan tartışma ve kışkırtmalara karşı güçlü durmanız faydanıza olacaktır. İş, aşk ya da aile yaşamınızda ciddi uyuşmazlıklar ve düşünce ayrılıkları yaşanabilir. Karşınızdakiler bencilce davranabilir.");
                break;
            case 8:
                sonucTxtValue.setText("Ters Asaların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinbeslisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Ciddi tartışmalar ve anlaşmazlıkların sona ereceği bir dönemdesiniz. Bu bitiş ise yeni başlangıçların ilk adımı durumundadır. Rutin akışın yerini daha yenilikçi yaklaşımlar alacaktır. Fiziksel olarak sağlık ve sporla gelen yenilenme bu döneminizin önemli ayrıntılarıdır.");
                break;
            case 9:
                sonucTxtValue.setText("Asaların Dokuzlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarindokuzlusu.png").into(tarotKarti);
                kartAnlami.setText("Daha önceki deneyimlerinizden ötürü biraz daha temkinli ve savunma halinde olduğunuz söylenebilir. Öyle ki, kendinizi savunmak için ciddi bir tartışma veya kavgaya bile hazırlıklısınız. Halihazırda mücadele ettiğiniz bir sorununuz varsa henüz halledemediğiniz için biraz dikkatli olmanızda fayda var. Geçmişteki bir ilişki ya da sağlık sorunu tekrar gündeme gelebilir, hazırlıklı olmalısınız.");
                break;
            case 10:
                sonucTxtValue.setText("Ters Asaların Dokuzlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarindokuzlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Sahip olduğunuz hakların peşine düşmeme, bir nevi zayıflığın hakim olduğu bir tutum içinde olabilirsiniz. Karşılaşacağınız tartışma ve sorunlara karşı hazırlıklı olmalısınız. Sorunlarınız geçmişinizden gelen ve tekrarlanan bir sorun olabilir. Bu noktada asıl dikkatli olmanız gereken, genel olarak sizde hakim olan zayıflık tutumunu bu sorunlara karşı da sergilemeniz olabilir. Korkularınızdan arınmalısınız.");
                break;
            case 11:
                sonucTxtValue.setText("Asaların Dörtlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarindortlusu.png").into(tarotKarti);
                kartAnlami.setText("Kartınız size mutluluk getirecek bir başarının, hedefinize ulaşmanın getireceği keyfin habercisidir. Her ne konuda bir umdunuz varsa onun meyvelerini toplayacağınız an yakındır. Bu konular bir ilişki, iş, arkadaşlık ya da bir sağlık konusu olabilir.");
                break;
            case 12:
                sonucTxtValue.setText("Ters Asaların Dörtlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarindortlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Mutluluk, huzur ve başarının habercisi olan bu kart, planladığınız tüm hedeflerinizin başarıya ulaşacağına işaret eder.");
                break;
            case 13:
                sonucTxtValue.setText("Asaların İkilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinikilisi.png").into(tarotKarti);
                kartAnlami.setText("Kartta simgelenen tüccar ve arkasındaki asa, başlamayı düşündüğünüz girişimler ile daha önce elde ettiğiniz başarıların dengesini anlatır. Tüccarın geleceğine güvenle bakan bakışları sizin içinde bulunduğunuz duruma işarettir. Amaçladığınız şey sizin için fazlasıyla anlamlıdır ve karttaki asa dünya gerçekliğini simgeleyerek, hedefiniz ile gerçekliğinizi dengelemektedir. Bu kart iş, okul ile ilgili ya da bir cevabın beklendiği aşamayı ifade eder.");
                break;
            case 14:
                sonucTxtValue.setText("Ters Asaların İkilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinikilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Aklınızda büyük bir azim ve duygu yoğunluğu ile bağlı olduğunuz fikirlerin devamlılığına rağmen, sonuçlanmayabileceği gerçeğini ifade eden bu kart, hayal kırıklıklarına hazırlıklı olmanızı tavsiye eder.");
                break;
            case 15:
                sonucTxtValue.setText("Asaların Kraliçesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinkralicesi.png").into(tarotKarti);
                kartAnlami.setText("İktidar ve sıcaklığın olağanüstü harmanı görülür. Başarı ve daha iyiye ulaşma iş ve özel hayatta motivasyonu getirmektedir. Sosyal hayat, politika, spor ve yaratıcılık isteyen alanlarda sürekli bir gelişim isteği vardır. Bu karta tiyatro, özgürlük ve kendini ifade etmeye yarayan her şey ilgi alanına dahildir. Aile ve arkadaşlarınız içinde sevilen ve imrenilen biri olmak bu tür isteklerden ve yeteneklerden ileri gelmektedir. Zaten bunlar büyük ölçüde başarılmış şeylerdir.");
                break;

            case 16:
                sonucTxtValue.setText("Ters Asaların Kraliçesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinkralicesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Olumsuz gelişmeleri haber veren bu kart, kandırma ve aldanmayı temsil eder. Bencillik kendini fazlasıyla gösterir. Bu kişi fazlasıyla hırslı bir idareci olabilir. Seksiliğini insanları şeytanca etkilemek için kullanır. Bilgileri ve haberleri saptırır ve olayları aldatıcı şekilde yansıtır.");
                break;

            case 17:
                sonucTxtValue.setText("Asaların Onlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinonlusu.png").into(tarotKarti);
                kartAnlami.setText("Kapasitenizin ya da koşullarınızın çok üstüne bir işe giriştiğiniz ya da girişmeyi düşündüğünüz bir dönemdesiniz. Bu kart bazen bir baskıyı bazen de hırstan kaynaklanan başarısızlığı ifade etmektedir. Gerçekleştirmeyi düşündüğünüz girişimlerin başarısızlığa uğrama nedenlerinin başında yeterli zaman ayırmayışınız ve fazla vaat sunuyor olmanız geliyor. Sağlık açısından ise belkemiği, sırt, iskelet, kas ve bazen de kalbinizle ilgili sorunlar yaşayabilirsiniz. Sağlık sorunları ise kendinize fazlasıyla sorumluluk ve iş yüklemeyle alakalı olabilir. Kendinize fazla yüklenmemeniz faydanıza olacaktır.");
                break;

            case 18:
                sonucTxtValue.setText("Ters Asaların Onlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinonlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Var olan ya da sizi bekleyen sağlık sorunları mevcuttur bu kartta. Başka birinin hastalığı sizi maddi ve manevi bir zorluğa götürebilir.");
                break;

            case 19:
                sonucTxtValue.setText("Asaların Sekizlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinsekizlisi.png").into(tarotKarti);
                kartAnlami.setText("Kendinize çizdiğiniz hedefe doğru oldukça yaklaşıyorsunuz. Hayalleriniz, umutlarınız ve duyduğunuz özlemler hızlı bir gerçekleşme dönemine girmiş durumda. Bu amaç doğrultusunda çok derin bağlılıklar yaşayabilirsiniz. Bu bağlılık aşk hayatınızla ilgili de olabilir. Spor gibi fiziksel anlamda sizi formda tutacak aktivitelere yönelebilirsiniz. Tüm bunların dışında uçakla gerçekleştireceğiniz bir yolculuk ile karşılaşabilirsiniz.");
                break;

            case 20:
                sonucTxtValue.setText("Ters Asaların Sekizlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinsekizlisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Zorluklar, tartışmalar ve engeller… Bu dönemde etrafınızdaki kişilere ve olaylara karşı zorlayıcı bir tutum sergilememeye özen göstermelisiniz. Aksi halde tartışmaların ve kırgınlıkların yaşanabileceğini unutmayın. Planladığınız bazı geziler varsa bunların da gerçekleşmeme olasılığını göz önünde bulundurmalısınız.");
                break;

            case 21:
                sonucTxtValue.setText("Asaların Üçlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinuclusu.png").into(tarotKarti);
                kartAnlami.setText("Daha önce alınan riskler, gelişme olarak geri dönmektedir. Kart size başarı, gelişim, olumlu sonuçlar, paylaşım dolu çabalar ve yardımsever öğütleri haber vermektedir.");
                break;

            case 22:
                sonucTxtValue.setText("Ters Asaların Üçlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinuclusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Sizin için idol olan biri gözünden düşme sürecindedir. Bu dönemde girişimleriniz sizi tatmin edecek anlamda ilerlemeyecektir. Bunun yanında ortak yapılan işler ya da etkinliklerde ciddi bir sorun yaşanabilir.");
                break;

            case 23:
                sonucTxtValue.setText("Asaların Yedilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinyedilisi.png").into(tarotKarti);
                kartAnlami.setText("Girişimlerinizde inişler-çıkışlar yaşadığınız bir dönem ardından, düşüncelerinizde ısrarcı olmaya devam edebilirsiniz. Hatta kendi içinizdeki mücadele ciddi savunma örnekleri göstermenizi ve inatçı olmanızı beraberinde getirir.");
                break;

            case 24:
                sonucTxtValue.setText("Ters Asaların Yedilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinyedilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu kart hiçbir yüzleşme anlamı içermez. Yani içinizde netleşmeyi bekleyen durumlar bir karşılaşma ile amacına ulaşamayacaktır. Aynı zamanda bu durum beklenen problemlerin de yaşanmayacağı anlamına gelmektedir.");
                break;

            case 25:
                sonucTxtValue.setText("Aşıklar Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asiklar.png").into(tarotKarti);
                kartAnlami.setText("Bu karttaki kişi kendini iyi bilmelidir. Bu kart, evliliğin ve dengeli bir ilişkinin simgesidir. Tam bir sağlık kartı diyebiliriz bu kart için. Bu kart, ikizler burcuna adanmıştır. Bu yüzden mantık ön plandadır. Dengeli ve uyumlu olduğundan şanslı sayısı 6’dır. Duygusal ve zihinsel görüşler kişiyi mutlu eder.");
                break;

            case 26:
                sonucTxtValue.setText("Ters Aşıklar Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asiklar.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu kart, yanlış kararları temsil eder. Kişi, duygularından yoksundur. Aile arasında problemler, anlaşmazlıklar ortaya çıkabilir. Sağlıkla ilgili problemler yaşanabilir. Aşk hayatı iyi gitmez.");
                break;

            case 27:
                sonucTxtValue.setText("Asılı Adam Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asilanadam.png").into(tarotKarti);
                kartAnlami.setText("Bu kart; vazgeçişi, daha iyiye ulaşmak için elindekini kurban etme anlamını taşır. Ruhsal açıdan kurban etme ise kendini ibadete adamayı gösterir. Bu inanç sistemi ve olaylara bakış açısı tamamen değişebilir. Mesela özel hayatı ve iş hayatı baştan aşağıya değişebilir. Kişi, bireysel ihtiyaçlarını öne alarak diğerlerine öncelik vermekten vazgeçebilir. Yalnız bu kart diğer olumsuz kartlarla birlikte görüldüğünde cezaevine girmek ya da herhangi bir konuda suçlanmak şeklinde yorumlanabilir.");
                break;

            case 28:
                sonucTxtValue.setText("Ters Asılı Adam Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asilanadam.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Ego, materyalizm ve bencilliği ifade eder. Bu kartı seçen kişi, bencilliği yüzünden kendisi dışındakileri düşünmez. Dar görüşlülük Tanrı’ya ulaşmayı engeller. Başka birinin yolundan gidilmesi imkanların gelişmesini önler.");
                break;

                case 29:
                sonucTxtValue.setText("Ay  Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/ay.png").into(tarotKarti);
                kartAnlami.setText("Ay kartı, kişinin kendinden ya da başkalarından kaynaklanan namussuzluğu temsil eder. Bu kartı seçen kişi, aldatılmış, kendine yalan söylüyor olabilir veya başkalarına karşı sahtekarca davranıyor olabilir. Ay, titreşimleri temsil ettiğinden ayrılığı, ani değişimleri ifade ediyor olabilir. Kartı seçen kişi, hayal kırıklığına uğrayabilir. Dikkatli olun, sizin bilmediğiniz çok şey etrafınızda yaşanıyor olabilir. Ayrıca ay kartı, telepati kartıdır. Bu kişinin sezgileri güçlüdür. Uyku ve rüya görmeyi de ifade ediyor olabilir. Telepatik aktiviteyi sembolize eder.");
                break;

            case 30:
                sonucTxtValue.setText("Ters Ay Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/ay.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Hilekarlık ve namussuzluk artık bitiyor, demektir. Dürüst, yalansız bir aşk ve alaka ortaya çıkar. Kendini kandırmak bu kartla yok olur. Bu kart, yaratıcılığın kartıdır. Telepatik aktiviteyi sembolize eder.\n" +
                        "\n");
                break;


            case 31:
                sonucTxtValue.setText("Aziz Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/aziz.png").into(tarotKarti);
                kartAnlami.setText("Bu kart, tutuculuğa, düzenli aile yaşamına ve gelenekselliğe işaret eder. Evlilikte ise birlik ve beraberliği simgeler. Baş Rahip, içten gelen sesin dinlenmesini ifade eder.");
                break;


            case 32:
                sonucTxtValue.setText("Ters Aziz Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/aziz.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Düzensizliği anlatır. Evlilikte problemleri simgeler. Bu kartı seçen kişi içinden gelen sese kulak vermez. İş durumu ise çok iyidir.");
                break;


            case 33:
                sonucTxtValue.setText("Azize Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/azize.png").into(tarotKarti);
                kartAnlami.setText("Aklınızdaki soruları temsil eder, gelecek kaygıları içerir. Koşullar değişkenlik gösterebilir. Sezgisel güçler kuvvetlidir. Bu kart, rastgele olacak değişimlere işaret eder. Bu kartı seçen kişi, içinden gelen sesi dinlemelidir. Burada kadın, hislerine dayanarak hareket eder, uyumludur ve mutludur.");
                break;


            case 34:
                sonucTxtValue.setText("Ters Azize Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/azize.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Değerler ve davranışlar arasındaki farklılık negatif değişimlere yol açar. Koşullar için ahlaki düzen hiçe sayılabilir.");
                break;

            case 35:
                sonucTxtValue.setText("Büyücü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/buyucu.png").into(tarotKarti);
                kartAnlami.setText("Hırsı, arzuyu temsil eder. Düşünce gücü önemlidir bunun yanında yetenek de kendini gösterir. Bu kartı seçen erkek, hırslı bir kişiliğe sahiptir. Kendine güveni yüksektir. Bu kartı seçen kadın da kendine güvenir ve karşısındaki erkek kendini ona adar. Bu kartı seçen kişi; moda veya serbest işle uğraşır.");
                break;

            case 36:
                sonucTxtValue.setText("Ters Büyücü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/buyucu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Yarım kalan işleri temsil eder. Kötü amaçlar için planlar gerçekleşir. Bu kartı seçen kişi, genellikle güvenilmez bir kişiliğe sahiptir.");
                break;

            case 37:
                sonucTxtValue.setText("Asaların Ası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinasi.png").into(tarotKarti);
                kartAnlami.setText("Asaların ası bir istek, girişim, enerji ya da cesaretin içinde yer aldığı bir başlangıçla karşılaşacağınızı ifade eder.");
                break;

            case 38:
                sonucTxtValue.setText("Ters Asasların Ası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinasi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Almayı düşündüğünüz riskler ya da herhangi bir durumla ilgili yepyeni hedefleriniz varsa, bazı sorunlarla karşılaşabilir veya bu kararları ertelemek zorunda kalabilirsiniz. Böyle bir dönemde bencil ve dikbaşlı davranmamak yararınıza olacaktır.\n" +
                        "\n");
                break;

            case 39:
                sonucTxtValue.setText("Asaların Kralı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinkirali.png").into(tarotKarti);
                kartAnlami.setText("Asaların Kralı, dürüsttür ve çok yaratıcıdır. Eğlence için tartışmalı ortamlar bile yaratır, insanlara sataşmaktan keyif alır. Rekabet ortamını sever. İnsanlara sıcak davranır, yardımcı olmayı sever. Fazla hırslıdır, başarıya ulaşmak için elinden geleni yapar. Başka kişinin boyunduruğu altına giremez, kendi kendinin patronu olmak ister. Neşelidir, macerayı sever, sürekli yenilik peşindedir, girişimcidir. Gezmeyi, eğlenceyi ve sporu çok sever. Siyasette ve iletişimde iyidir. Evini seven bir erkek ve iyi bir kocadır. Meslek hayatında başarılıdır ve ileri görüşlüdür.");
                break;

            case 40:
                sonucTxtValue.setText("Ters Asaların Kralı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinkirali.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Ters çevrili Asaların Kralı, cömertliğini ve arkadaş canlısı tarafını kaybeder. Paylaşımcı olmaktan çıkar ve bencilleşir. Her şey kendine ait olsun ister, kibirlidir. Her isteğinin anında yapılmasını bekler. Baskın bir kişiliktir, tartışmaktan çekinmez, sadece kendini düşünür.");
                break;

            case 41:
                sonucTxtValue.setText("Asaların Uşağı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinusagi.png").into(tarotKarti);
                kartAnlami.setText("Gayret, hırs, cesaret, enerji ve kişilik bu karta özgü unsurladır. Herkesin içinde fark edilmeyi ve doğal liderlik yeteneklerinizi sergilemeyi seviyorsunuz. Eğer ki, içinde bulunduğunuz yeni bir durum varsa bu konuda kararlı ve risk alır konumda olduğunuzu söylemek mümkün. Farklılığınızı öne çıkarmak için bu aralar antrenörlük, atletizm, satış ve öğretmenlik gibi konularda girişimlerde bulunabilirsiniz.");
                break;

            case 42:
                sonucTxtValue.setText("Ters Asaların Uşağı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinusagi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bazen ilgi görme ve sevilme ihtiyacından ötürü sizi rahatsız edecek davranışlarla karşılaşabilirsiniz. İçinizdeki fark edilme tutkusu sizi de yapmacık ve sevimsiz davranışlar sergilemeye itebilir, dikkatli olmalısınız. Aşk hayatınıza gelince, sürdürdüğünüz ilişki ya da duygular sizi mutsuz edebilir. Genel anlamda sizi pek de memnun etmeyecek haberlere hazırlıklı olmalısınız.");
                break;

            case 43:
                sonucTxtValue.setText("Asaların Şövalyesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinsovalyesi.png").into(tarotKarti);
                kartAnlami.setText("Eğer odağınız bir kişi değilse, bu kart size hayatınızda meydana gelecek çok önemli olayları haber vermektedir. Kartın vurguladığı karakter özellikleri ise açık sözlü, komik, insanları seven bir profildir.");
                break;
            case 44:
                sonucTxtValue.setText("Ters Asaların Şövalyesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asalarinsovalyesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Düşünmeden karar veren ve fevri bir özellik arz eden bu kart, size aşırı rekabetin ve bencilliğin yakın olduğunu haber verir. İş veya başka bir olayla ilgili problemlere sahip olabilirsiniz.\n" +
                        "\n");
                break;
            case 45:
                sonucTxtValue.setText("Denge Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/denge.png").into(tarotKarti);
                kartAnlami.setText("Tam bir sanat kartıdır. Sabit bir durumu ifade eder. Bu kartı seçen kişiden orta bir yol bulunması için uzlaşmacı bir tavır beklenir. Ana temel, orta yolu bulmaktır, dengeyi kurmaktır. Bu kart, doğru uyuma işaret eder. Bu kartı seçen kişi, zor bir ikilem yaşarsa inançlarını pratiğe dökmek zorunda kalabilir.");
                break;
            case 46:
                sonucTxtValue.setText("Ters Denge Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/denge.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu kartı seçen kişinin davranışları çok abartılıdır. Bu aşırılık, kimseyle uzlaşamama, orta yolu bulamama anlamına gelir. Bu kişi, çok sabırsızdır ve her laftan bir mana çıkarır. Dengenin sağlanması için uzlaşma yoluna gidin.");
                break;
            case 47:
                sonucTxtValue.setText("Dünya Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/duny.pnga").into(tarotKarti);
                kartAnlami.setText("Başarı, zafer ve rahat bir hayatı simgeler. Planların hayata geçirilmesi demektir. Bu kartı seçen kişi sorumluluk almayı bilir. Bu nedenle nasıl başarılı olacağını da öğrenir. Kendisine ve başkalarına saygı duyar. Kendinizi tanıma ve güzel ifade etme, maddi ve manevi mutluluğa ulaşmanızı sağlar. Bu kart, dünya seyahati anlamına da gelebilir.");
                break;
            case 48:
                sonucTxtValue.setText("Ters Dünya Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/dunya.png).rotate(180f").into(tarotKarti);
                kartAnlami.setText("Başarıya henüz ulaşılamamış, zafer daha tamamlanamamıştır. Ortada kısmi bir zafer vardır. Kartı seçen kişi, hayatın sorumluluklarını pek kabul etmez.");
                break;
            case 49:
                sonucTxtValue.setText("Ermiş Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/ermis.png").into(tarotKarti);
                kartAnlami.setText("Bu kart akıl verme anlamını taşır. Kartı seçen kişi, kendi kararlarını tek başına ve mantıklı bir şekilde veren biridir. Kendi fikirlerine ve kararlarına güvenir. Sadece güvenilir birinin size yol göstermesine izin verirsiniz.");
                break;
            case 50:
                sonucTxtValue.setText("Ters Ermiş Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/ermis.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu karttaki kişi kendi kararlarını kendisi verir ancak sonra pişmanlık duyar. Burada önemli olan iç sesinizi dinlemenizdir.");
                break;
            case 51:
                sonucTxtValue.setText("Güç Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/guc.png").into(tarotKarti);
                kartAnlami.setText("Ruhsal sevginin kullanımını simgeler. Güç, sevgi ve anlayıştan oluşur bu kart. Bu kartı seçen kişi kendini bilir, korku ve komplekslerinden arınır. Kibarca, sakin bir şekilde amacına ulaşır.");
                break;
            case 52:
                sonucTxtValue.setText("Ters Güç Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/guc.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu kart kendini sevme ve başkalarını düşünmeme anlamına gelir. Psikolojik problemlere işaret eder. Sinir ve şiddet, kontrolsüzlüğe yol açar. Bu kişi, her şeyi yanlış anlar, kavgacıdır bu yüzden çevresi ile ilişkisi iyi değildir.");
                break;
            case 53:
                sonucTxtValue.setText("Güneş Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/gunes.png").into(tarotKarti);
                kartAnlami.setText("Yeniden doğuş anlamını taşır. Bu kart, başarı ve mutluluğu getirir. Eğitimde, kariyer ve sanatsal alanda başarı sağlanacağı anlamına gelir. Aile ve aşk ele alındığında bir evlilik kartı olabilir. Sağlığın iyi olması demektir. Liderlik kavramı bu kartla bağdaştırılır. Sorunların üstesinden gelinir adeta yeniden doğulur. Bu yeniden doğuş fiziksel değişimle de kendini gösterir. Öz güven bu kartın simgesidir.");
                break;
            case 54:
                sonucTxtValue.setText("Ters Güneş Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/gunes.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Hayal kırıklığı, hüsranla sonuçlanmış olaylar ve tatminsizlik anlamını taşır. Bu olumsuz olayları olumluya çevirme yetisi yoktur. Yenilgiler bu kartı seçen kişiyi bezdirebilir. İlişki ve evlilikte sorunlar yaşanabilir.");
                break;
            case 55:
                sonucTxtValue.setText("İmparator Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/imparator.png").into(tarotKarti);
                kartAnlami.setText("Tüm planların gerçekleşeceğine işaret eder. Liderlik ve güç bu karttadır. Mantık ön plandadır. Bu kartı seçenin analiz yeteneği güçlüdür, sorumluluk sahibidir ve öz güveni yüksektir. İmparator, tam disiplinli bir babayı simgeler. Bu kişiler genelde yüksek makama gelecektir.");
                break;
            case 56:
                sonucTxtValue.setText("Ters İmparator Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/imparator.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("İmparatorun ters olması, planların alt üst olacağı anlamına gelir. Bu kart, otoritersizliği simgeler, kartı seçen çok hayalperesttir. Ayrıca bağımlılık problemleri bu kartta olasıdır.");
                break;
            case 57:
                sonucTxtValue.setText("İmparatoriçe Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/imparatorice.png").into(tarotKarti);
                kartAnlami.setText("Aşka işaret eder, evlilik kartı olabilir. Duygusallığa, aşka, sevgiye, sevilmeye dikkat çeker. Ayrıca bu kart, anneliği ifade eder. Bu kartı seçen kadın; duygusal, ruhsal, psikolojik, zihinsel ve ekonomik açıdan güçlerine önem verir. Dekorasyon ve yaratıcı işler kendini gösterir.");
                break;
            case 58:
                sonucTxtValue.setText("Ters İmparatoriçe Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/imparatorice.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu kartın ters olması sakinliğe işaret eder. Sevgi, mutluluk için şarttır. Psikolojik problemler olduğunu ifade eder. Mutsuz bir kadını simgeler. Bu kartı seçen kişi ilişkilerde ve anne olmakta kendini başarısız hissedebilir. Boşanma ve ihanet ortaya çıkabilir.");
                break;
            case 59:
                sonucTxtValue.setText("Joker Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/joker.png").into(tarotKarti);
                kartAnlami.setText("Bu kart önemli tercihler doğurur, yaşama büyük değişiklikler getirir. Burada, anahtar kelime fırsattır. Farklı bir çevre sizi bekliyor olacaktır. Bu kart, yeni başlangıçlara, fırsatlara işaret eder. Bu kartı seçen kişi, aşk konusunda hayatının fırsatını yakalayabilir.");
                break;
            case 60:
                sonucTxtValue.setText("Ters Joker Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/joker.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Deli kartı ters olduğunda, şanssızlığa işaret eder. Endişelere, aptallığa ve bencilliğe yol açar. Diğer insanlar bu kartı seçen kişinin fikirlerini değiştirebilir. Ne istediğinizi tekrar gözden geçirmelisiniz. Yaptığınız hatalardan pişmanlık duyar ve utanabilirsiniz.");
                break;
            case 61:
                sonucTxtValue.setText("Kader Çarkı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kadercarki.png").into(tarotKarti);
                kartAnlami.setText("Ödüllere ve fırsatlara işarettir. Bu kartı seçen kişi olayları kendi lehine çevirebilir. Bu kart, başarıyı simgeler. Pek çok fırsat doğacak anlamına gelir.");
                break;
            case 62:
                sonucTxtValue.setText("Ters Kader Çarkı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kadercarki.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Ertelemeler ve problemler meydana gelir. Bu kartı seçen kişi, çok çalışır ama bir ilerleme kaydedemez. Bir hatayı tekrarlamak olasıdır. Fırsatlar iyi değerlendirilemez.");
                break;

            case 63:
                sonucTxtValue.setText("Kılıçların Uşağı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinusagi.png").into(tarotKarti);
                kartAnlami.setText("Bu kartın odağı uyum, çeviklik ve esnekliktir. Bu nedenle matematik, teknoloji, yabancı dil ve mühendislik gibi konularda kariyer edinme olasılığınız yüksek denebilir. Aynı anda iki işe birden sahip olma özelliğini de taşıyan bu kart, zihinsel meşguliyet ve oyunlardan hoşlandığınızı da ortaya koyar. Bu özellikler başladığınız bir projeden çabuk sıkılma ve yeni arayışlar içine girme sinyallerini de verir.");
                break;
            case 64:
                sonucTxtValue.setText("Ters Kılıçların Uşağı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinusagi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Sadece zeka ürünü şeylere inanma ve her şeyi sorgulayıp zaman zaman iğneleyici, şüpheci ve alaycı bir kimliğe bürünmeyi ifade eden bu kart, üzücü ve beklenmedik olayların da habercisidir.\n" +
                        "\n");
                break;

            case 65:
                sonucTxtValue.setText("Kılıçların Altılısı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinaltilisi.png").into(tarotKarti);
                kartAnlami.setText("Yaşadığınız korkunç ve hatta küçük düşürücü olaylardan sonra artık yeniden durumunuzu dengeleme zamanı gelmiştir. Bu dengeyi kurmanın tek yolu ise tüm bu yaşananlardan hızla uzaklaşmaktır. Kartınız size daha olumlu gelişmelerin haberini de vermektedir. Tüm zorlukları geride bırakıp ilerleyeceğiniz bir gelişmedir bu. Taşınma gibi fiziksel değişimler de bu dönemde karşınıza çıkar. Güçlüklerle savaşma dönemi geride kalmıştır.");
                break;
            case 66:
                sonucTxtValue.setText("Ters Kılıçların Altılısı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinaltilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Yolculuk, bir yerden başka bir yere taşınma gibi olayların yaşanmayacağını bildiren bu kart, zorluklarla mücadelenin devam ettiği bir süreci anlatır. İçinde bulunduğunuz durumun bir süre daha devam edeceği söylenebilir.");
                break;

            case 67:
                sonucTxtValue.setText("Kılıçların Ası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asilanadam.png").into(tarotKarti);
                kartAnlami.setText("Gücü temsil eden bu kart, kendinizi her zamankinden daha güçlü hissedeceğiniz bir döneme işaret eder. Kartta görülen dağlar bazı engelleri ifade etse de krallığın sembolizmi, bu sorunların çözülmeye başladığını ya da çözüleceğini ifade eder. Sorun her neyse zihin gücüyle zafere ulaşmanız mümkündür, üstelik komplike kurgulara ihtiyaç duymadan. Aksine bu süreçte gayet dürüst ve ilkeli bir dengede sorunları barışçıl bir şekilde çözmeniz mümkün.");
                break;
            case 68:
                sonucTxtValue.setText("Ters Kılıçların Ası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/asilanadam.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Size pek pozitif etkiler sunmayan bu kart, içinden çıkmakta zorlandığınız sorunlarla çevrelendiğinizin veya ciddi bir baskı altında olduğunuzun göstergesidir. Ancak burada tüm bu baskı ve sorunları yaratanın kişinin“kendiniz” olabileceğini de düşünmeniz gerekir.");
                break;

            case 69:
                sonucTxtValue.setText("Kılıçların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinasi.png").into(tarotKarti);
                kartAnlami.setText("Gücü temsil eden bu kart, kendinizi her zamankinden daha güçlü hissedeceğiniz bir döneme işaret eder. Kartta görülen dağlar bazı engelleri ifade etse de krallığın sembolizmi, bu sorunların çözülmeye başladığını ya da çözüleceğini ifade eder. Sorun her neyse zihin gücüyle zafere ulaşmanız mümkündür, üstelik komplike kurgulara ihtiyaç duymadan. Aksine bu süreçte gayet dürüst ve ilkeli bir dengede sorunları barışçıl bir şekilde çözmeniz mümkün.");
                break;
            case 70:
                sonucTxtValue.setText("Ters Kılıçların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinasi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Size pek pozitif etkiler sunmayan bu kart, içinden çıkmakta zorlandığınız sorunlarla çevrelendiğinizin veya ciddi bir baskı altında olduğunuzun göstergesidir. Ancak burada tüm bu baskı ve sorunları yaratanın kişinin“kendiniz” olabileceğini de düşünmeniz gerekir.");
                break;

            case 71:
                sonucTxtValue.setText("Kılıçların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinbeslisi.png").into(tarotKarti);
                kartAnlami.setText("Etrafınızdaki birini incitebilirsiniz. Birini incittiğinizde aslında kendinizi inciteceğinizi aklınızda bulundurmalısınız. Kartın ifade ettiği bir diğer anlam ise elde etmeyi istediğiniz şeylere ulaşma ve bunu yaparken biraz hile kullanabilme durumunuzun olmasıdır. Bu kurnazca tutum bir başkasının sizi yönlendirmesiyle de olabilir.");
                break;
            case 72:
                sonucTxtValue.setText("Ters Kılıçların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinbeslisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Başarısızlığın ve kaybedişlerin ifadesi olan bu kart, sizi içinde bulunduğunuz ilişki ya da olaylarda ya zarar veren ya da zarar gören kişi konumuna getirebilir. Yaşadıkça bunların şiddetini göreceksiniz.\n" +
                        "\n");
                break;

            case 73:
                sonucTxtValue.setText("Kılıçların Dokuzlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarindokuzlusu.png").into(tarotKarti);
                kartAnlami.setText("Psikolojiniz ile ilgili sıkıntılar baş gösterebilir; bunalım, paranoya gibi. Bu sorunların kaynaklandığı kişi sevgiliniz ya da size ruhsal anlamda zarar verebilecek kadar sizi etkisi altında bulunduran biri olabilir. Karşılaşacağınız tehdit ve suçlamalara hazır olmalısınız. Bu durumlara göstereceğiniz zayıflık, sizi kendinizden utanma ve nefret etme gibi duygulara sürükleyebilir.");
                break;
            case 74:
                sonucTxtValue.setText("Ters Kılıçların Dokuzlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarindokuzlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Yeni açılımlar, ümit edilen hedefler içinde bulunduğunuzdan durumdan kurtulmanızı sağlayacaktır. Halihazırdaki probleminizin kısa sürede çözümleneceğini ve bunun için biraz sabırlı ve inançlı olmanız gerektiğini unutmamalısınız.");
                break;

            case 75:
                sonucTxtValue.setText("Kılıçların Dörtlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarindortlusu.png").into(tarotKarti);
                kartAnlami.setText("Hayatınızda atılıma geçmeyi düşündüğünüz herhangi bir şey için biraz dinlenmeye ve zamana ihtiyacınız olacaktır. Bir yandan da bunun geçici bir dönem olduğunu unutmamalısınız. Bir geri çekilmeyi ifade eden bu kart, çevreden soyutlanmayı bile beraberinde getirebilir.");
                break;
            case 76:
                sonucTxtValue.setText("Ters Kılıçların Dörtlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarindortlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu kart tekrarlanan davranış ya da olayları da anlatır ve bu tekrarlananlar genellikle sıkıntı yaratan unsurlardır. Ama bu bulunduğunuz noktadan çok da ileri gitmenizi gerektirmez. Bu olaylar geçmişinizden gelen bir aşk, iş ya da sağlıkla ilişkili olabilir.");
                break;

            case 77:
                sonucTxtValue.setText("Kılıçların İkilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinikilisi.png").into(tarotKarti);
                kartAnlami.setText("Duyguların yoğunluğu göze çarpmaktadır. Duygularınıza sırtınızı döndüğünüz, olan biteni tam anlamıyla göremediğiniz bu dönemde, içinde bulunduğunuz durumun netleşmesini beklediğiniz söylenebilir. Hareketten ziyade durgunluğun hakim bu süreçte bir dengeye ihtiyaç duyabilirsiniz. Dolayısıyla gerçeklikler ve duygularla yüz yüze gelmekten kaçınmaktasınız. Alacağınız kararları bir şekilde erteleme meyili görülmektedir. Ancak bu durum alınacak kesin bir kararla sona erecektir.");
                break;
            case 78:
                sonucTxtValue.setText("Ters Kılıçların İkilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinikilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Yaşadığınız veya yaşayacağınız olaylar sizi net bir karar götürecektir. Kararın yararlı olup olmayacağını ise zaman gösterecektir.");
                 break;

            case 79:
                sonucTxtValue.setText("Kılıçların Kralı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinkrali.png").into(tarotKarti);
                kartAnlami.setText("Kılıçların Kralı, tam bir şampiyondur. Yaşadığı tüm zorlukların üstesinden gelir. Kararlarını, tecrübesine dayanarak sağlıklı bir şekilde verir. Dürüsttür, tarafsızdır. Genellikle eğitimci, doktor veya avukat olurlar. Olayları filozofik açıdan ele alır. Sevecen ve şefkatlidir.");
                break;
            case 80:
                sonucTxtValue.setText("Ters Kılıçların Kralı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinkrali.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Ters çevrili Kılıçların Kralı, ön yargılıdır. Kincidir, intikam peşinde koşar. Parlak zekasını kötülükler için kullanır; komplo kurar, entrikalar çevirir. Acımasız, alaycı ve şüphecidir.");
                break;

            case 81:
                sonucTxtValue.setText("Kılıçların Kraliçesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinkralicesi.png").into(tarotKarti);
                kartAnlami.setText("Kendine hakim olma özelliğini vurgulayan bu kart, evli ya da herhangi bir beraberliği olanı ilişkisinde kendine fazla güvenen bir profille sunar. Kalbinden çok aklı onu yönetir. Keskin ve eleştirici, çözümleyici ve kavrayışı güçlü olabilir. Doğruluk, serbestlik, eşitlik ve eğitim en temel amaçları ifade eder. Gazetecilikten teknolojiye kadar birçok iletişim mecrası bu tip kişilerin ilgi alanıdır.");
                break;
            case 82:
                sonucTxtValue.setText("Ters Kılıçların Kraliçesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinkralicesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Kötü haberleri ve dedikoduları ifade eder. Aynı zamanda geçmişte yaşanılanlardan kurtulamamanın da anlatıcısıdır. Mutsuzlukla dolu geçmişi inatla bugüne taşıma sürdürülmektedir. Bu durum kişiyi kurnazlığa ve kötü düşüncelere sevk edebilir. Fikirleri tek taraflı ve güvenilmez olabilir. Ön yargılardan ve öz güvenden yana daha güçlü adımlar atılmalıdır.\n" +
                        "\n");
                break;

            case 83:
                sonucTxtValue.setText("Kılıçların Onlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinonlusu.png").into(tarotKarti);
                kartAnlami.setText("Umulmadık bir olumsuzluk ya da yürümeyen planlar görülebilir. Başarısızlıklar sizin geçmişte temelini attığınız bir durumdan kaynaklanabildiği gibi sizin dışınızdaki bir nedenden de kaynaklanabilir.");
                break;
            case 84:
                sonucTxtValue.setText("Ters Kılıçların Onlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinonlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Zor bir durumdan ya da sorunlarınızdan kurtulmak amacıyla fikirler ve davranışlarınızda gerçekleştirdiğiniz değişiklikler, sizi olumlu bir seviyeye doğru götürmektedir. Kendinizde yaptığınız değişiklikler yanında çevrenizden aldığınız yardımlar da bunda etkili olmuş olabilir. Tüm yaşananlara rağmen umut ışığı hala yanmaktadır.");
                break;

            case 85:
                sonucTxtValue.setText("Kılıçların Sekizlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinsekizlisi.png").into(tarotKarti);
                kartAnlami.setText("Kendi ihtiyaç ve düşüncelerinizi ikinci plana attığınız ve başkalarının sizi yönlendirmesine izin verdiğiniz bir dönemdesiniz. Daha önce kararlılıkla hareket ettiğiniz tutumunuz artık yerini kararsızlığa bırakmıştır. Bu durum sizin önceki tutumlarınızda çok fazla hırslı olmanızdan da ileri gelebilir. Dolayısıyla seçim yapmaktan korktuğunuz bir durumda olduğunuz bile söylenebilir. Düşünsel anlamda huzura ulaşmanız biraz zaman alacaktır.");
                break;
            case 86:
                sonucTxtValue.setText("Ters Kılıçların Sekizlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinsekizlisi").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Uzun süredir zihninizi meşgul eden düşünceler ve kararsızlık durumu artık netliğe kavuşacak ve sizi özgürleştirecektir. Korkularınızı geride bıraktığınız ve fikren bağımsızlığa kavuştuğunuz bir dönem başlamıştır.");
                break;
            case 87:
                sonucTxtValue.setText("Kılıçların Şövalyesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinsovalyesi.png").into(tarotKarti);
                kartAnlami.setText("Hiç beklemediğiniz olaylara hazır olun. Saldırgan, alaycı ve ukala tavırlar hakim olabilir. İş alanlarınız hukuk, mühendislik, ekonomi ve teknoloji gibi heyecan verici alanlar olabilir.");
                break;
            case 88:
                sonucTxtValue.setText("Ters Kılıçların Şövalyesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinsovalyesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Çok büyük yanlış anlama ve ön yargılı tavırların habercisi olan bu kart, bencillik ve sertliği ön plana çıkarır. Dolayısıyla hatalı kararlar ve devamında gelecek kinci ve kaba tavırlar beklenebilir. Bunlara ek olarak, bu kart bir ani bitiş ya da olumsuz gelişmeyi de ifade eder.");
                break;

            case 89:
                sonucTxtValue.setText("Kılıçların Üçlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinuclusu.png").into(tarotKarti);
                kartAnlami.setText("Dramatik sahnelerin habercisi olan bu kart, hayatta bazen karşılaşmak zorunda olduğumuz talihsiz durumların her ne kadar atlatılabileceğini bilse de sıkıntılı günlere karşı uyarır. Şu anda hayatınızda bulunan bir durum sizden uzaklaşmaktadır. Şöyle düşünmek gerekir ki; size faydası olmayan bir şey ya da kişi kaybedilmelidir zaten.");
                break;
            case 90:
                sonucTxtValue.setText("Ters Kılıçların Üçlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinuclusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Hissettirdiği acı daha az olan bir ayrılık sizi bekliyor. Her ne kadar sıkıntılı bir dönem olsa da hislerinizin daha az incineceğini bilmelisiniz. Bahsi geçen daha önce ayrılık yaşanan bir ilişkinin yeniden ayrılığa gitmesi olabilir. İlişkiler dışında da mesela bir sağlık operasyonu sizi bekliyorsa, bunda da çekeceğiniz sıkıntının boyutları daha dar olacak demektir.");
                break;

            case 91:
                sonucTxtValue.setText("Kılıçların Yedilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinyedilisi.png").into(tarotKarti);
                kartAnlami.setText("Her ne kadar farkında olmasanız da kendi kendinizin en büyük düşmanı haline geldiğiniz bir döneme doğru giriyorsunuz. Bu dönem, ruhun ihtiyaçları üzerinde kazanılan zihinsel oyunlar ve güçlüklerle sonuçlanacaktır. Yakın geçmişinizdeki sorunların tekrarlanması olasıdır. Kendine ihanet etme durumu bu kartın en belirgin mesajıdır. Bu yüzden alacağınız kararlarda çok dikkatli olmalısınız. Kendinize zarar vermemek için içinde bulunduğunuz durumlara ve etrafınızdakilere karşı biraz daha dikkatli olmalısınız.");
                break;
            case 92:
                sonucTxtValue.setText("Ters Kılıçların Yedilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kiliclarinyedilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Yapacağınız olumlu ve yardımsever seçimler, aynı zamanda kendiniz için yapacağınız iyilikler olacaktır. Kendinizin en iyi arkadaşı olacağınız bir dönemdesiniz.");
                break;

            case 93:
                sonucTxtValue.setText("Kule Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kule.png").into(tarotKarti);
                kartAnlami.setText("Bu kartı seçen kişi eğer bir şeyin karşısında değilse bu kart güçlüklere işaret eder. Bu kartı seçen kişi için dürüstlüğü simgeler. Yoldan çıkarıcı eğilimler olacak ama doğru yol bulunacaktır. Kişisel bilgiyi arzuluyorsanız bu kart olumlu bir kart olabilir. Sağlık açısından hastalığa işaret edebilir. Yıkımlar daha çok iş, aile, ev ve psikolojik açıdan olabilir.");
                break;
            case 94:
                sonucTxtValue.setText("Ters Kule Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kule.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Beklenen bir değişikliği simgeler. Bu kart ters çevrildiğinde de yıkıma işaret eder. Gerçekler, doğrular bu kartı seçen kişi için pozitif durumları doğurur. Bu kartı seçen kişi yıkımı önceden bilir ve hazırlıksız yakalanmaz. Bencilliğinden kurtulmuştur.");
                break;
            case 95:
                sonucTxtValue.setText("Kupaların Kralı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinkrali.png").into(tarotKarti);
                kartAnlami.setText("Kupaların Kralı, hayatın anlamını bilir, zekidir. Samimi bir kişiliği vardır. Kart üzerinde dalgalar halinde akan su, yaptıklarının ne kadar anlamlı olduğunu ve duygusal yönünü simgeler. Hukuk, tıp ve danışmanlık ilgi alanlarıdır. Ayrıca sanatla ilgilenir, yaratıcıdır. Psikolojiye meraklıdır. Duygusal enerjisi yüksektir, inançlıdır, maneviyata önem verir. Hayal gücü kuvvetlidir. Sorumluluk sahibidir, ilk bakışta sessiz görünür ama zamanla samimiyeti ortaya çıkar.");
                break;
            case 96:
                sonucTxtValue.setText("Ters Kupaların Kralı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinkrali.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Ters çevrili Kupaların Kralı, duygusal açıdan zayıftır, hassastır. Kendi kendine yalan söyler. Alkol ve uyuşturucuya yatkındır. Sözüne pek güvenilmez. Zaaflarına yenik düşer ve başarısızdır.");
                break;
            case 97:
                sonucTxtValue.setText("Kupaların Uşağı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinusagi.png").into(tarotKarti);
                kartAnlami.setText("Duygular dünyasında huzur ve mutluluk veren, cezbeden ve karşılık bulacağınız günler sizi bekliyor. Bu kart kibarlık, sempati, sanat yeteneği, hasiyet, hayal gücü, sevme ve önsezinin sizinle olduğunu ifade eder. Özellikle sanatla ilgili atacağınız adımlarda disiplini elden bırakmamanız gerekiyor.");
                break;
            case 98:
                sonucTxtValue.setText("Ters Kupaların Uşağı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinusagi").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Genellikle gerçeklerden kaçmayı ve kendini hayal dünyasına kapatmayı tercih edenlerin kartıdır. Kurulan ilişkilerde ya da dahil olunan işlerde çekimser kalan ve güvensizlik hissini duyanları anlatır. Dolayısıyla sahip olduğu yetenekleri doğru kullanamazlar.");
                break;
            case 99:
                sonucTxtValue.setText("Kupaların Altılısı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinaltilisi.png").into(tarotKarti);
                kartAnlami.setText("Çocukluğunuza dair mutlu anılar, geçmişten gelen hayalleriniz ve mutlu bir araya gelişler bu kartın vazgeçilmez mesajlarıdır. Duygusal ve ailevi konular çok güzel bir uyum içine girmektedir. Evinize alacağınız yeni eşyalar olabilir veya evinizde vereceğiniz eğlenceli toplantılar bu dönemde yaşanabilir. Özel gün kutlamaları da bu dönemin içindedir.");
                break;
            case 100:
                sonucTxtValue.setText("Ters Kupaların Altılısı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinaltilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Sizi hüzünlendiren ve canınızı sıkan eski olaylardan kurtulma zamanı. Artık değişmek ve anın tadını çıkarmak için ideal bir dönemde olduğunuzu fark etmelisiniz. Çünkü bulunduğunuz durum sizi eskiye saplanmış birine dönüştürmüştür. Bundan kurtulmak için gerek arkadaşlarınız gerekse sevgilinizden bile uzaklaşmanız gerekebilir.\n" +
                        "\n");
                break;
            case 101:
                sonucTxtValue.setText("Kupaların Ası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinasi.png").into(tarotKarti);
                kartAnlami.setText("Duygusal konuların başlangıcı olan Kupaların Ası, size yeni bir aşk ya da sevginin haberini getirir. Kendini anlamaya odaklı bu karttaki su imgesi, duyguların dışa yansımasını ve akışını anlatır.");
                break;
            case 102:
                sonucTxtValue.setText("Ters Kupaların Ası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinasi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Kendi duygularınızla hareket edemeyeceğinizin ya da duygusal ilişkilerinizde bencilliğe yöneleceğinizin habercisi olan bu kart, sizi dikkatli olmaya davet eder. Karşısındakinin hisleriyle oynayan, sevgide koşul arayan, ya da karşısındakini umarsızca reddeden bir davranış biçimine yönelebilirsiniz.\n" +
                        "\n");
                break;
            case 103:
                sonucTxtValue.setText("Kupaların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinbeslisi.png").into(tarotKarti);
                kartAnlami.setText("Bir konunun bitmesine ilişkin aldığınız kararların ve bu kararın getirdiği kayıpların habercisi olan bu kart, bitişlerin biraz can sıkıcı ve kırıcı olması yönünde sizi uyarmaktadır. Yaşayacağınız bu kayıpların üzerinde fazla durmamalı ve umutsuzluğa kapılmamalısınız. Hala elinizde bulunan değerlere odaklanmanız daha doğru olacaktır. Bazen bu kayıpların daha sonra kazanca dönüşebileceğini hatırlatan kart, aynı zamanda büyük değişimlerin de sözcüsüdür.");
                break;
            case 104:
                sonucTxtValue.setText("Ters Kupaların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinbeslisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Geçmişinizdeki bir kişinin geri dönüşü ile karşılaşabilirsiniz. Yeni ümitlere gebe olduğunuzu unutmayın. Bu geri dönüşler olumlu etkiler barındırmaktadır. Kayıplardan arındığınız ve yepyeni umutlarla dolu olduğunuz bir dönemdesiniz.");
                break;
            case 105:
                sonucTxtValue.setText("Kupaların Dokuzlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarindokuzlusu.png").into(tarotKarti);
                kartAnlami.setText("Hayatın eğlenceli yüzüyle yeniden buluştuğunuzu müjdeleyen bu kart, size bol para ve sağlık getirmektedir. Yaşamdan keyif almak için tüm şartlar tamamlanmıştır.");
                break;
            case 106:
                sonucTxtValue.setText("Ters Kupaların Dokuzlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarindokuzlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("İstediğiniz her neyse bu konuda hayal kırıklığı yaşayabilirsiniz.");
                break;
            case 107:
                sonucTxtValue.setText("Kupaların Dörtlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarindortlusu").into(tarotKarti);
                kartAnlami.setText("Artık dünyevi olaylardan uzaklaştığınız, duygusal anlamda da çaba harcamaktan yorulduğunuz bir dönemdesiniz. Dolayısıyla yeni ortam ve durumlara kapalı olduğunuzu ifade eden bu kart, kabuğunuza çekileceğiniz bir dönemin yaklaştığını söyler. İşin iyi yanı, bu dönemin işinizi hatta yaşam tarzınızı yeniden gözden geçirmeye müsait olduğudur.");
                break;
            case 108:
                sonucTxtValue.setText("Ters Kupaların Dörtlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarindortlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bir süredir içinde bulunduğunuz bir içe kapanma halinden çıkacağınız günler yaklaşıyor. Yeniliklere hazır olduğunuz bir dönemdesiniz; yeni insanlarla tanışma ya da yeni işlere yelken açma gibi. Her tür ilişkide yeni açılımlar sizi bekliyor.\n" +
                        "\n");
                break;
            case 109:
                sonucTxtValue.setText("Kupaların İkilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinikilisi.png").into(tarotKarti);
                kartAnlami.setText("Mantık ve duyguyu dengeleyen bu kart, dostluk, aşk ya da herhangi bir ilişkideki paylaşımın önem ve dengesini ifade eder. Yani maddiyatla dengelenmiş bir aşk ya da dostluk gibi bir dengeden bahsedilir. Ayrıca semboller çift arasındaki çekimi de anlatmaktadır.");
                break;
            case 110:
                sonucTxtValue.setText("Ters Kupaların İkilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinikilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Sizi tartışmaların ve bazı uyumsuzlukların beklediğine işaret eden bu kart, özellikle ilişkilerinizde dikkatli olmanız gerektiğini öngörür. Örneğin; çok yoğun duygular yaşadığınız aşk ilişkiniz giderek monotonlaşıp yok olmaya yüz tutabilir ve kötü bir şekilde bitebilir. Daha önce dengede olan duygu ve davranışlar, yerini bencilliğe ve empati eksikliğine bırakabilir. Ciddi ayrılıklar yaşanabilir çünkü ilişki dengesini yitirmiştir. Siz ilişkiniz içinde sürekli veren taraf olabilirsiniz ya da bu durum karşınızdaki için de geçerli olabilir.");
                break;
            case 111:
                sonucTxtValue.setText("Kupaların Onlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinonlusu.png").into(tarotKarti);
                kartAnlami.setText("Aile, uyum ve gerçek sevginin yoğunluğu söz konusudur. İçinde bulunduğunuz durum olumluluğunu korumaya devam edecektir. İlişkilerde sürekliliği sağlamak adına evlilik ya da ortaklıklar gibi durumlar ortaya çıkabilir.");
                break;
            case 112:
                sonucTxtValue.setText("Ters Kuaların Onlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinonlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Sürekliliği olmayan ilişkiler, elindeki bir şeyi bitiremem hali, mutsuzluk ve tartışmalar görülür. Varsa bir ilişki biter veya devam edilen bir iş sonlanabilir.");
                break;
            case 113:
                sonucTxtValue.setText("Kupaların Sekizlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinsekizlisi.png").into(tarotKarti);
                kartAnlami.setText("Hayatınızda bazı vazgeçişler ortaya çıkabilir. Yeni bir anlam ve amacın peşine düşebilirsiniz. Duygusal ve ailevi konular geride kalmaya başlamıştır ve ilişkileriniz zayıflayıp kopma noktasına dahi gelebilir. Toplum hayatı ile ters düşerek kendiniz için yeni bir araştırmaya başlamayı tercih edebilirsiniz.");
                break;
            case 114:
                sonucTxtValue.setText("Ters Kupaların Sekizlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinsekizlisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("İçinde bulunduğunuz dönem hayatın cömertliğinden hoşnut olma, aile, arkadaşlar, ilişkiler, sosyal çevreler ve partilerin yoğun olduğu bir durumu içeriyor. Yeni bir ilişki, bahsi geçen bu cömertliğin bir parçası olabilir. Yaşayacağınız tüm iletişimler ve yenilikler size hoşnutluk getirecektir.");
                break;
            case 115:
                sonucTxtValue.setText("Tılsımların Sekizlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinsekizlisi.png").into(tarotKarti);
                kartAnlami.setText("Herhangi bir konuda eğitime hazır olduğunuz söylenebilir. Kendinizi keşfetme, bir iş ya da meslek için eğitilme, bu kartta var olan ihtimallerden bazılarıdır. Bu bir şey üzerinde çalışma şeklinde de olabilir. Daha iyi koşullarda çalışma ya da daha fazla para kazanma için kararlı olduğunuzun habercisi olan bu kart, etkinliği yüksek kişilerle tanışacağınızı da müjdeler. Şimdiden kuracağınız tüm ilişkiler ileride size parasal olarak da katlanarak geri dönecektir.");
                break;
            case 116:
                sonucTxtValue.setText("Ters Tılsımların Sekizlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinsekizlisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Kendi içinizde sahip olduğunuz yetenek ve hırsa rağmen amaçladığınız şeylere ulaşmakta büyük sıkıntılar sizi bekliyor. Şimdiye kadar sarıldığınız bazı değerleri geride bırakabilirsiniz ama yeteneklerinizi asla! Yeteneklerinizle ilgili yanlış tercihler yapabilirsiniz. Bu yanlış tercihler içinde hiç de ahlaki olmayan hamleler olabilir. İşinizde usulsüzlük, zimmete haksız kazanç aktarımı gibi uç noktalar bile olabilir. Atacağınız adımlarda uzun uzun düşünmeli ve çirkin atfedilen davranışlardan uzak durmalısınız.");
                break;
            case 117:
                sonucTxtValue.setText("Yıldız Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/yildiz.png").into(tarotKarti);
                kartAnlami.setText("Yıldız kartı, kartı seçen kişinin arzularını ve düşlerini ifade eder. Güven ile doğal yetenekleri aramayı gösterir. Olumlu, pozitif düşünce, iyi ruh ve fiziksel sağlığı simgeler. Meditasyon, bu kart ile sembolize edilir. Bu kartı seçen kişiyi, yeni yetenekler bulması, yaratıcı hedeflere ulaşması için destekleyin.");
                break;
            case 118:
                sonucTxtValue.setText("Ters Yıldız Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/yildiz.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Hayal kırıklıklarıyla sonuçlanmış umutlardır. İyimserlik yok olmuştur, bu olumsuzluk kartı seçen kişinin silik kişisel imajından kaynaklanıyor olabilir. Bu kişi, güçleri, yaratıcılığı değersiz saydığı için kendisini yetersiz hissedebilir. Böylece tüm yaratıcılığı kaybolur. Depresyon ve güvensizlik duygusu kişiyi zayıflatır, güçsüzleştirir. Ümitsizlik duygusu hayallerini yıkar. Bu olumsuzluklara karşı yardım alın, kişisel bir çare arayın.");
                break;
            case 119:
                sonucTxtValue.setText("Kupaların Şövalyesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinsovalyesi.png").into(tarotKarti);
                kartAnlami.setText("Heyecan ve önseziyi içinde barındıran bir kişiliği ifade eden bu kart, hassasiyeti ve sanat eğilimini de ifade eder. Aklınızdan geçen olay romantizm ve duygusallık kuşağındadır denebilir.");
                break;
            case 120:
                sonucTxtValue.setText("Ters Kupaların Şövalyesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinsovalyesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Sevgi, sanat ve hassasiyet geride kalmıştır. Duygusal gerçeklerden veya sırtlanmak istemediğiniz sorumluluklardan kaçışı ifade eden bu kart, sizi yapabileceğiniz aldatmalar ve yalandan ötürü uyarmaktadır. Sevgi, sanat ve hassasiyet geride kalmıştır. Duygusal gerçeklerden veya sırtlanmak istemediğiniz sorumluluklardan kaçışı ifade eden bu kart, sizi yapabileceğiniz aldatmalar ve yalandan ötürü uyarmaktadır.");
                break;
            case 121:
                sonucTxtValue.setText("Kupaların Üçlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinuclusu.png").into(tarotKarti);
                kartAnlami.setText("Gelişen ve hızla ilerleyen bir ilişkinin habercisi olan bu kart, mutlu sonuçlar doğuracak ya da uzun vadeli ve ciddi bir ilişkinin temellerinin atılacağı bir dönemi ifade eder. Hayatınızda olan biriyle gelişen bir ilişki beklentisi ile hayatınızda biri yoksa doğru adayın çıkacağını söylemek mümkündür. Hatta evlilik, nişan ya da söz gibi planların yapılacağı bir süreç başlamaktadır. Diğer yandan başarı ile sonuçlanmış bir mezuniyet, kariyerde yükseliş, doğum, önemli bir gününü yıldönümü ya da bir iş sahibi olma gibi gelişmeler de bu kartın verdiği haberler içindedir. Dolayısıyla sahip olduğunuz yeteneklerin en olumlu yanlarıyla tanışmanızdan söz edilebilir.");
                break;
            case 122:
                sonucTxtValue.setText("Ters Kupaların Üçlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinuclusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Mutluluğa ulaşmayan bir sona hazır olmalısınız. İyi gittiğini düşündüğünüz ilişkiniz bile karşınızdakinin tavırları yüzünden kesintiye uğrayacaktır. Sizi bekleyen diğer aksaklıklar ise alkol, uyuşturucu, seks, beslenme vb. gibi alışkanlıklara fazlaca ağırlık vererek sağlık sorunları yaşamanız olabilir. Romantizmin bozulmaya yüz tuttuğu bu dönemde, kart sizi evlilik gibi konuları konuşmadan önce düşünmeye ve dikkatli olmaya davet eder. Bu süreçte doğal yeteneklerinizin de farkında olmanız gerekecektir.\n" +
                        "\n");
                break;
            case 123:
                sonucTxtValue.setText("Kupaların Yedilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinyedilisi.png").into(tarotKarti);
                kartAnlami.setText("Sizi tetikleyen ve motive eden şeylerin etkisinden uzak hatta onların ne olduğunu bile bilmediğiniz bir dönemdesiniz. Gerçekte var olmayan sadece hayal ürünü olan şeyleri de ifade eden bu kart, bu hayaller için fazla zaman harcadığınızı da bildirmektedir. Tüm bunlara sizi dış dünyadan koparan aşırı alkol tüketimi ya da bilgisayar ve televizyon gibi unsurlar neden olabilir.");
                break;
            case 124:
                sonucTxtValue.setText("Ters Kupaların Yedilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinyedilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Kararsızlığın karşıtı olan bu kart, yeni belirlediğiniz hedef ve risklerden birini kesin olarak seçip onun peşinden gideceğinizi haber verir.");
                break;

            case 125:
                sonucTxtValue.setText("Kupaların Kraliçesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinkralicesi.png").into(tarotKarti);
                kartAnlami.setText("Çok hassas, sezgisi güçlü, karşısındaki fazlasıyla önemseyen bir profil çizen özellikler bu kartın odak noktasıdır. Dolayısıyla duyguların çevrelediği bu özellikler duygusal çalkantılara zemin hazırlamaktadır.");
                break;
            case 126:
                sonucTxtValue.setText("Ters Kupaların Kraliçesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/kupalarinkralicesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Aşırı hassasiyetiniz çevredekiler için dayanılmaz bir hal alabilir. Bu duygusal zayıflık hayatı da yaşanması zor ve kırgınlıklarla dolu hale getirmektedir. Hayali olaylar, kendi içine dönük kurgular ve sağlıklı olmayana alışkanlıklara sarılma gibi durumlar sıkça görülür. Geçmişteki kötü deneyimleri unutabilecek kadar güçlü görünülmez. Dolayısıyla yaşadığınız her neyse kalbinizden önce mantığınızı dinlemeli ve duygusal çalkantılardan kurtulmalısınız.\n" +
                        "\n");
                break;
            case 127:
                sonucTxtValue.setText("Uyanış Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/uyanis.png").into(tarotKarti);
                kartAnlami.setText("Kişisel güçlerin daha çok farkına varılması ve kullanılması anlamına gelir. Bu kartı seçen kişi artık korkularından ve problemlerinden kurtulmuştur. Kendi gücünü ve enerjisini kullanarak mutluluğa kavuşur. Bu kartın ödülleri; ruh, akıl ve kalp arasındaki uyumdur. Kurtulma, bu kartı simgeler. Bu kartı seçen kişi, birinden kurtulmuş olabilir. Bu kurtuluş her alanda olabilir. Bu kişi, önemli konularda kendi iç sesini dinlemeli ve başkalarına aldırış etmemelidir.");
                break;
            case 128:
                sonucTxtValue.setText("Ters Uyanış Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/uyanis.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Kurtuluşu reddetme anlamını taşır. Hayatındaki problemlerden sıyrılamamayı ifade eder. Kendi kontrolünüz yoktur. Yaşanacak değişikliklerle ilgili kişi, iç sesine kulak veremez.");
                break;

            case 129:
                sonucTxtValue.setText("Ölüm Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/olum.png").into(tarotKarti);
                kartAnlami.setText("Güzel, yeni başlangıçları ifade eder. Bu kart, değişiklik getiren bir açılım için çok iyi bir karttır. Yeni bir hayat ve farklı bir yaşam tarzı başlar. Eski olaylar bu kartı seçen kişiyi artık üzmez, duygusallığından kurtulmuştur. Üzüntüler arkada bırakılır, artık mutlu, sevgi dolu günler başlar.");
                break;
            case 130:
                sonucTxtValue.setText("Ters Ölüm Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/olum.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Hareketsizliği temsil eder. Bu kartı seçen kişi sürekli çıkmazdadır. Sürekli bir problem yaşar.");
                break;
            case 131:
                sonucTxtValue.setText("Şeytan Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/seytan.png").into(tarotKarti);
                kartAnlami.setText("Korku kartıdır. Bir karar verileceği zaman korkular, hatalara yol açar. Bu kart, yüzeysellik, materyalizm ve dış görünüşü simgeler. Bu kartı seçen kişi, para konusunda iyi bir işe sahip olabilir ve dış görünüşü bunda etkilidir. Bu kart, şatafat, güvence ve para için kurulan evlilikleri gösterir. Kendi çıkarı ve para için insanları kullanır.");
                break;
            case 132:
                sonucTxtValue.setText("Ters Şeytan Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/seytan.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Olumsuz düşüncelerden, korkulardan ve materyalizmden kurtulmak anlamına gelir. Bencilliğin üstesinden gelinir. Hırs konusunda büyük dersler alınır. Çıkarcı davranışlardan kaçınır.\n" +
                        "\n");
                break;

            case 133:
                sonucTxtValue.setText("Tılsımların Uşağı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinusagi.png").into(tarotKarti);
                kartAnlami.setText("Sabır ve diğerlerinin görüşlerine saygı, bu kartın ifade ettiği özelliklerdir. Her şeyden ders alınabileceğini söyleyen bu kart, öğretici yapıdaki mesajlarla doludur. Açık fikirlilik tüm bu öğretileri doğru bir şekilde almayı sağlayacaktır.");
                break;
            case 134:
                sonucTxtValue.setText("Ters Tılsımların Uşağı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinusagi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Kendine acıma, isyankarlık ve dikkatsizlik gibi unsurların yoğun olarak görüldüğü bu dönem sizi negatif tutumlarınızdan ötürü bilgisizliğe ve öğreti yoksunluğuna götürebilir. Bunun dışında otorite veya aileye karşı direnişi de ifade eden bu kart, öğretilerden kaçma eğiliminizi vurgular.");
                break;
            case 135:
                sonucTxtValue.setText("Tılsımların Altısı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinaltilisi.png").into(tarotKarti);
                kartAnlami.setText("Size sıkıntı yaratan olayların bitmesi ve parasal anlamda yaşayacağınız bir ferahlamanın dengesi göze çarpıyor. Bu dönemde yapılacak yatırımlar, katlanarak geri dönecektir. Yatırımı sadece iş anlamında düşünmemek gerekir. Bir kişiye hatta eğitim alan birine yapılacak yardım da olabilir bu. Dolayısıyla sadece parasal anlamda bir kar değil, manevi anlamda da iç huzur sağlayacak karlılık da söz konusudur.");
                break;
            case 136:
                sonucTxtValue.setText("Ters Tılsımların Altısı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinaltilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Hak ettiğinize inandığınız davranış ya da maddi şeyleri almanız pek mümkün olmayacaktır. Parasal anlamda haksız dağılımlar ve zorluklarla dolu çeşitli mücadeleler sizi bekliyor. Vasiyet, ortaklık, alım satım veya prim gibi parasal mevzular bu duruma dahildir.");
                break;

            case 137:
                sonucTxtValue.setText("Tılsımların Ası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinasi.png").into(tarotKarti);
                kartAnlami.setText("Somut olayların habercisi olan tılsımların ası, sabreden ve bilgi biriktirenlerin mükafatına ulaşacağını ifade eder. Hayatınızdaki herhangi bir başlangıç ki bunlar; iş, mülkiyet, bir şeye sahip olma ya da satın alma olabilir, gerçekliği olan sonuçlara işaret eder.");
                break;
            case 138:
                sonucTxtValue.setText("Ters Tılsımların Ası Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinasi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu kart bazı kayıpların sözcüdür. Yani aklınızdaki başlamış ya da başlayacak olayların gerçekleşememesi durumu söz konusu olabilir. Bunun dışında iş ya da parasal konularda sizi memnun etmeyecek durumlar yaşanabilir.");
                break;
            case 139:
                sonucTxtValue.setText("Tılsımların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinbeslisi.png").into(tarotKarti);
                kartAnlami.setText("Fiziksel ya da ruhsal açıdan sorunların yaşanması, bazı kayıpların ortaya çıkması beklenen olumsuz gelişmelerdir. Bunların bencilliğin bir cezası olarak yorumlanması da muhtemeldir. Parasal konularda ise gelir düşüklüğünün bir göstergesi olan bu kart, aşk hayatında da yalnızlığın habercisidir. Önceden güvendiğiniz şeylere olan inancınızı da kaybedebilirsiniz.   ");
                break;
            case 140:
                sonucTxtValue.setText("Ters Tılsımların Beşlisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinbeslisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Neşenizde artış gözlemleyebilirsiniz. İş hayatında part-time ya da geçici süreliğine bir iş bulabilirsiniz. Sağlık durumunuz iyiliğini koruyacak ya da olduğundan daha iyi duruma gelecektir. Ruhsal dünyada büyük yenilikler bekleniyor.");
                break;

            case 141:
                sonucTxtValue.setText("Tılsımların Dokuzlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarindokuzlusu.png").into(tarotKarti);
                kartAnlami.setText("Parasal kazanç, güven artışı, kararlılık, kendine güven ve bağımsızlık hakimdir. Hayatın güzel şeylerinden yalnız başına zevk alma, bahçe ve ev sevgisi de bu kartın sunduğu haberlerdendir.");
                break;
            case 142:
                sonucTxtValue.setText("Ters Tılsımların Dokuzlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarindokuzlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu dönemde bazı kaybedişler yaşayabilirsiniz. Mantıksız davranışlar sergilemeye eğilimli olabilirsiniz. Bu yüzden dikkatli olmalı ve mantığınızı hep yanınızda bulundurmalısınız.");
                break;
            case 143:
                sonucTxtValue.setText("Tılsımların Dörtlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarindortlusu.png").into(tarotKarti);
                kartAnlami.setText("Kararlılığınızın ve ekonomik gücünüzün göstergesi olan bu kart, paranın güçle eşdeğer olduğunu aktarır. Parayı elinizde tutmanızın olumlu etkilerini yaşayabilirsiniz. Diğer yandan ilişkilerde sahiplenmeyi ifade eden kartınız, genel olarak bencil ve kapalı tutuma karşı bireysel kontrol ve öz güveni temsil etmektedir.");
                break;
            case 144:
                sonucTxtValue.setText("Ters Tılsımların Dörtlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarindortlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Güçlü olduğunuzu hissettiğiniz bir ilişki ya da durumdaki dengelerin değişeceği, gücünüzün azalacağı bir dönem sizi bekliyor. Siz her ne kadar kontrol altında tutsanız da gücünüzün azaldığını hissedebilirsiniz. Savurganlık yüzünden paranızın azaldığı, iş ve finans konusunda sıkıntılar yaşadığınız bir döneme hazırlıklı olmalısınız. Ağırlıklı olarak güçsüzlüğü hissedeceğiniz bir dönem başlıyor.\n" +
                        "\n");
                break;

            case 145:
                sonucTxtValue.setText("Tılsımların İkilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinikilisi.png").into(tarotKarti);
                kartAnlami.setText("Hayattaki değişikliklerin sonsuz olduğunu ifade eden bu kart, yaşamınız süresince karşılaşacağınız tüm değişimlerin normal olduğunu ve bu tip dalgalanmalar hazırlıklı olmanız gerektiğini hatırlatır. Yaşadığınız olaylar sizi atlattığınızı düşündüğünüz noktalara geri döndürebilir. Genellikle sizin elinizde olmayan bu akışın hayatınıza bir anlam ve hareket kattığını düşünmelisiniz. Günlük yaşamda farklı sorumluluklar, parayı değerlendirme ya da halihazırda var olan iş ya da bir değeri riske atarak yeni başlangıçlara yol alma da bu değişimlerin içindedir. Dolayısıyla alacağınız tutum esnek olmalıdır çünkü hayat iniş ve çıkışları içinde barındırır.");
                break;
            case 146:
                sonucTxtValue.setText("Ters Tılsımların İkilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinikilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Hayatınızda gerçekleşmeye başlamış ya da başlayacak değişimlere ayak uydurmakta zorlanabileceğinize işaret eden bu kart, sizi para ve diğer konularda karar alırken uyarır. Yanlış yönlendirmeler yaşayabilirsiniz. Örneğin; ilişkilerinizde haksız denebilecek tavırlarda bulunabilir, paranızı yanlış değerlendirebilir veya verdiğiniz sözlerden dönebilirsiniz. Karşılaşacağınız durum değişikliklerinde uyum sorunu yaşamanız ve cesur tavırlar sergileyememeniz beklenebilir.");
                break;
            case 147:
                sonucTxtValue.setText("Tılsımların Kralı Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinkrali.png").into(tarotKarti);
                kartAnlami.setText("Tılsımların Kralı, azimlidir, çok çalışkandır. Maddi açıdan durumu iyidir. Kazanmayı ve harcamayı iyi bilir. Doğayı ve toprağı sever. Gözüyle görmediği şeylere inanmaz, şüpheyle yaklaşır. Tutucudur, geleneklerine bağlıdır. Çevresinden bağlılık ve saygı görmek ister. Sevgisini para harcayarak gösterir.");
                break;
            case 148:
                sonucTxtValue.setText("Ters Tılsımların Kralı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinkrali.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Ters çevrili Tılsımların Kralı, inatçılığı temsil eder. Materyalisttir. Para için her şeyi yapabilir, servet düşkünüdür. İnatçıdır, çevresini yorar. Geleneklerine bağlılığı onu bağnaz bir kişi haline getirir.");
                break;

            case 149:
                sonucTxtValue.setText("Tılsımların Onlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinonlusu.png").into(tarotKarti);
                kartAnlami.setText("Bu kart sağlam ve iyi koşulların habercisidir. Aklınızdan geçen fikirlerde kararlılık ve güven hakimdir. Bu kart aynı zamanda hayatınızın bir aşamasından diğerine geçişi de ifade eder. Bu ilişki durumunda bekarlıktan evliliğe, işsizlikten iş sahibi olmaya gibi birçok konuda olabilir.");
                break;
            case 150:
                sonucTxtValue.setText("Ters Tılsımların Onlusu Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinonlusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Parasal konularda sıkıntıya düşebilir hatta kariyer ve aile gibi konularda da bu sıkıntıyı yaşayabilirsiniz. Bazı işleriniz yarıda kalabilir, devletle alakalı işlerde huzursuzluk olabilir. Bu dönemde finansal hareketlerden ve risklerden olabildiğince kaçınmalıdır.");
                break;

            case 151:
                sonucTxtValue.setText("Tılsımların Şövalyesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinsovalyesi.png").into(tarotKarti);
                kartAnlami.setText("Projelerinize yapılacak maddi ya da manevi yardımlarla paylaşıma gidebilirsiniz. Para ve sağduyuyu ifade eden bu kart, güvenilirlik, kararlılık ve dürüstlüğü anlatır. Hayatınızda temel ve rutin mutlulukları istemeniz, para ve herhangi bir şeye sahip olma eğiliminizle örtüşür. Çok konuşkan olmamayı anlatan bu kart, tercih edilen işleri endüstri sektörü, makineler, fabrikalar ve matematik bilgisi isteyen alanlarla ifade etmiştir.");
                break;
            case 152:
                sonucTxtValue.setText("Ters Tılsımların Şövalyesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinsovalyesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Bu kart konu para olunca hilekarlığı ve çıkarcılığı ifade eder. Buna binaen iş bulamama, parasal hasarlar ve kendi güvenliğinden yoksunluk gibi durumlar yaşanabilir.");
                break;

            case 153:
                sonucTxtValue.setText("Tılsımların Üçlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinuclusu.png").into(tarotKarti);
                kartAnlami.setText("Tılsımların Üçlüsü, iş, yetenek, eğitim ve parasal konulardaki gelişmeyi gösterir. Bu kartta, yetenekleri ile çalışan usta bir zanaatkarı görürüz. Bir caminin iç kısmındaki işçiliği, hayattaki bir olayı başarmayı, beceriyi gösterir. Bu kart aynı zamanda, terfi, tanınma, ün, derece ve sertifika gibi seçilen bir alanda başarabilme gücünü ifade eder.");
                break;
            case 154:
                sonucTxtValue.setText("Ters Tilsimlarin Üçlüsü Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinuclusu.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("İsteksiz girişimleri ve ortalama ya da ortalamanın altında bir işçiliği gösterir. Genellikle, az çaba ya da çok iş, durumu tatbik edilir. Danışan umulan beceri ve yeteneklerden çok, sadece uygun olanı üstlenir.");
                break;
            case 155:
                sonucTxtValue.setText("Tılsımların Yedilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinyedilisi.png").into(tarotKarti);
                kartAnlami.setText("Başarısızlık ve tatminsizlik duygusu hakim olabilir bu dönemde. Çok fazla önem verilen bir şey, hissettiğiniz bir memnuniyet duygusu veya bir başarıyı kaybetme olasılığınız var. İçinizden bir his sizi kariyer, eğitim, maddi ve manevi amaçlarla ilgili daha ileri hedeflere doğru itiyor olabilir.");
                break;
            case 156:
                sonucTxtValue.setText("Ters Tılsımların Yedilisi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinyedilisi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Parasal sıkıntıların, kaygı ve şüphelerin ve borç ödemeleri gibi yoğun olarak yaşanmaya başladığı ya da yaşanacağı bir dönemdesiniz. Tüm bunları sürekli olarak düşünmek sizi olmak istemediğiniz duruma hapsetmektedir. Çabalarınızın sonuç almaması sizi bunaltabilir. Sağlık sorunlarına karşı da dikkatli olunmalıdır.\n" +
                        "\n");
                break;
            case 157:
                sonucTxtValue.setText("Tılsımların Kraliçesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinkralicesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Koruyuculuk, tecrübe ve ihtiyatlılığı ifade eden bu kart, kişinin kendi yarattığı sağlamlığa daha fazla güvendiğini söyler. Finansal özgürlük söz konusu olduğunda, oldukça sabırlı ve metin olmayı anlatır. Meslek hayatında başarı, lükse olan ilgi, güzel bir ortam, sevdiği kişi ya da şeye karşı sahiplik duygusu yine kartın olmazsa olmaz unsurlarıdır.");
                break;

            case 158:
                sonucTxtValue.setText("Ters Tılsımların Kraliçesi Kartı");
                Picasso.get().load("https://www.etcmobileapps.com/tarot/tilsimlarinkralicesi.png").rotate(180f).into(tarotKarti);
                kartAnlami.setText("Güvenilmezlik ve kendinden emin olmama durumu ön plana çıkar. Özgürlük açısından yaşanılan fakirlik parasal konularda da kendini gösterir. Kendi sorunlarından başkalarını sorumlu tutma eğimlimi de yine bu kartın anlamlarındandır. Üzgün ve zayıf iradeli görüntü, bu döneme ve kişiye hakim unsurlardır.");
                break;


            default:
                break;
        }

}




}

