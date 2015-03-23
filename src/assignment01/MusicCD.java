/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment01;

import java.io.Serializable;

/**
 *
 * @author lion
 */
public class MusicCD implements Serializable{
    String code;
    String title;
    String artist;
    double price;

    public MusicCD(String code, String title, String artist, double price) {
        this.code = code;
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MusicCD() {
    }
    
    public Object[] toArray(){
        Object[] obj = {this.code, this.title, this.artist, this.price};
        return obj;
    }
}
