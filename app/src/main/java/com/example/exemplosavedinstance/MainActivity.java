package com.example.exemplosavedinstance;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String VALOR_TEXTO = "com.example.exemplodavedinstance";
    private TextView msg_texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg_texto = (TextView) findViewById(R.id.txtMsg);
        // Recupera a textview, redundante com o método onRestoreInstanceState para exemplificar

        if (savedInstanceState != null) {

            msg_texto.setText(savedInstanceState.getString(VALOR_TEXTO));

        }
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstance) {
        super.onSaveInstanceState(saveInstance);
        saveInstance.putString(VALOR_TEXTO, msg_texto.getText().toString());
        /*
            savedInstanceState.putBoolean(ChaveBoolean, true);
            savedInstanceState.putDouble(ChaveDouble, 1.9);
            savedInstanceState.putInt(ChaveInt, 1);
         */
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstance) {
        super.onRestoreInstanceState(savedInstance);
        String valorRecuperado = savedInstance.getString(VALOR_TEXTO);
        msg_texto.setText(valorRecuperado);
    }

    public void startTask(View view) {

        // Adiciona msg a textview

        msg_texto.setText(R.string.napping);


        // Start the AsyncTask.

        // The AsyncTask has a callback that will update the text view.

        new SimpleAsyncTask(msg_texto).execute();

    }
}