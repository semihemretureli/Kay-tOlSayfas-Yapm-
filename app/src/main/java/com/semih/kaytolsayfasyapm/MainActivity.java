package com.semih.kaytolsayfasyapm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText editTxtAd, editTxtSoyad, editTxtSehir, editTxtYas;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private RadioButton radioBtnE, radioBtnK;

    private String editAd, editSoyad, editSehir, editYas;
    private String checkTest1, checkTest2, checkTest3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditTextler//
        editTxtAd = (EditText) findViewById(R.id.editTxtAd);
        editTxtSoyad = (EditText) findViewById(R.id.editTxtSoyad);
        editTxtSehir = (EditText) findViewById(R.id.editTxtSehir);
        editTxtYas = (EditText) findViewById(R.id.editTxtYas);

        //CheckBoxlar//
        checkBox1 = (CheckBox) findViewById(R.id.checkBoxHobi1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBoxHobi2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBoxHobi3);

        //RadioButtonlar//
        radioBtnE = (RadioButton) findViewById(R.id.radioBtnE);
        radioBtnK = (RadioButton) findViewById(R.id.radioBtnK);
    }

    public void btnKayıtOl(View v) {
        editAd = editTxtAd.getText().toString();
        editSoyad = editTxtSoyad.getText().toString();
        editSehir = editTxtSehir.getText().toString();
        editYas = editTxtYas.getText().toString();

        if (!TextUtils.isEmpty(editAd) && !TextUtils.isEmpty(editSoyad) && !TextUtils.isEmpty(editSehir) && !TextUtils.isEmpty(editYas)) {
            System.out.println("Adınız : " + editAd);
            System.out.println("Soyadınız : " + editSoyad);
            System.out.println("Şehriniz : " + editSehir);
            System.out.println("Yaşınız : " + editYas);

            System.out.println("----Hobileriniz----");
            if (checkBox1.isChecked())
                System.out.println(checkBox1.getText().toString());
            if (checkBox2.isChecked())
                System.out.println(checkBox2.getText().toString());
            if (checkBox3.isChecked())
                System.out.println(checkBox3.getText().toString());

            if (radioBtnE.isChecked())
                System.out.println("Cinsiyetiniz : " + radioBtnE.getText().toString());
            else
                System.out.println("Cinsiyetiniz : " + radioBtnK.getText().toString());

        }else
            System.out.println("Lütfen Bütün Bilgileri Doldurun");

//        System.out.println("Lütfen Bütün Bilgileri Doldurun");
    }
}