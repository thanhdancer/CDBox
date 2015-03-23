/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lion
 */
public class BOMusicCD implements Comparator<MusicCD>{
    
    private List<MusicCD> listCD;

    /**
     *
     * @return
     */
    public List<MusicCD> getListCD() {
        return listCD;
    }

    /**
     *
     * @param listCD
     */
    public void setListCD(List<MusicCD> listCD) {
        this.listCD = listCD;
    }

    public BOMusicCD(List<MusicCD> list) {
        this.listCD = list;
    }
    
    public BOMusicCD() {
        listCD = new ArrayList<>();
    }
    
    /**
     *  Add new Music CD to the list
     * 
     * @param cd
     */
    public void add(MusicCD cd){        
        listCD.add(cd);
    }
    
    /**
     *
     * Search music by code
     * 
     * @param code
     * @return
     */
    public MusicCD searchByCode(String code){
        int size = listCD.size();
        boolean found = false;
        MusicCD tmp = null;
        for (int i = 0; i < size; i++){
            tmp = listCD.get(i);
            if(tmp.getCode().compareTo(code) == 0){
                found = true;
                break;
            }
        }
        if(found){
            return tmp;
        }else{
            return null;
        }
    }
    
    /**
     *
     * Search music by title
     * 
     * @param title
     * @return
     */
    public MusicCD searchByTitle(String title){
        int size = listCD.size();
        boolean found = false;
        MusicCD tmp = null;
        for (int i = 0; i < size; i++){
            tmp = listCD.get(i);
            if(tmp.getTitle().compareTo(title) == 0){
                found = true;
                break;
            }
        }
        if(found){
            return tmp;
        }else{
            return null;
        }
    }
    
    /**
     *
     * Search music by artist
     * 
     * @param artist
     * @return
     */
    public MusicCD searchByArtist(String artist){
        int size = listCD.size();
        boolean found = false;
        MusicCD tmp = null;
        for (int i = 0; i < size; i++){
            tmp = listCD.get(i);
            if(tmp.getArtist().compareTo(artist) == 0){
                found = true;
                break;
            }
        }
        if(found){
            return tmp;
        }else{
            return null;
        }
    }
    
    /**
     *
     * Search music by price
     * 
     * @param price
     * @return
     */
    public MusicCD searchByPrice(double price){
        int size = listCD.size();
        boolean found = false;
        MusicCD tmp = null;
        for (int i = 0; i < size; i++){
            tmp = listCD.get(i);
            if(tmp.getPrice() == price){
                found = true;
                break;
            }
        }
        if(found){
            return tmp;
        }else{
            return null;
        }
    }
    
    /**
     *
     * Read file and add to list
     * 
     * @param filePath
     */
    public void loadAll(String filePath){
        File fileHandle = new File(filePath);
        List<MusicCD> tmpListCD = new ArrayList<>();
        
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream( new FileInputStream(fileHandle));
            tmpListCD = (List<MusicCD>) ois.readObject();
            
            int size = tmpListCD.size();
            for(int i = 0; i < size; i++){
                listCD.add(tmpListCD.get(i));
            }
                        
        } catch (IOException ex) {
            Logger.getLogger(BOMusicCD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BOMusicCD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(BOMusicCD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     *
     * Save list data to file 
     * 
     * @param filePath
     */
    public void saveData(String filePath){
        File fileHandle = new File(filePath);
        ObjectOutputStream oos = null;
        
        try{
            oos = new ObjectOutputStream(new FileOutputStream(fileHandle));
            oos.writeObject(listCD);
        } catch (IOException ex) {
            Logger.getLogger(BOMusicCD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(BOMusicCD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     *
     * Get size of CD list
     * 
     * @return
     */
    public int getSize(){
        return listCD.size();
    }
    
    /**
     *
     * Get a music CD
     * 
     * @param index
     * @return
     */
    public MusicCD getMusic(int index){
        return listCD.get(index);
    }

    /**
     *  Sort music
     */
    public void sortMusic(){
        Collections.sort(listCD, new BOMusicCD());
    }
    
    /**
     *
     * Delete Music CD by index
     * 
     * @param index
     */
    public void deleteMusic(int index){
        listCD.remove(index);
    }
    
    /**
     *
     * Delete Music CD by code
     * 
     * @param code
     */
    public void deleteMusic(String code){
        int size = listCD.size();
        
        for(int i = 0; i< size; i++){
            MusicCD tmp = listCD.get(i);
            if(code.compareTo(tmp.getCode()) == 0){
                listCD.remove(i);
                break;
            }
        }
    }
    
    @Override
    public int compare(MusicCD t, MusicCD t1) {
        return t.getCode().compareTo(t1.getCode());
    }
}
