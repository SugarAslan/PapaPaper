package BotInterfase;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class SaverCSV {
    public void saverCSV(List<Article> articleList) throws IOException {
        String csv = "articles.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        String [] record;

        for (Article article: articleList) {
            record = (article.toString()).split(";");
            writer.writeNext(record);
        }

        writer.close();


    }
    public List<Article> readerCSV() throws IOException {
        LinkedList<Article> articleList = new LinkedList<Article>() ;
        Article article;
        //Build reader instance
        CSVReader reader = new CSVReader(new FileReader("articles.csv"), ',', '"', 1);
        //Read all rows at once
        List<String[]> allRows = reader.readAll();
        //Read CSV line by line and use the string array as you want
        for (String[] row : allRows) {
            article = new Article(row[0]);
            articleList.add(article);
        }
        return articleList;
    }
}
