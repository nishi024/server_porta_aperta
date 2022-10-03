package it.fi.meucci;

public class serverMain {
    public static void run(String args[]) throws Exception {
        serverThread servente = new serverThread(null);
        servente.run();
    }
}