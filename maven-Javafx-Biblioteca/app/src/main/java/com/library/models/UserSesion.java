package com.library.models;

public class UserSesion {
    private static UserSesion instance;

    private String name;
    private String email;
    private String number;
    private String rol;

    private UserSesion (String name, String email, String number, String rol){
        this.name = name;
        this.email = email;
        this.number = number;
        this.rol = rol;
    }

    public static void CreateSession(String name, String email, String number, String rol){
        instance = new UserSesion(name, email, number, rol);
    }

    public static UserSesion getInstance(){
        return instance;
    }

    public static void CloseSession(){
        instance = null;
    }


    //Getters
    public String getName(){return this.name;}
    public String getEmail(){return this.email;}
    public String getNumber(){return this.number;}
    public String getRol(){return this.rol;}

}
