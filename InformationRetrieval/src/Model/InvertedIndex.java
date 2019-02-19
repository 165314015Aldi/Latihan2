/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 *
 * @author admin
 */
public class InvertedIndex {

    private ArrayList<Document> listOfDocument = new ArrayList<Document>();
//    private ArrayList<Posting> postingList = new ArrayList<Posting>();

    public InvertedIndex() {
    }

    public void addNewDocument(Document document) {
        this.listOfDocument.add(document);
    }

    public ArrayList<Posting> getUnsortedPostingList() {
        //siapkan posting listnya
        ArrayList<Posting> list = new ArrayList<Posting>();

        //buat node posting untuk doc1
        for (int i = 0; i < listOfDocument.size(); i++) {
            //buat list of term dari document ke i
            String[] termResult = listOfDocument.get(i).getListofTerm();
            //loop sebanyak term dari document ke i
            for (int j = 0; j < termResult.length; j++) {
                //buat object tempPosting
                Posting tempPosting = new Posting(termResult[j], listOfDocument.get(i));
                list.add(tempPosting);
            }
        }
        return list;
    }
    
    public ArrayList<Posting> getSortedPostingList(){
        ArrayList<Posting> list = new ArrayList<Posting>();
        list = this.getUnsortedPostingList();
        Collections.sort(list);
        return list;
    }
    
}
