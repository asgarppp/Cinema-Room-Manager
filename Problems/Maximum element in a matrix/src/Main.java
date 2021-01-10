import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int n= scan.nextInt();
        int m= scan.nextInt();
        int[][]  matrix=new int[n][m];

        for(int i=0; i <n; i++ ){
            for(int j=0; j <m; j++){
                matrix[i][j]= scan.nextInt();
            }
        }

        int big=matrix[0][0];
        int bigI=0;
        int bigJ=0;

        for(int i=0; i <n; i++ ){
            for(int j=0; j <m; j++){
                if( matrix[i][j] > big ){
                    big=matrix[i][j];
                    bigI=i;
                    bigJ=j;
                }
            }
        }

       System.out.println(bigI+ " " +bigJ);
    }
}