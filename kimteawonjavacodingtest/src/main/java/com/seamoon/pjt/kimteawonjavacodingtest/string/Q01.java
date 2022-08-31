package com.seamoon.pjt.kimteawonjavacodingtest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 1. 문자 찾기
 * 설명
 * -> 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 *    대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지 않습니다.
 * 입력
 * -> 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
 *    문자열은 영어 알파벳으로만 구성되어 있다.
 *    Computercooler
 *    c
 * 출력
 * -> 첫 줄에 해당 문자의 개수를 출력한다.
 *    2
 */
public class Q01 {
    public static void main(String[] args) throws IOException {

        Q01 main = new Q01();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);

        System.out.println(main.solution(str, ch));

    }
    private int solution(String str, char ch) {

        int result = 0;

        //대소문자 상관없이 -> 모두 대문자로 변경
        str = str.toUpperCase();

        //대소문자 상관없이 -> 문자열을 대문자로 변경했으니 문자도 이와동일하게 대문자로 변경
        ch = Character.toUpperCase(ch);

        //문제풀이1. charAt 을 사용한 문제 풀이 방법
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                result ++;
            }
        }

        //문제풀이2. 향상된 for문을 사용한 문제 풀이 방법
//        for (char x : str.toCharArray()) {
//            if (ch == x) {
//                result ++;
//            }
//        }

        return result;
    }
}
