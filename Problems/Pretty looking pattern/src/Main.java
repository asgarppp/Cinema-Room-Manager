import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String data;
        char[][]  matrix=new char[4][4];


        for(int i=0; i <4; i++ ) {
            data=scan.nextLine();
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = data.charAt(j);

            }
        }

        char letter;
        boolean pretty = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                letter = matrix[i][j];

                if (matrix[i + 1][j] == letter && matrix[i][j + 1] == letter && matrix[i + 1][j + 1] == letter) {
                    pretty = false;
                }
            }
        }

        if (pretty) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}