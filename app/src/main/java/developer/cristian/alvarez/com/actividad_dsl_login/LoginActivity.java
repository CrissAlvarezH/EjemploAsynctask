package developer.cristian.alvarez.com.actividad_dsl_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario, edtContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = findViewById(R.id.edt_usuario);
        edtContrasena = findViewById(R.id.edt_contrasena);
    }

    public void clickIngresar( View view ) {

        String usuario = edtUsuario.getText().toString();
        String contrasena = edtContrasena.getText().toString();

        if ( !usuario.isEmpty() && !contrasena.isEmpty() ) {

            if ( usuario.equals("userdsl") && contrasena.equals("123456") ) {

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Los datos son incorrectos", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_SHORT).show();
        }

    }
}
