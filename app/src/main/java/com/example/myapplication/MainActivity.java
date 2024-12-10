package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;

import android.text.TextWatcher;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText etEmail = findViewById(R.id.edit_text_email);
        EditText etPassword = findViewById(R.id.edit_text_password);
        Button btnLogin = findViewById(R.id.button_Login);
        btnLogin.setEnabled(false);

        View rootView = findViewById(android.R.id.content);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etEmail.getText().length() > 0 && etPassword.getText().length() > 0){
                    btnLogin.setEnabled(true);
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.brown));

                } else {
                    btnLogin.setEnabled(false);
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.gray));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        etEmail.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

              if (email.equals("admin") && password.equals("admin")) {
                  Snackbar.make(rootView, "Вы зарегестрировались", Snackbar.LENGTH_LONG).show();
                  TextView tvBtn = findViewById(R.id.tv_btn);
                  TextView fgPassword = findViewById(R.id.tw_fg_password);
                  TextView twRegistration = findViewById(R.id.tw_registration);
                  TextView twSignIn = findViewById(R.id.tw_sign_in);
                  TextView twLgn = findViewById(R.id.tw_lgn);
                  LinearLayout layout = findViewById(R.id.layout);

                  tvBtn.setVisibility(View.GONE);
                  fgPassword.setVisibility(View.GONE);
                  twRegistration.setVisibility(View.GONE);
                  twSignIn.setVisibility(View.GONE);
                  twLgn.setVisibility(View.GONE);
                  layout.setVisibility(View.GONE);

              }else {
                  Snackbar.make(rootView, "Неправильный логин или пароль", Snackbar.LENGTH_LONG).show();
              }
            }
        });
    }

}