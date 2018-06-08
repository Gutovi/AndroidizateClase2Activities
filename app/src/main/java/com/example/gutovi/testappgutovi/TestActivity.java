package com.example.gutovi.testappgutovi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    boolean surveyOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.btn_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TestActivity.this, TestLogin.class );
                startActivity ( intent );
            }
        });
        findViewById(R.id.btn_sendmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (Intent.ACTION_SEND );
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"gutovi@outlook.com.ar","juu.oviedo@gmail.com","gutovi.kun@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mail Prueba");
                intent.putExtra(Intent.EXTRA_TEXT, "Este es un mail de prueba enviado desde "+ getResources().getString(R.string.app_name));
                Intent mailappchooser = Intent.createChooser(intent, "¿Con qué enviar este e-mail?");
                startActivity(mailappchooser);
            }
        });


        findViewById(R.id.btn_survey).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surveyOn = !surveyOn;
                findViewById(R.id.rdg_Survey).setVisibility (View.VISIBLE);
            }
        });
    }
}
