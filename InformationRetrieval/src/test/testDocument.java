/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.Document;
import Model.Posting;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class testDocument {

    public static void main(String[] args) {
        Document doc1 = new Document(1, "computer information retrieval");
        Document doc2 = new Document(2, "computer organization and architecture");
//        keluaran kata computer information retrieval dipotong-potong menjadi 3 String
//        computer
//        information
//        retrieval
        String tokenDoc1[] = doc1.getListofTerm();
        String tokenDoc2[] = doc2.getListofTerm();
        //siapkan posting listnya
        ArrayList<Posting> list = new ArrayList<Posting>();

        //buat node posting untuk doc1
        for (int i = 0; i < tokenDoc1.length; i++) {
            //buat temp Posting
            Posting tempPosting = new Posting(tokenDoc1[i],doc1);
            //masukkan ke list
            list.add(tempPosting);
//            System.out.println("term " + i + " = " + tokenDoc1[i]);
        }
        //buat node posting untuk doc2
        for (int i = 0; i < tokenDoc2.length; i++) {
            //buat temp Posting
            Posting tempPosting = new Posting(tokenDoc2[i],doc2);
            //masukkan ke list
            list.add(tempPosting);
//            System.out.println("term " + i + " = " + tokenDoc1[i]);
        }
        
        //panggil list posting
        System.out.println("Ukuran list : "+list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTerm()+" , "+list.get(i).getDocument().getId());
        }
    }
}
