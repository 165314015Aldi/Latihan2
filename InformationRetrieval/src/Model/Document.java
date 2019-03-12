/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class Document implements Comparable<Document>{

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

    public String[] getListofTerm() {
        String value = this.getContent();
        value = value.replaceAll("[.,?!]", "");
        return value.split(" ");
    }

    public ArrayList<Posting> getListofPosting() {
        //panggil fungsi getlistofterm
        String[] tempString = getListofTerm();
        //buat object arraylistPosting result untuk menampung hasil
        ArrayList<Posting> result = new ArrayList<Posting>();
        //buat looping sebanyak list of term
        for (int i = 0; i < tempString.length; i++) {
            //di dalam looping
            //cek jika term pertama maka
            if (i == 0) {
                //buat object tempPosting
                Posting tempPosting = new Posting(tempString[i], this);
                //set atribut documentnya, gunakan this
                //tambahkan ke Arraylist Result
                result.add(tempPosting);
            } else {
                //lainnya
                //sorting ArrayList result
                Collections.sort(result);
                //cek apakah tersm sudah ada, maka gunakan fungsi search dengan keluaran indeks objek yang memenuhi
                Posting temPosting = new Posting(tempString[i], this);
                int indexCari = Collections.binarySearch(result, temPosting);
                //jika hasil cari kurang dari 0 (objek tidak ada)
                if (indexCari < 0) {
                    //buat object tempPosting
                    Posting tempPosting = new Posting(tempString[i], this);
                    //set atribut documentnya, gunakan this
                    //tambahkan ke Arraylist Result
                    result.add(tempPosting);
                } else {
                    //lainnya (objek ada)
                    //ambil postingnya, tambahkan 1 ke numberoftermnya 
                    //dengan fungsi 
                    int TempNumber = result.get(indexCari).getNumberOfTerm() + 1;
                    result.get(indexCari).setNumberOfTerm(TempNumber);
                }
            }
        }
        return result;
    }

    @Override
    public int compareTo(Document t) {
        return id - t.getId();
    }
}
