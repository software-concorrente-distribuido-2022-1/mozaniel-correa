package com.software_concorrente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Queries query = new Queries();
       ControlaAcesso m = new ControlaAcesso(query);
       for(int i =0;i<200;i++){
        User user = new User(m);
        user.start();
       }
    }
}
