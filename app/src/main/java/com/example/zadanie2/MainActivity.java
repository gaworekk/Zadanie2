package com.example.zadanie2;

import android.os.Bundle;


import android.util.Patterns;
import android.widget.EditText;
import  android.widget.Toast;
import android.widget.Button;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private  Button buttonSumbit;
    private EditText editTextPassword;
    private EditText editTextPasswordComfirm;
    private EditText editTextSurname;
    private EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordComfirm = findViewById(R.id.editTextPasswordComfirm);
        buttonSumbit = findViewById(R.id.buttonSumbit);
        buttonSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String haslo = editTextPassword.getText().toString().trim();
                String potwierdzenie = editTextPasswordComfirm.getText().toString().trim();
                String nazw = editTextSurname.getText().toString().trim() ;
                String tel = editTextPhone.getText().toString().trim();
                if (name.isEmpty()){
                    Toast.makeText(MainActivity.this,"Proszę wprowadzić imię",Toast.LENGTH_SHORT).show();

                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Proszę wprowadzić adres e-mail",Toast.LENGTH_SHORT).show();

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this,"Niepoprawny adres e-mail",Toast.LENGTH_SHORT).show();

                } else if (!haslo.equals(potwierdzenie)) {
                    Toast.makeText(MainActivity.this,"hasła nie są takie same",Toast.LENGTH_SHORT).show();

                } else if (haslo.isEmpty()) {
                    Toast.makeText(MainActivity.this,"proszę wprowadzić hasło",Toast.LENGTH_SHORT).show();

                } else if (haslo.length()<6) {
                    Toast.makeText(MainActivity.this,"Hasło jest za krótkie",Toast.LENGTH_SHORT).show();

                } else if (nazw.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Proszę podać nazwisko",Toast.LENGTH_SHORT).show();

                } else if (tel.length()<9) {
                    Toast.makeText(MainActivity.this,"Numer telefonu nie jest poprawny",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this,"Formularz przesłany poprawnie",Toast.LENGTH_SHORT).show();
                }

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}