package developer.cristian.alvarez.com.actividad_dsl_login;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int SUMA = 1;
    private final int RESTA = 2;
    private final int DIVICION = 3;
    private final int MULTIPLICACION = 4;

    private EditText edtNum1, edtNum2;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = findViewById(R.id.edt_numero_1);
        edtNum2 = findViewById(R.id.edt_numero_2);
        radioGroup = findViewById(R.id.radiogroup);

    }

    public void clickRegresar(View view) {
        finish();
    }

    public void clickRealizarOperacion(View view) {

        int num1 = Integer.parseInt( edtNum1.getText().toString() );
        int num2 = Integer.parseInt( edtNum2.getText().toString() );

        new RealizarOperacionTask().execute( getOperacionSeleccionada(), num1, num2);
    }

    private class RealizarOperacionTask extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... integers) {
            int numero1 = integers[1];
            int numero2 = integers[2];

            switch ( integers[0] ) {
                case SUMA:

                    return "El resultado de la suma es " + (numero1 + numero2);
                case RESTA:

                    return "El resultado de la resta es " + ( numero1 - numero2 );
                case DIVICION:

                    if ( numero2 != 0 ) {
                        float res = ( (float) numero1 / (float) numero2 );

                        Log.v("Actividad", ""+res);

                        return "El resultado de la divición es " + redodearDosCifras(res);
                    } else {
                        return "El divisor no puede ser cero";
                    }

                case MULTIPLICACION:

                    return "El resultado de la multiplicación es " + ( numero1 * numero2 );
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }

        private float redodearDosCifras(float num) {

            return ( Math.round( num * 100 ) / 100f );
        }
    }

    private int getOperacionSeleccionada() {

        switch ( radioGroup.getCheckedRadioButtonId() ) {
            case R.id.radio_suma:
                return SUMA;
            case R.id.radio_division:
                return DIVICION;
            case R.id.radio_multiplicacion:
                return MULTIPLICACION;
            case R.id.radio_resta:
                return RESTA;
        }

        return -1;
    }


}
