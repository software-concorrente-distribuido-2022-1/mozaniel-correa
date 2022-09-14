package com.software_concorrente;

public class ControlaAcesso {
    private boolean ocupado = false;//controla se request foi feito
    private Queries recurso; // recurso do monitor
    //** Construtor
    public ControlaAcesso(Queries r){
        recurso = r;
    }
    //** Método para liberar o recurso
    public synchronized void release() {
    ocupado = false;
    notifyAll();
    }
    //** Método para requisitar o recurso
    public synchronized void request(){
    while (ocupado) {
    try {
    wait();
    } catch (InterruptedException e) { }
    }
    ocupado = true;
    }
        public void usaRecurso() {
            String[] teste = recurso.signIn();
            String idUser = recurso.login(teste);
            recurso.createConta(idUser);
            int saldo = recurso.updateSaldo(idUser);
            recurso.createMovimentacao(idUser,4,saldo);
            recurso.selectAll(idUser);
            recurso.deleteMovimentacao(idUser);
        }
    }
