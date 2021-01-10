import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int len=scan.nextInt();
        int[] array=new int[len];
        int counter=1;
        int big=1;

        for(int i=0; i<len; i++){
            array[i]=scan.nextInt();
        }


        for(int i=0; i<len-1; i++){

            if(array[i]<array[i+1]){
                counter++;
                if (big==1) {
                    big=counter;

                } else if (counter > big) {
                    big = counter;
                }

                }
            else{
                    counter=1;

                }
            }




        System.out.println(big);
    }
}