import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int len=scan.nextInt();
        int[] array=new int[len];

        for(int i=0; i<len; i++){
            array[i]=scan.nextInt();
        }
        int n= scan.nextInt();
        int counter=0;


        for(int i=0; i<len; i++){
            if(array[i] ==n){
                counter++;
            }
        }
        System.out.println(counter);
    }
}