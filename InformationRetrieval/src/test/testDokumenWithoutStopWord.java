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
public class testDokumenWithoutStopWord {
    public static void main(String[] args) {
        Document doc = new Document(1, "He was a man with a gun");
        System.out.println("With Stop Words");
        System.out.println(doc.getContent());
        doc.removeStopWord();
        System.out.println("Without Stop Words");
        System.out.println(doc.getContent());
        
    }
}
