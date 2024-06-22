package task3;

import java.util.HashMap;
import java.util.Scanner;

public class Atm {
    HashMap <Integer,User> map ;
    User guest;
    int id;
    Scanner in ;
    public void start(){

        System.out.print("Enter User Id : ");
        while(guest == null){
            id = Integer.parseInt(in.nextLine());
            guest = map.get(id);
            if(guest == null){
                System.out.print("Enter Valid Id : ");
            }

        }
        System.out.print("Enter User pin : ");
        int pin = Integer.parseInt(in.nextLine());
        while (pin != guest.pin) {
            System.out.print("Wrong Pin Try Again : ");
            pin = Integer.parseInt(in.nextLine());
            
        }
        options();     
    }
    public void options(){
        System.out.println("Enter A For Withdrawal");
        System.out.println("Enter B For Depositing");
        System.out.println("Enter C for Checking Balance");
        System.out.println("Enter E for Exit");
        
        System.out.print("Input : ");
        String s = in.nextLine();
        s = s.toUpperCase();
        while(!s.equals("A") && !s.equals("B") && !s.equals("E") && !s.equals("C") ){
            System.out.print("Enter Valid Input : ");
            s = in.nextLine();
        }
        switch (s) {
            case "E":
                System.exit(0);
            case "A":
                withdraw();
                break;
        
            case "B":
                deposit();
                break;
            case "C":
                checkBalance();
                break;
        }
        System.out.println("Enter R For Another Operation");
        System.out.println("Enter U For New Users Menu");
        System.out.println("Enter E for Exit");
        System.out.print("Input : ");
        String h = in.nextLine();
        h = h.toUpperCase();
        while(!h.equals("R") && !h.equals("U") && !h.equals("E") ){
            System.out.print("Enter Valid Input : ");
            h = in.nextLine();
        }
        switch (h) {
            case "E":
                System.exit(0);
            case "R":
                options();;
                break;
        
            case "U":
                guest = null;
                start();;
                break;

        }

    }
    public void deposit (){
        System.out.print("Enter Amount to deposit : ");
        int amount;
        while(true){
            try{
                amount = Integer.parseInt(in.nextLine());
                if(amount > 0){
                    break;
                }else{
                    System.out.print("Enter Valid Input : ");
                }
            }catch(Exception e){
                System.out.print("Enter Valid Input : ");
            }    
        }
        guest.balance+= amount;
        System.out.println("Successful Operation");
        map.put(id, guest);

    }
    public void withdraw (){
        checkBalance();
        System.out.print("Enter Amount to Withdraw : ");
        int amount;
        while(true){
            try{
                amount = Integer.parseInt(in.nextLine());
                if(amount > 0 && amount <= guest.balance){
                    break;
                }else{
                    System.out.print("Enter Valid Value : ");
                }
            }catch(Exception e){
                System.out.print("Enter Valid Input : ");
            }    
        }
        guest.balance-= amount;
        System.out.println("Successful Operation");
        map.put(id, guest);

    }
    public void checkBalance(){
        System.out.println("Your Balance is : " + guest.balance);

    }
    public Atm(){
        map = new HashMap<>();
        in = new Scanner(System.in);
        User Aseel = new User();
        Aseel.id = 1001;
        Aseel.pin = 1234;
        Aseel.balance = 4000000;
        User Zain = new User();
        Zain.id = 1002;
        Zain.pin = 1234;
        Zain.balance = 20000;
        User Peter = new User();
        Peter.id = 1003;
        Peter.pin = 1234;
        Peter.balance = 55000;
        map.put(1001,Aseel);
        map.put(1002,Zain);
        map.put(1003,Peter);

    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.start();
    }



}
