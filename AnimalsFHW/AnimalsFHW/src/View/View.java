package View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    public View() {
    }

    public Character showMenu(HashMap<Character, String> menu, String Head) {
        System.out.println(Head);
        for (Map.Entry<Character, String> entry : menu.entrySet()) {
            System.out.printf("%s: %s", entry.getKey(), entry.getValue());
            System.out.println();
        }
        Scanner sc = new Scanner(System.in, "cp866");

        String result = sc.nextLine();

        if (menu.containsKey(result.charAt(0)))
            return result.charAt(0);
        else
            return 'e';

    }

    public String showMenuBig(HashMap<String, String> menu, String Head) {
        System.out.println(Head);
        for (Map.Entry<String, String> entry : menu.entrySet()) {
            System.out.printf("%s: %s", entry.getKey(), entry.getValue());
            System.out.println();
        }
        Scanner sc = new Scanner(System.in, "cp866");

        String result = sc.nextLine();

        if (menu.containsKey(result))
            return result;
        else
            return "0";

    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getAnswer(String question) {

        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        String ret = sc.nextLine();
        return ret;

    }
}
