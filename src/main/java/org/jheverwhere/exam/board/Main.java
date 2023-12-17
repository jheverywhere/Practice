package org.jheverwhere.exam.board;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("====UFC 파이터 명단 등록====");
    System.out.println("==== 명단 시작점 ====");
    int id = 1;
    List<Ufc> fighters = new ArrayList<>();
    while (true) {
      System.out.println("****목차***");
      System.out.println("submit // check // exit");
      String str = in.nextLine();

      if (str.equals("submit")) {
        while (true) {
          System.out.println("명단을 제출해 주십시오");
          System.out.println("이전 항목으로 가길원하시면 0을 입력해주십시오.");
          System.out.printf("몸무게 입력(단위는 kg)=> ");

          String weight = "";


            double cmd = in.nextDouble();

            if (cmd == 0) {
              System.out.println("이전단계로 돌아갑니다.");
              in.nextLine();
              break;
            } else if (56.7 <= cmd && cmd < 61.2) {
              weight = "플라이급";
              System.out.println("플라이급에 배정 되었습니다.");
            } else if (61.2 <= cmd && cmd < 65.8) {
              weight = "밴텀급";
              System.out.println("밴텀급에 배정 되었습니다.");
            } else if (65.8 <= cmd && cmd < 70.3) {
              weight = "페더급";
              System.out.println("페더급에 배정 되었습니다.");
            } else if (70.3 <= cmd && cmd < 77.1) {
              weight = "라이트급";
              System.out.println("라이트급에 배정 되었습니다.");
            } else if (77.1 <= cmd && cmd < 83.9) {
              weight = "웰터급";
              System.out.println("웰터급에 배정 되었습니다.");
            } else if (83.9 <= cmd && cmd < 93.0) {
              weight = "미들급";
              System.out.println("미들급에 배정 되었습니다.");
            } else if (93.0 <= cmd && cmd < 105.0) {
              weight = "라이트 헤비급";
              System.out.println("라이트 헤비급에 배정되었습니다.");
            } else if (105.0 <= cmd && cmd < 120.0) {
              weight = "헤비급";
              System.out.println("헤비급에 배정되었습니다.");
            } else {
              System.out.println("잘못 입력하였습니다. 몸무게를 다시 입력해주세요.");
              continue;
            }

          System.out.printf("국적 : ");
          in.nextLine();
          String nationality = in.nextLine();
          System.out.printf("이름 : ");
          String name = in.nextLine();


          Ufc fighter = new Ufc(id, name, weight, nationality);
          fighters.add(fighter);
          System.out.printf("%d번 파이터의 명단이 등록되었습니다.\n", fighter.id);
          System.out.println("============");
          id++;
        }
      } else if (str.equals("check")) {
        if (fighters.isEmpty()) {
          System.out.println("등록된 선수가 없습니다. 명단 제출을 하십시오.");
          continue;
        }
        System.out.println("====== 등록된 선수들 명단 ======");
        System.out.println("******************************");
        System.out.println("번호 /   이름   /   체급   /   국적  ");
        for (int i = fighters.size() - 1; i >= 0; i--) {
          Ufc fighter = fighters.get(i);
          System.out.println(fighter);
        }
        System.out.println("=============================");
      } else if (str.equals("exit")) {
        System.out.println("대진표에 들어갈 명단 작성을 마무리합니다.");
        break;
      }else {
        System.out.println("잘못 입력하였습니다, 다시 입력해주십시오.");
        continue;
      }

    }
    in.close();

  }
}

class Ufc {
  int id;
  String nationality;
  String name;
  String weight;

  Ufc(int id, String name, String weight, String nationality) {
    this.id = id;
    this.name = name;
    this.weight = weight;
    this.nationality = nationality;
  }

  public String toString() {
    return String.format("[%d. %s | %s | %s]", id, name, weight, nationality);
  }
}