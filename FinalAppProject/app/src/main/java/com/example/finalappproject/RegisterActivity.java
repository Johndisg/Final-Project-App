package com.example.finalappproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtNombre, edtCorreo, edtPassword, edtFechaNacimiento;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtNombre = findViewById(R.id.edtNombre);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtPassword = findViewById(R.id.edtPassword);
        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento);
        sharedPreferences = getSharedPreferences("userPrefs", MODE_PRIVATE);

        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {
        String nombre = edtNombre.getText().toString();
        String correo = edtCorreo.getText().toString();
        String password = edtPassword.getText().toString();
        String fechaNacimiento = edtFechaNacimiento.getText().toString();

        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(correo) || TextUtils.isEmpty(password) || TextUtils.isEmpty(fechaNacimiento)) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(correo, password);
        editor.apply();

        Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
        finish();
    }
}

