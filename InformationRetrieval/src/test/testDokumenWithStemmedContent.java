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
public class testDokumenWithStemmedContent {
    public static void main(String[] args) {
        Document doc = new Document(1, "He was a man with a gun");
        System.out.println("Without Stemming");
        System.out.println(doc.getContent());
        doc.Stemming();
        System.out.println("With Stemming");
        System.out.println(doc.getContent());
        
    }
}
