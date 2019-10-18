package com.alc.aad54.models;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherForecastModel implements Parcelable {

    private String info;
    private String tempMin;
    private String tempMax;
    private String date;
    private String humidity;
    private String pressure;
    private String wind;
    private String uv;
    private int icon;

    public WeatherForecastModel() {
    }

    public WeatherForecastModel(String info, String tempMin, String tempMax, String date, String humidity, String pressure, String wind, String uv, int icon) {
        this.info = info;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.date = date;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
        this.uv = uv;
        this.icon = icon;
    }

    protected WeatherForecastModel(Parcel in) {
        info = in.readString();
        tempMin = in.readString();
        tempMax = in.readString();
        date = in.readString();
        humidity = in.readString();
        pressure = in.readString();
        wind = in.readString();
        uv = in.readString();
        icon = in.readInt();
    }

    public static final Creator<WeatherForecastModel> CREATOR = new Creator<WeatherForecastModel>() {
        @Override
        public WeatherForecastModel createFromParcel(Parcel in) {
            return new WeatherForecastModel(in);
        }

        @Override
        public WeatherForecastModel[] newArray(int size) {
            return new WeatherForecastModel[size];
        }
    };

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(info);
        parcel.writeString(tempMin);
        parcel.writeString(tempMax);
        parcel.writeString(date);
        parcel.writeString(humidity);
        parcel.writeString(pressure);
        parcel.writeString(wind);
        parcel.writeString(uv);
        parcel.writeInt(icon);
    }
}
