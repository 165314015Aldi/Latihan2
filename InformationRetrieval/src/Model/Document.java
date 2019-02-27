/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Document {
    private int id;
    private String content;

    public Document() {
    }
    
    public Document(String content) {
        this.content = content;
    }
    
    public Document(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String[] getListofTerm(){
        String value = this.getContent();
        value = value.replaceAll("[.,?!]", "");
        return value.split(" ");
    }

    public ArrayList<Posting> getListofPosting(){
        //panggil fungsi getlistofterm
        //buat object arraylistPosting result untuk menampung hasil
        //buat looping sebanyak list of term
            //di dalam looping
            //cek jika term pertama maka
                //buat object tempPosting
                //set atribut documentnya, gunakan this
                //tambahkan ke Arraylist Result
            //lainnya
                //sorting ArrayList result
                //cek apakah tersm sudah ada, maka gunakan fungsi search dengan keluaran indeks objek yang memenuhi
                //jika hasil cari kurang dari 0 (objek tidak ada)
                    //buat object TempPosting
                    //set atribut documentnya, gunakan this
                    //tambahkan ke ArrayList Result
                //lainnya (objek ada)
                    //ambil postingnya, tambahkan 1 ke numberoftermnya 
                    //dengan fungsi 
                    //int TempNumber = get(indeks hasil cari).
        return null;
    }
    
}
