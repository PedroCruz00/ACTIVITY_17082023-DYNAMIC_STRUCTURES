package presenter;

import model.Calculator;
import view.View;

public class Presenter {

    private Calculator calculator;
    private View view;


    public Presenter() {
        view = new View();
        menu();
    }
    private void menu(){
        view.showMessage("Seleccione una opción: ");
        while (true) {
            view.showMessage("1. Calcular expresion: ");
            view.showMessage("2. Salir");
            view.showMessage("Seleccione una opción: ");
            int option = view.readInt();

            switch (option) {
                case 1:
                        view.showMessage("Ingrese una expresion valida");
                        String expression = view.readString();
                    try {
                        calculator = new Calculator(expression);
                        double result = calculator.calculateExpression(calculator.getExpression());
                        view.showMessage("Resultado: " + result);
                    } catch (Exception e) {
                        view.showMessage("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    view.showMessage("¡Gracias por usar nuestra calculadora!");
                    view.getConsole().close();
                    System.exit(0);
                    break;
                default:
                    view.showMessage("Haz ingresado una expresion incorrecta");
            }
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
