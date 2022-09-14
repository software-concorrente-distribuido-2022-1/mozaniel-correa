package com.software_concorrente;

import java.nio.charset.Charset;
import java.sql.*;
import java.util.Random;
public class Queries {
    public String[] signIn(){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            Random rand = new Random();
            Random rand2 = new Random();
            String name = String.valueOf(Math.abs(rand2.nextInt()));
            int id = Math.abs(rand.nextInt());
            String[] response = new String[]{String.valueOf(id),name,"D"};
             statement.execute(
                "insert into login(id,login,password) values('"+ id+"','"+name+"','D')"
            );
            statement.close();
            connection.close();
            String message = "User de id"+id+"Criado";
            this.saveLog(String.valueOf(id), message);
            return response;
        }catch(Exception exception){
            System.out.println(exception);
            return new String[]{"error"};
        }
    }
    public String login(String[]info){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            String id = info[0];
            String password = info[2];
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from login where id = '"+ id+"' and password = '"+ password+"'");
                while (resultSet.next()) {
                    int idUser = resultSet.getInt("id");
                    String name = resultSet.getString("login");
                        System.out.println("Id : " + id
                        + "idUser : " + idUser
                        + "name : " + name
                );
            }
            String message = "User de id"+id+"Logado";
            this.saveLog(id, message);
                    resultSet.close();
                    statement.close();
                    connection.close();
                    return id;
        }catch(Exception error){
            return "Error";
        }
       

    }
    public void createConta(String idUser){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            Random rand = new Random();
            int saldo = Math.abs(rand.nextInt());
             statement.execute(
                "insert into contas(idUser,saldo) values('"+ idUser+"','"+saldo+"')"
            );
            statement.close();
            connection.close();
            String message = "User de id"+idUser+" criou uma conta";
            this.saveLog(idUser,message);
        }catch(Exception error){

            System.out.println(error);
        }
    }
    public void createMovimentacao(String idUser,int valor,int saldo){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            statement.execute(
                "insert into movimentacoes(idUser,operacao,valor) values("+idUser+",'R',"+valor+")"
            );
            statement.close();
            String message ="User de id"+idUser+" criou uma movimentacao";
            this.saveLog(idUser, message);
            Statement statement2 = connection.createStatement();
           int result = saldo-valor;
           statement2.execute(
            "update contas set saldo = "+result+" where idUser = "+idUser
           );
           String message2 = "User de id"+idUser+"mudou o saldo de"+saldo+"para"+result;
           this.saveLog(idUser, message2);

            connection.close();
        }catch(Exception error){
            System.out.println("Aqui"+error);
        }
    }
    public int updateSaldo(String idUser){
            Random rand = new Random();
            int saldo = Math.abs(rand.nextInt());
            try{
                Connection connection = Connect.startConnection();
                Statement statement;
                statement = connection.createStatement();
                statement.execute(
                    "update contas set saldo = "+saldo+" where idUser="+idUser
                );
                String message = "Usuario de id"+ idUser +"mudou seu saldo para" + saldo;
                this.saveLog(idUser, message);
                statement.close();
                connection.close();
                return saldo;
            }catch(Exception error){
                System.out.println(error);
                return saldo;
            }
    }
    public void selectAll(String idUser){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                "select * from movimentacoes where idUser ="+ idUser
            );
            String message = "User de id"+idUser+"fez um select";
            this.saveLog(idUser, message);
            resultSet.close();
            statement.close();
            connection.close();
        }catch(Exception error){
            System.out.println(error);
        }
    }
    public void deleteMovimentacao(String idUser){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            statement.execute(
                "delete from movimentacoes where idUser ="+ idUser
            );
            String message = "User de id"+idUser+"fez um delete de todas as movimentacoes";
            this.saveLog(idUser, message);
            statement.close();
            connection.close();
        }catch(Exception error){
            System.out.println(error);
        }
    }
    public void saveLog(String idUser,String message){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            statement.execute(
                "insert into log(idUser,message) values('"+ idUser + "','"+message+"')"
            );
        }catch(Exception error){
            System.out.println(error);
        }
    }
}
