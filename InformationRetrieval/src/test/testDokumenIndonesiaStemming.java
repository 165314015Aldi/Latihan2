/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.Document;

/**
 *
 * @author admin
 */
public class testDokumenIndonesiaStemming {
    public static void main(String[] args) {
        Document doc = new Document(1, "Dia sedang");
        System.out.println("Without Stemming");
        System.out.println(doc.getContent());
        doc.IndonesianStemming();
        System.out.println("With Stemming");
        System.out.println(doc.getContent());
        
    }
}
