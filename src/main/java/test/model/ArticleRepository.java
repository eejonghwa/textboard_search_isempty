package test.model;

import test.util.Util;

import java.util.ArrayList;

public class ArticleRepository {

    public ArticleRepository(){
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "종화", Util.getCurrentDate());
        Article a2 = new Article(2, "자바 질문좀 할게요~", "종화", Util.getCurrentDate());
        Article a3 = new Article(3, "정처기 따야되나요?", "종화", Util.getCurrentDate());

        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
    }
    ArrayList<Article> articles = new ArrayList<>();
    int lastArticleId = 4;

    public void insert(String title, String content){
        Article article = new Article(lastArticleId, title, content, Util.getCurrentDate());
        articles.add(article);
        lastArticleId++;
    }
    public void delete(Article article){
        articles.remove(article);
    }
    public ArrayList<Article> findAllArticles(){
        return articles;
    }
    public Article findById(int id) {
        Article target = null;
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }
        return target;
    }
    public ArrayList<Article> findByTitle(String keyword) {
        ArrayList<Article> searchedArticles = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            String title = article.getTitle();

            if (title.contains(keyword)) {
                searchedArticles.add(article);
            }
        }
        return searchedArticles;
    }
}
