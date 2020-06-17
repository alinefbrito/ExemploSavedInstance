package com.example.exemplosavedinstance;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    // referencia fraca para a text view que será atualizada
    private WeakReference<TextView> msg_texto;
    // Construtor faz a referencia a TextView da Main Activity

    SimpleAsyncTask(TextView tv) {
        msg_texto = new WeakReference<>(tv);
    }

    //metodo que executa as ações em segundo plano
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
