/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestLucene;

import java.io.StringReader;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

/**
 *
 * @author admin
 */
public class TestStemWordToken {
    public static void main(String[] args) {
        String text = "Shipment of gold damaged in fire";
        System.out.println("Old Text = "+text);
        Version matchVersion = Version.LUCENE_7_7_0;
        Analyzer analyzer = new StandardAnalyzer();
        analyzer.setVersion(matchVersion);
        //ambil stopword
        CharArraySet stopWords = EnglishAnalyzer.getDefaultStopSet();
        //buat token
        TokenStream tokenStream = analyzer.tokenStream("myField", new StringReader(text.trim()));
        //Stemming
        tokenStream = new PorterStemFilter(tokenStream);
        //buat string baru tanpa stopword
        StringBuilder sb = new StringBuilder();
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        try {
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                String term = charTermAttribute.toString();
                sb.append(term + " ");
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        String newText = sb.toString();
        System.out.println("New Text = "+newText);
    }
}
