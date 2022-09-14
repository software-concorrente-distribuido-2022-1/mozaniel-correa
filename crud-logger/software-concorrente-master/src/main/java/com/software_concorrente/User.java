package com.software_concorrente;

public class User extends Thread{
    private ControlaAcesso monitor;
    public User(ControlaAcesso m) {
        this.monitor = m;
    }
    @Override
    public void run(){
       monitor.request();
       monitor.usaRecurso();
       monitor.release();
    }
}
