import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int len=scan.nextInt();
        int[] array=new int[len];
        int temp=0;
        int counter=0;

        for(int i=0; i<len; i++){
            array[i]=scan.nextInt();
        }

        for(int i=0; i<len-2; i++){
            temp=array[i];

                if (array[i + 1] == temp + 1 && array[i + 2] == temp + 2) {
                    counter++;
                }

        }

        System.out.println(counter);
    }
}