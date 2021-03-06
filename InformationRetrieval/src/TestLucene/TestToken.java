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
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.Version;

/**
 *
 * @author admin
 */
public class TestToken {
    public static void main(String[] args) {
        String text = "I want to break my freedom";
        Version matchVersion = Version.LUCENE_7_7_0;
        Analyzer analyzer = new StandardAnalyzer();
        analyzer.setVersion(matchVersion);
        //ambil stopword
        CharArraySet stopWords = EnglishAnalyzer.getDefaultStopSet();
        //buat token
        TokenStream tokenStream = analyzer.tokenStream("myField", new StringReader(text.trim()));
        //buang Stopword
        tokenStream = new StopFilter(tokenStream , stopWords);
    }
}
