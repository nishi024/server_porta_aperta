package it.fi.meucci;

import java.io.*;
import java.net.*;

class serverThread extends Thread {
    ServerSocket server = null;
    Socket client = null;
    String stringRicevuta = null;
    String stringModifica = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    public serverThread (Socket socket){
        this.client=socket;
    }

    public void comuica() throws Exception {

        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());

        for (;;) {
            stringRicevuta = inDalClient.readLine();
            if (stringRicevuta == null || stringRicevuta.equals("fine")) {
                outVersoClient.writeBytes(stringRicevuta + "" + '\n');
                System.out.println("server in chiusura" + '\n');
                break;
            } else {
                outVersoClient.writeBytes(stringRicevuta + "ricevuta" + '\n');
                System.out.println("" + stringRicevuta);

            }
        }
    }
}