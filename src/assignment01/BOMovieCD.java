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
public class BOMovieCD implements Comparator<MovieCD>{
    List<MovieCD> listMovie ;

    /**
     *
     * Constructor 
     * 
     * @param listMovie
     */
    public BOMovieCD(List<MovieCD> listMovie) {
        this.listMovie = listMovie;
    }

    /**
     *
     * Get all movie list
     * 
     * @return
     */
    public List<MovieCD> getListMovie() {
        return listMovie;
    }

    /**
     *
     * Set movie to list
     * 
     * @param listMovie
     */
    public void setListMovie(List<MovieCD> listMovie) {
        this.listMovie = listMovie;
    }

    /**
     * Constructor
     */
    public BOMovieCD() {
        listMovie = new ArrayList<>();
    }
    
    /**
     *
     * Add new movie
     * 
     * @param mcd
     */
    public void add(MovieCD mcd){
        listMovie.add(mcd);
    }
    
    /**
     *
     * Search movie by code
     * 
     * @param code
     * @return
     */
    public MovieCD searchByCode(String code){
        int size = listMovie.size();
        boolean found = false;
        MovieCD tmp = null;
        for (int i = 0; i < size; i++){
            tmp = listMovie.get(i);
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
     * Search movie by title
     * 
     * @param title
     * @return
     */
    public MovieCD searchByTitle(String title){
        int size = listMovie.size();
        boolean found = false;
        MovieCD tmp = null;
        for (int i = 0; i < size; i++){
            tmp = listMovie.get(i);
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
     * Search movie by price
     * 
     * @param price
     * @return
     */
    public MovieCD searchByPrice(double price){
        int size = listMovie.size();
        boolean found = false;
        MovieCD tmp = null;
        for (int i = 0; i < size; i++){
            tmp = listMovie.get(i);
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
     * Load data from file
     * 
     * @param filePath
     */
    public void loadAll(String filePath){
        File fileHandle = new File(filePath);
        List<MovieCD> tmpList = new ArrayList<>();
        
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream( new FileInputStream(fileHandle));
            tmpList = (List<MovieCD>) ois.readObject();
            
            int size = tmpList.size();
            for(int i = 0; i < size; i++){
                listMovie.add(tmpList.get(i));
            }
                        
        } catch (IOException | ClassNotFoundException ex) {
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
     * Save data to file
     * 
     * @param filePath
     */
    public void saveData(String filePath){
        File fileHandle = new File(filePath);
        ObjectOutputStream oos = null;
        
        try{
            oos = new ObjectOutputStream(new FileOutputStream(fileHandle));
            oos.writeObject(listMovie);
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
     * Get size of movie list
     * 
     * @return
     */
    public int getSize(){
        return listMovie.size();
    }
    
    /**
     *
     * Get a Movie
     * 
     * @param index
     * @return
     */
    public MovieCD getMovie(int index){
        return listMovie.get(index);
    }
    
    /**
     *
     * Sort all movie list
     * 
     */
    public void sortMovie(){
        Collections.sort(listMovie, new BOMovieCD());
    }
    
    /**
     *
     * Delete movie by index
     * 
     * @param index
     */
    public void deleteMovie(int index){
        listMovie.remove(index);
    }
    
    /**
     *
     * Delete Movie by code
     * 
     * @param code
     */
    public void deleteMovie(String code){
        int size = listMovie.size();
        
        for(int i = 0; i < size; i++){
            MovieCD tmp = listMovie.get(i);
            if( code.compareTo(tmp.getCode()) == 0){
                listMovie.remove(i);
                break;
            }
        }
    }
    

    @Override
    public int compare(MovieCD t, MovieCD t1) {
        
        return t.getCode().compareTo(t1.getCode());
    }

    
}
