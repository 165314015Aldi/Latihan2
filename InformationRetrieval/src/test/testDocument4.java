/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.Document;
import Model.InvertedIndex;
import Model.Posting;
import Model.Term;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class testDocument4 {

    public static void main(String[] args) {
        Document doc1 = new Document(1, "computer information retrieval");
        Document doc2 = new Document(2, "computer organization and architecture");
        Document doc3 = new Document(3, "machine learning architecture");
        //buat object inverted index
        InvertedIndex index = new InvertedIndex();
        //tambahkan dokumen ke Index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);
        
        index.makeDictionary();
        ArrayList<Posting> result = index.searchOneWord("machine");
        
        for (int i = 0; i < result.size(); i++) {
            System.out.println("id_doc = "+result.get(i).getDocument().getId());
            System.out.println(result.get(i).getDocument().getContent());
        }
        
//        ArrayList<Posting> result1 = index.search("machine");
//        
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println("id_doc = "+result.get(i).getDocument());
//            System.out.println(result.get(i).getDocument().getContent());
//        }
    }
}
