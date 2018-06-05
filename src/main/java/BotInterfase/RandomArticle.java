package BotInterfase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomArticle{
    public Article getRandomArticle() throws IOException {
        ParserHabr Habr = new ParserHabr();
        List<Article> articleList = new ArrayList<Article>();
        Random rand = new Random();
        SaverCSV r = new SaverCSV();
        articleList = r.readerCSV();
        int articlNum = rand.nextInt(articleList.size());
        return articleList.get(articlNum);
    }

}