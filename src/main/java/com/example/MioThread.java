package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.IOException;

public class MioThread extends Thread {
    Socket s = new Socket();

    public MioThread(Socket s) {
        this.s = s;

    
    }

   
    public void run() {
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String stringaRicevuta = "";
        while (true) {
            stringaRicevuta = in.readLine();
            if (stringaRicevuta.equals("!"))
                break;
            System.out.println("La stringa ricevuta: " + stringaRicevuta);

            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaMaiuscola + "\n");
        }

        s.close();
    }
}
