package view;

import java.util.Scanner;

public class View {
    private Scanner console;

    public View() {
        console = new Scanner(System.in);
    }

    public void showMessage(String message){
        System.out.println(message);
    }

    public String readString() {
        return console.nextLine();
    }
    public int readInt() {
        return console.nextInt();
    }
    public Double readDouble() {
        return console.nextDouble();
    }

    public Scanner getConsole() {
        return console;
    }
}
