package cinema;

import java.util.Scanner;

public class firstSection {

    public static void main(String[] args) {

        int row,seat;
        int rowP,seatP;
        int rowS,seatS;
        // int seatTotal=0;

        row = readRow();
        seat = readSeat();

        rowP=row+1;
        seatP=seat+1;
        String[][] cinema=new String[rowP][seatP];

        // initiate and print default Cinema
        intCinema(cinema,rowP,seatP);
        printCinema(cinema,rowP,seatP);

        // Sell seat and show the price of it and print Cinema
        rowS = readRowSell();
        seatS = readSeatSell();
        ticketPrice(row,seat,rowS,seatS);
        sellSeat(cinema,rowS,seatS);

        printCinema(cinema,rowP,seatP);



        //seatTotal=row*seat;

        //calcTotal(seatTotal,row,seat);

    }

    public static void intCinema(String[][] cinema,int row,int seat){
        for (int i=0;i< row;i++) {
            for (int j = 0; j < seat; j++) {
                if(i==0 && j==0){
                    cinema[i][j]=" ";
                }else if(i==0){
                    cinema[i][j]= String.valueOf(j);
                }else if(j==0){
                    cinema[i][j]= String.valueOf(i);
                }else {
                    cinema[i][j] = "S";
                }

            }
        }

    }

    public static void printCinema(String[][] cinema,int row,int seat){
        System.out.println("Cinema:");
        for (int i=0;i< row;i++) {
            for (int j = 0; j < seat; j++) {
                System.out.print(cinema[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void sellSeat(String[][] cinema,int row,int seat){
        cinema[row][seat]="B";
    }

    public static void ticketPrice(int row,int seat,int rowS,int seatS){
        int total= row*seat;
        if (total < 60){
            System.out.println("Ticket price: $10");
        } else{
            if (row / 2 >= rowS){
                System.out.println("Ticket price: $10");
            } else if (row / 2 < rowS){
                System.out.println("Ticket price: $8");
            }
        }
        System.out.println();
    }


    public static int readRow(){
        int row;
        do {
            System.out.println("Enter the number of rows:");
            System.out.print("> ");
            Scanner scan = new Scanner(System.in);
            row = scan.nextInt();
        }while(row >9 );
        return row;
    }

    public static int readSeat(){
        int seat;
        do {
            System.out.println("Enter the number of seats in each row:");
            System.out.print("> ");
            Scanner scan = new Scanner(System.in);
            seat = scan.nextInt();
        }while(seat >9 );
        System.out.println();
        return seat;
    }
    public static int readRowSell(){
        int row;
        do {
            System.out.println("Enter a row number:");
            System.out.print("> ");
            Scanner scan = new Scanner(System.in);
            row = scan.nextInt();
        }while(row >9 );
        return row;
    }

    public static int readSeatSell(){
        int seat;
        do {
            System.out.println("Enter a seat number in that row:");
            System.out.print("> ");
            Scanner scan = new Scanner(System.in);
            seat = scan.nextInt();
        }while(seat >9 );
        System.out.println();
        return seat;
    }

    public static void calcTotal(int seatTotal, int row, int seat ){
        int price1=10;
        int price2=8;
        int firstHalf=row/2;
        if(seatTotal<60){
            System.out.println("Total income:");
            System.out.println("$"+ price1*seatTotal);
        } else{
            System.out.println("Total income:");
            System.out.println("$"+  ( ( firstHalf * seat * price1 ) + ( ( row - firstHalf) *seat * price2 ) ) );

        }
    }
}