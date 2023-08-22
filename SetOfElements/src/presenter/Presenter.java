package presenter;

import model.SetElements;
import view.View;

import java.util.HashSet;
import java.util.Set;

public class Presenter {
    private SetElements setElements;
    private View view;

    public Presenter() {
        this.setElements = new SetElements();
        this.view = new View();
        menu();
    }

    private void menu(){
        view.showMessage("Ingresa la cantidad de elementos en el conjunto: ");
        int n = view.readInt();

        Set<Integer> conjunto = new HashSet<>();

        System.out.println("Ingresa los elementos del conjunto uno por uno:");
        for (int i = 0; i < n; i++) {
            int element = view.readInt();
            conjunto.add(element);
        }
        Set<Set<Integer>> powSet = setElements.generatePowSet(conjunto);

        view.showMessage("Conjunto Potencia:");
        for (Set<Integer> subconjunto : setElements.generatePowSet(conjunto)) {
            view.showMessage(String.valueOf(subconjunto));
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
