import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    ArrayList<Character> arrChar;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao chuoi ki tu: ");
        String str = sc.nextLine();
        Main m = new Main();
        m.handle(str);
    }

    public void handle(String str) {
        arrChar = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (!checkExit(arrChar, currentChar)) {
                Character c = new Character(currentChar, 1);
                arrChar.add(c);
            } else {
                for (int j = 0; j < arrChar.size(); j++) {
                    if (currentChar == arrChar.get(j).getName()) {
                        int currentCount = arrChar.get(j).getCount();
                        arrChar.get(j).setCount(currentCount+1);
                    }
                }
            }
        }
        for (Character c:arrChar
             ) {
            c.show();
        }
    }

    public boolean checkExit(ArrayList<Character> arrChar, char a) {

        for (int i = 0; i < arrChar.size(); i++) {
            if (a == arrChar.get(i).getName()) {
                return true;
            }
        }
        return false;
    }

}
