package com.semih.kaytolsayfasyapm;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.semih.kaytolsayfasyapm.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTxtAd, editTxtSoyad, editTxtEmail, editTxtPassword;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private RadioButton radioBtnE, radioBtnK;

    private String editAd, editSoyad, editEmail, editPassword;
    private String checkTest1, checkTest2, checkTest3;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        //EditTextler//
        editTxtAd = (EditText) findViewById(R.id.editTxtAd);
        editTxtSoyad = (EditText) findViewById(R.id.editTxtSoyad);
        editTxtEmail = (EditText) findViewById(R.id.editTxtSehir);
        editTxtPassword = (EditText) findViewById(R.id.editTxtYas);

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
        editEmail = editTxtEmail.getText().toString();
        editPassword = editTxtPassword.getText().toString();

        if (!TextUtils.isEmpty(editAd) && !TextUtils.isEmpty(editSoyad) && !TextUtils.isEmpty(editEmail) && !TextUtils.isEmpty(editPassword)) {
            System.out.println("Adınız : " + editAd);
            System.out.println("Soyadınız : " + editSoyad);
            System.out.println("Şehriniz : " + editEmail);
            System.out.println("Yaşınız : " + editPassword);

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

            mAuth.createUserWithEmailAndPassword(editEmail, editPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                //updateUI(user);
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(MainActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });

        }else
            System.out.println("Lütfen Bütün Bilgileri Doldurun");

//        System.out.println("Lütfen Bütün Bilgileri Doldurun");
    }
}