package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        int row,seat;
        int rowP,seatP;
        int xProcess;

        row = readRow();
        seat = readSeat();

        rowP=row+1;
        seatP=seat+1;
        String[][] cinema=new String[rowP][seatP];

        // initiate and print default Cinema
        intCinema(cinema,rowP,seatP);


        // menu

        while(true){
            xProcess=menu();



            if(xProcess == 1) {
                System.out.println();
                printCinema(cinema, rowP, seatP);
            }else if(xProcess == 2) {
                System.out.println();
                // Sell seat and show the price of it and print Cinema
                sellSeat(cinema,row,seat);
            } else if(xProcess == 3) {
                System.out.println();
                // number of purchased tickets  // % of purchased %2f  // current income
                calcStatic(cinema,rowP,seatP);
                // total income
                System.out.println("Total income: $"+totalIncome(row,seat));
                System.out.println();
            } else if(xProcess == 0){
                return;
            }


        }
    }
    public static void calcStatic(String[][] cinema,int rowP,int seatP){
        int totalSellUp=0;
        int totalSellDown=0;
        int totalSellUpDown=0;
        int totalSell;
        float totalPresent;
        int currentIncome=0;
        int price1=10;
        int price2=8;
        int halfSeat =(rowP - 1) / 2;
        int totalSeat =(rowP - 1) * (seatP - 1);

        for (int i=1;i< rowP;i++) {
            for (int j = 1; j < seatP; j++) {

                 if(cinema[i][j].equals("B")){

                     if (totalSeat<60){
                         totalSellUpDown++;
                     } else if(totalSeat>60){

                         if(i <= halfSeat){
                             // first half
                             totalSellUp++;
                         }else if(i>halfSeat){
                             // second half
                             totalSellDown++;
                         }
                     }

                 }
            }
        }

        if (totalSeat<60){
            currentIncome = totalSellUpDown * price1;
        } else if(totalSeat>60){
            currentIncome = (  (totalSellUp * price1 ) + (totalSellDown * price2 ));

        }
        totalSell=totalSellDown+totalSellUp+totalSellUpDown;


        totalPresent = (float) (totalSell * 100) / (totalSeat);

        System.out.println("Number of purchased tickets: "+ totalSell);
        System.out.printf("Percentage: %.2f",totalPresent);
        System.out.println("%");
        System.out.println("Current income: $" + currentIncome);

    }

    public static int menu(){
        Scanner scan= new Scanner(System.in);
        int x;

        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        do{
            System.out.print("> ");
            x= Integer.parseInt(scan.nextLine());

        }while(x<0 || x>3);
        return x;
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

    public static void sellSeat(String[][] cinema, int row, int seat){
        int rowS;
        int seatS;
        boolean condition;
        do {
            rowS = readRowSell();
            seatS = readSeatSell();
            condition=false;
            if (rowS >row || seatS>seat){
                System.out.println("Wrong input!");
                condition=true;
                System.out.println();
            } else if (cinema[rowS][seatS].equals("B")){
                System.out.println("That ticket has already been purchased!");
                condition=true;
                System.out.println();
            }
        }while(condition);
        cinema[rowS][seatS] = "B";
        ticketPrice(row, seat, rowS, seatS);

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
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter the number of rows:");
            System.out.print("> ");

            row = scan.nextInt();
        }while(row >9 );

        return row;
    }

    public static int readSeat(){
        int seat;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter the number of seats in each row:");
            System.out.print("> ");

            seat = scan.nextInt();
        }while(seat >9 );
        System.out.println();

        return seat;
    }
    public static int readRowSell(){
        int row;
        Scanner scan = new Scanner(System.in);
        //do {
            System.out.println("Enter a row number:");
            System.out.print("> ");

            row = scan.nextInt();
        //}while(row >9 );

        return row;
    }

    public static int readSeatSell(){
        int seat;
        Scanner scan = new Scanner(System.in);
        //do {
            System.out.println("Enter a seat number in that row:");
            System.out.print("> ");

            seat = scan.nextInt();
        //}while(seat >9 );

        return seat;
    }

    public static int totalIncome(int row, int seat ){
        int price1=10;
        int price2=8;
        int firstHalf=row/2;
        int seatTotal= row*seat;
        int totalIncome;

        if(seatTotal<60){
            totalIncome=(price1*seatTotal);
        } else{
            totalIncome=( ( firstHalf * seat * price1 ) + ( ( row - firstHalf) * seat * price2 ) ) ;

        }
        return totalIncome;
    }
}