package test.controller;

import test.model.ArticleRepository;
import test.view.ArticleView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BoardApp {


    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleController articleController = new ArticleController();

    public void start() {


        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();

            if (command.equals("exit")) {
                System.out.println("종료");
                break;
            } else if (command.equals("add")) {
                articleController.add();
            } else if (command.equals("list")) {
                articleController.list();
            } else if (command.equals("update")) {
                articleController.update();
            } else if (command.equals("delete")) {
                articleController.delete();
            } else if (command.equals("detail")) {
                articleController.detail();
            } else if (command.equals("search")) {
                articleController.search();
            }
        }

    }


    public String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String formatedNow = now.format(formatter);

        return formatedNow;
    }
}
