package com.example.hw8p5;

public class WeatherData {
    private String feelsLike;
    private String temp;
    private String cityName;
    private String tempMax;
    private String tempMin;
    private String lat;
    private String lon;
    private String time;
    private String wind;
    private String humid;
    private long timeLong;

    public WeatherData(){};

    public void setFeelsLike(String fl){
        this.feelsLike = fl;
    }

    public void setTemp(String t){
        this.temp = t;
    }

    public void setCityName(String c){
        this.cityName = c;
    }

    public void setTempMax(String t){
        this.tempMax = t;
    }

    public void setTempMin(String t){
        this.tempMin = t;
    }

    public void setLat(String l){
        this.lat = l;
    }

    public void setLon(String l){
        this.lon = l;
    }

    public void setTime(String T) {this.time = T;}

    public void setWind(String w){this.wind = w;}

    public void setHumid(String h){this.humid = h;}


    public String getTemp(){
        return this.temp;
    }

    public String getLat(){
        return this.lat;
    }

    public String getLon(){
        return this.lon;
    }

    public String getFeelsLike(){
        return this.feelsLike;
    }

    public String getCityName(){
        return this.cityName;
    }

    public String getTempMax(){
        return this.tempMax;
    }

    public String getTempMin(){
        return this.tempMin;
    }

    public String getTime(){ return  this.time;}

    public String getWind() { return this.wind;}

    public String getHumid() { return this.humid;}

    public void setTimeLong(long dt) {
        this.timeLong = dt;
    }
    public Long getTimeLong(){return timeLong;}
}
