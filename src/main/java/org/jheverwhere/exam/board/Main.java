package org.jheverwhere.exam.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 게시판 시작==");

    int id = 1;
    while (true) {
      System.out.printf("명령)");
      String cmd = in.nextLine();
      if (cmd.equals("/usr/article/write")) {
        System.out.println("==게시물 등록==");
        System.out.printf("제목 : ");
        String title = in.nextLine();
        System.out.printf("내용 : ");
        String body = in.nextLine();

        Article article = new Article();
        article.id = id;
        article.title = title;
        article.body = body;
        System.out.println("생성 된 게시물"+article);
        System.out.printf("%d번 게시물이 등록되었습니다. \n", article.id);
        id++;
      } else if (cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      } else {
        System.out.println("잘못된 경로입니다. 다시 입력해주세요.");
        continue;
      }


    }
    in.close();

  }
}
class Article{
  int id;
  String title;
  String body;

  @Override
  public String toString() {
    return String.format("번호 : %d\n제목 : \"%s\"\n내용 : \"%s\"\n",id ,title,body);
  }
}