package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] args) {
        int lastArticleId = 1;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();

            if (command.equals("exit")) {
                System.out.println("종료");
                break;
            } else if (command.equals("add")) {
                System.out.print("제목 입력 : ");
                String title = scan.nextLine();
                System.out.print("내용 입력 : ");
                String content = scan.nextLine();

                Article article = new Article(lastArticleId, title, content);
                articles.add(article);
                System.out.println("게시물 저장완료");
            } else if (command.equals("list")) {
                System.out.println("===============");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.println("===============");
                }
            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int targetId = scan.nextInt();
                scan.nextLine();

                Article article = findById(targetId);

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
            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = scan.nextInt();
                scan.nextLine();

                Article article = findById(targetId);

                articles.remove(article);
                System.out.println("삭제완료");
            } else if (command.equals("detail")) {
                System.out.print("상세보기할 게시물 번호 : ");
                int targetId = scan.nextInt();
                scan.nextLine();

                Article article = findById(targetId);

                if (article == null) {
                    System.out.println("없는 게시물");
                } else {
                    System.out.println("==============");
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.println("==============");

                }
            } else if (command.equals("search")) {
                System.out.println("검색할 게시물 제목");
                String keyword = scan.nextLine();

                ArrayList<Article> article = findByTitle(keyword);

                if (article.isEmpty()) {
                    System.out.println("없는 게시물");
                } else {
                    printArticles(article);
                }

            }
        }
    }

    public static ArrayList<Article> findByTitle(String keyword) {
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

    public static Article findById(int id) {
        Article target = null;
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }
        return target;
    }

    public static void printArticles(ArrayList<Article> list) {
            System.out.println("===============");
        for (int i = 0; i < list.size(); i++) {
            Article article = list.get(i);

            System.out.printf("번호 : %d\n", article.getId());
            System.out.printf("제목 : %s\n", article.getTitle());
            System.out.println("===============");

        }
    }
}
