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
    private ArrayList<Term> dictionary = new ArrayList<Term>();

    public InvertedIndex() {
    }

    public void addNewDocument(Document document) {
        this.listOfDocument.add(document);
    }

    public ArrayList<Document> getListOfDocument() {
        return listOfDocument;
    }

    public void setListOfDocument(ArrayList<Document> listOfDocument) {
        this.listOfDocument = listOfDocument;
    }

    public ArrayList<Term> getDictionary() {
        return dictionary;
    }

    public void setDictionary(ArrayList<Term> dictionary) {
        this.dictionary = dictionary;
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
    
    public void makeDictionary(){
        //buat posting term terurut
        ArrayList<Posting> list = getSortedPostingList();
        //looping buat list of term (dictionary)
        for (int i = 0; i < list.size(); i++) {
            //cek dictionary kosong atau tidak
            if (dictionary.isEmpty()) {
                //buat term
                Term term = new Term(list.get(i).getTerm());
                //tambah posting list untuk term ini
                term.getPostingList().add(list.get(i));
                //tambah ke dictionary
                getDictionary().add(term);
            }else{
                //dictionary sudah ada isinya
                //buat term baru
                Term tempTerm = new Term(list.get(i).getTerm());
                //pembandingan apakah term sudah ada atau belum
                int position = Collections.binarySearch(dictionary, tempTerm);//keluarannya berupa posisi indeksnya
                if (position<0) {
                    //term baru
                    //tambah posting list ke term 
                    tempTerm.getPostingList().add(list.get(i));
                    //tambahkan term ke dictionary
                    dictionary.add(tempTerm);
                }else{
                    //term ada
                    //tambahkan posting list saja dari existing term
                    dictionary.get(position).getPostingList().add(list.get(i));
                    //urutkan posting list
                    Collections.sort(dictionary.get(position).getPostingList());
                }
                //urutkan term dictionary
                Collections.sort(dictionary);
            }
        }
    }
    
}
