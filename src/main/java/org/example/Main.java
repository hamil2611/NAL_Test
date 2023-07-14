package org.example;

import java.util.Scanner;

public class Main {
    public static int toTelex(String s) {
        if (s.equals("aw") || s.equals("aa") || s.equals("dd") || s.equals("ee") || s.equals("oo") || s.equals("ow")
        )
            return 1;
        else if (s.equals("ww"))
            return 2;
        else if (s.contains("w"))
            return 1;
        else
            return 0;
    }

    public static double countVietnameseLetters(String s) {
        double cnt = 0;
        String letters = "";
        for (int i = 0; i < s.length(); i++) {
            letters += s.charAt(i);
            if (letters.length() == 2) {
                int rs = toTelex(letters);
                if (rs == 0)
                    // Không có chữ cái Tiếng Việt nào tồn tại thì lấy chữ cái hiện tại để tiếp tục kết hợp
                    letters = String.valueOf(s.charAt(i));
                else {
                    cnt += rs;
                    letters = "";
                }
            }
        }
        if (letters.length() == 1 && letters.equals("w"))
            cnt += 1;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(countVietnameseLetters(s));
    }
}