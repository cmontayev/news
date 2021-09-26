package Chingis.Montayev.news.model;

import Chingis.Montayev.news.service.DBManager;

public class Users {
    Long id;
    String fullName;
    String email;
    String login;
    String pass;
    String pathImage;

    public Users(Long id, String fullName, String email,  String login, String pass, String pathImage) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.pass = pass;
        this.login = login;
        this.pathImage = pathImage;
    }

    public Users() {
    }

    public Users(String fullName) {
        this.fullName = fullName;
    }

    public Users(String fullName, String path_image) {
        this.fullName = fullName;
        this.pathImage = path_image;
    }

    public Users(Long id, String full_name, String email, String login, String path_image) {
        this.id = id;
        this.fullName = full_name;
        this.email = email;
        this.login = login;
        this.pathImage = path_image;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
