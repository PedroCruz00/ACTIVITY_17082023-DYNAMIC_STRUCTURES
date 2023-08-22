package presenter;

import model.Product;
import model.Shoping;
import view.View;

public class Presenter {

    private View view;
    private Shoping shoping;
    public Presenter() {
        view = new View();
        shoping = new Shoping();
        menu();
    }

    private void menu(){
        while (true) {
            view.showMessage("1. Agregar artículo al carrito");
            view.showMessage("2. Mostrar contenido del carrito");
            view.showMessage("3. Calcular precio total");
            view.showMessage("4. Salir");
            view.showMessage("Seleccione una opción: ");
            int option = view.readInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del artículo: ");
                    view.getConsole().nextLine();
                    String name = view.readString();
                    view.showMessage("Ingrese el precio del artículo: ");
                    double price = view.readDouble();
                    shoping.addProduct(new Product(name, price));
                    view.showMessage("Artículo agregado al carrito.");
                    break;
                case 2:
                    view.showMessage("Contenido del carrito:");
                    for (Product product : shoping.getShoping()) {
                        view.showMessage(product.getName() + " - $" + product.getPrice());
                    }

                    break;
                case 3:
                    view.showMessage("Precio total del carrito: $" + shoping.calculateTotal());
                    break;
                case 4:
                    view.showMessage("¡Gracias por usar el carrito de compra!");
                    view.getConsole().close();
                    System.exit(0);
                default:
                    view.showMessage("Opción no válida.");
            }
        }
    }
    public static void main(String[] args) {
        new Presenter();
    }
}