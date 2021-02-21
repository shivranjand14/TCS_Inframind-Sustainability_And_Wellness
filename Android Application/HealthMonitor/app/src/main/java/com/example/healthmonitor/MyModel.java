package com.example.healthmonitor;

import java.util.Date;

public class MyModel
{
    private int id;
    private String name,bodytemprature,bloodpressure, respiratoryrate,glucose, heartrate,oxygensaturation,electrocardiogram,bloodsugar,date;
    private Date yyyy,MM,dd;
    public MyModel() {
    }

    @Override
    public String toString() {
        //return "MyModel{" + "id=" + id + ", name='" + name + '\'' + ", latitude='" + latitude + '\'' + ", longitude='" + longitude + '\'' + '}';
        return "MyModel{" + "bodytemprature=" +bodytemprature+ ",bloodpressure='" + bloodpressure + '\'' + ", respiratoryrate='" + respiratoryrate
                + '\'' + ",glucose='" + glucose + '\'' + ", heartrate='" + heartrate+ '\''
                + ",oxygensaturation='" + oxygensaturation + '\'' + ",electrocardiogram='"
                + electrocardiogram + '\'' + ",bloodsugar='" + bloodsugar + '\''  + ",name='"
                + name + '\''  +",date='" + date +'}';
    }

    //get Date
    public Date getYyyy(){return yyyy;}
    public Date getMM(){return MM;}
    public Date getDd(){return dd;}

    //set Date
    public void setYyyy(Date yyyy){this.yyyy=yyyy;}
    public void setMM(Date MM){this.MM=MM;}
    public void setDd(Date dd){this.yyyy=dd;}



    public String getname(){return name;}

    public void setname(String name){this.name=name;}


    public String getdate(){return date;}

    public void setDate(String name){this.date=date;}

    public String getbodytemprature() {
        return bodytemprature;
    }

    public void setbodytemprature(String bodytemprature) {
        this.bodytemprature = bodytemprature;
    }

    public String getbloodpressure() {
        return bloodpressure;
    }

    public void setbloodpressure(String bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public String getrespiratoryrate() {
        return respiratoryrate;
    }

    public void setrespiratoryrate(String respiratoryrate) {
        this.respiratoryrate = respiratoryrate;
    }
    public String getglucose() {
        return glucose;
    }

    public void setglucose(String glucose) {
        this.glucose = glucose;
    }

    public String getheartrate() {
        return heartrate;
    }

    public void setheartrate(String heartrate) {
        this.heartrate = heartrate;
    }
    public String getoxygensaturation() {
        return oxygensaturation;
    }
    public void setoxygensaturation(String oxygensaturation) {
        this.oxygensaturation = oxygensaturation;
    }
    public String getelectrocardiogram() {
        return glucose;
    }

    public void setelectrocardiogram(String electrocardiogram) {
        this.electrocardiogram = electrocardiogram;
    }
    public String getbloodsugar() {
        return bloodsugar;
    }

    public void setbloodsugar(String bloodsugar) {
        this.bloodsugar = bloodsugar;
    }
    public MyModel(String bodytemprature,String bloodpressure, String respiratoryrate,String glucose, String heartrate,String oxygensaturation,String electrocardiogram,String bloodsugar,String name) {
        this.name=name;
        this.bodytemprature = bodytemprature;
        this.bloodpressure = bloodpressure;
        this.respiratoryrate = respiratoryrate;
        this.glucose = glucose;
        this.heartrate = heartrate;
        this.oxygensaturation = oxygensaturation;
        this.electrocardiogram = electrocardiogram;
        this.bloodsugar = bloodsugar;
    }
}
