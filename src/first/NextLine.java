package first;

import java.util.Scanner;

public class NextLine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串1:");
        String string1 = scanner.nextLine();
        System.out.println(string1);
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("请输入字符串2:");
        String string2 = scanner.next();
        System.out.println(string2);
    }
}
