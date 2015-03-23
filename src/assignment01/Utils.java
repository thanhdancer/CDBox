/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment01;

import java.util.Random;

/**
 *
 * @author lion
 */
public class Utils {
    public String generateString(int len){
        int leftLimit = 97;
        int rightLimit = 122;
        
        StringBuilder buffer = new StringBuilder(len);
        for(int i = 0; i < len; i++){
            int randomLimitedInt = leftLimit + (int)
                (new Random().nextFloat() * (rightLimit - leftLimit));
            buffer.append((char) randomLimitedInt);
        }
        
        String generatedString = buffer.toString();
        return generatedString;
    }
}
