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
public class MovieCD implements Serializable{
    String code;
    String title;
    double price;

    public MovieCD(String code, String title, double price) {
        this.code = code;
        this.title = title;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MovieCD() {
    }
    
    public Object[] toArray(){
        Object[] obj = {this.code, this.title, this.price};
        return obj;
    }
}
