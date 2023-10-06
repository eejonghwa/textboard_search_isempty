package test.controller;

import test.model.Article;
import test.model.ArticleRepository;
import test.view.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    Scanner scan = new Scanner(System.in);

    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();

    public void add() {
        System.out.print("제목 입력 : ");
        String title = scan.nextLine();
        System.out.print("내용 입력 : ");
        String content = scan.nextLine();

        articleRepository.insert(title, content);
        System.out.println("게시물 저장완료");
    }

    public void list() {
        ArrayList<Article> articles = articleRepository.findAllArticles();
        articleView.printArticles(articles);
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int targetId = scan.nextInt();
        scan.nextLine();

        Article article = articleRepository.findById(targetId);

        if (article == null) {
            System.out.println("없는 게시물");
        } else {
            System.out.print("수정할 제목 : ");
            String newTitle = scan.nextLine();
            System.out.print("수정할 내용 : ");
            String newContent = scan.nextLine();

            article.setTitle(newTitle);
            article.setContent(newContent);

            System.out.println("수정완료");
        }
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int targetId = scan.nextInt();
        scan.nextLine();

        Article article = articleRepository.findById(targetId);

        if (article == null) {
            System.out.println("없는 게시물");
        } else {
            articleRepository.delete(article);
            System.out.println("삭제완료");
        }
    }

    public void detail() {
        System.out.print("상세보기할 게시물 번호 : ");
        int targetId = scan.nextInt();
        scan.nextLine();

        Article article = articleRepository.findById(targetId);

        if (article == null) {
            System.out.println("없는 게시물");
        } else {
            article.setHit(article.getHit() + 1);
            articleView.printArticleDetail(article);

        }
    }

    public void search() {
        System.out.print("검색할 게시물 제목 : ");
        String keyword = scan.nextLine();

        ArrayList<Article> article = articleRepository.findByTitle(keyword);

        if (article.isEmpty()) {
            System.out.println("없는 게시물");
        } else {
            articleView.printArticles(article);
        }
    }
}