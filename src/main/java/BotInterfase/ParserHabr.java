package BotInterfase;

import BotInterfase.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserHabr {
    private String BASE_URL = "https://habr.com/top/yearly/";

    private Document getHTML(String URL) throws IOException {
        return Jsoup.connect(URL).get();
    }

//    public Integer getPageNumber() throws IOException {
//        Document doc = getHTML(BASE_URL);
//        Elements pages = doc.getElementsByAttributeValue("class", "toggle-menu__item toggle-menu__item_pagination");
//        Element page = pages.last();
//
//        Integer pageNumber = Integer.valueOf(page.child(0).text());
//        return pageNumber;
//    }

    public List<Article> articles(){

        List<Article> articleList = new ArrayList<Article>();
        Integer pageNumber = 100;
        for (int i = 1; i <= pageNumber; i++) {
            Document doc = null;
            try {
                doc = getHTML(BASE_URL + "page" + i + "/");
            } catch (IOException e) {
                continue;
            }
            Elements artElements = doc.getElementsByAttributeValue("class", "post post_preview");

            for (Element element : artElements) {
                Element h2Element = element.child(1);
                String url = h2Element.child(0).attr("href");

                articleList.add(new Article(url));
            }
        }
        return articleList;

    }
}
