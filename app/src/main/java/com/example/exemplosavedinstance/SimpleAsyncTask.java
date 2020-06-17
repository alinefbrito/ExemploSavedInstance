package com.example.exemplosavedinstance;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    // The TextView where we will show results
    private WeakReference<TextView> msg_texto;

    // Construto faz referencia a TextView da Main Activity
    SimpleAsyncTask(TextView tv) {
        msg_texto = new WeakReference<>(tv);

    }


    @Override
    protected String doInBackground(Void... voids) {
        // gera um número aleatório entre a e 10.

        Random r = new Random();

        int n = r.nextInt(11);


        // faz com que a tarefa dure tempo suficiente para rotacionar o telefone

        int s = n * 200;


        // pausa a thread pelo tempo definido

        try {

            Thread.sleep(s);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }


        //retorna o resultado

        return "Retomado após pausa de  " + s + " milliseconds!";

    }

    protected void onPostExecute(String result) {

        msg_texto.get().setText(result);

    }
}
