package com.example.healthmonitor;

public class ModelClass
{
    private String username;
    private String password;

    public ModelClass() {
    }

    @Override
    public String toString() {
        return "ModelClass{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ModelClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setId(int location_id) {
    }
}
