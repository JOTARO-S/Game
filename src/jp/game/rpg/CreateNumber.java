package jp.game.rpg;

import java.util.Random;
import java.util.Scanner;

public class CreateNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String allowedChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String MAIL_DOMAIN = "@test.com";
        System.out.println("メールアドレスの長さを入力(9文字以上(ドメインの長さ)):");
        int choice = scanner.nextInt();
        int length = choice - MAIL_DOMAIN.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }
        sb.append(MAIL_DOMAIN);
        String randomString = sb.toString();
        System.out.println(randomString);
        System.out.println(randomString.length() + "文字");
        scanner.close();
    }
}

