package scrap_teste;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        //https://g1.globo.com/globonews/jornal-globonews/ 
        Document doc = Jsoup.connect("https://g1.globo.com/globonews/jornal-globonews/").get();
        log(doc.title());

        Elements newsHeadlines = doc.select("div._evt h2 a");
        for(Element headline : newsHeadlines)
        {
            log("%s\n\t%s", headline.text(), headline.absUrl("href"));
        }

        // Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        // log(doc.title());

        // Elements newsHeadlines = doc.select("#mp-itn b a"); //dento do id mp-itn, qlqr tag a dentro da tag b
        // for (Element headline : newsHeadlines) {
        //     log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        // }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}