import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class inventarioTienda {
    /*declaracion invetario*/
    private static Map<String, Integer> inventario = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú
        do {
            System.out.println("Menu:");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Actualizar la cantidad del producto");
            System.out.println("3. Eliminar el producto");
            System.out.println("4. Mostrar el inventario");
            System.out.println("5. Salir");
            System.out.println("Señor Usuario, Seleccione una opcion:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    actualizarCantidad(scanner);
                    break;
                case 3:
                    eliminarProducto(scanner);
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    System.out.println("Salio del Programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta, intente otra vez");
            }
        } while (opcion != 5);

        scanner.close();
    }

    /*agrega producto*/
    private static void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad inicial: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
        if (inventario.containsKey(nombre)) {
            System.out.println("El producto ya existe. Use la opción de actualizar cantidad.");
        } else {
            inventario.put(nombre, cantidad);
            System.out.println("Producto agregado exitosamente.");
        }
        mostrarInventario();
    }

   /*actualiza el producto*/
    private static void actualizarCantidad(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        if (inventario.containsKey(nombre)) {
            System.out.print("Ingrese la nueva cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer
            inventario.put(nombre, cantidad);
            System.out.println("Cantidad actualizada exitosamente.");
        } else {
            System.out.println("El producto no existe.");
        }
        mostrarInventario();
    }

  /*elimina el producto*/
    private static void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        if (inventario.containsKey(nombre)) {
            inventario.remove(nombre);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("El producto no existe.");
        }
        mostrarInventario();
    }

/*muestrar el inventario*/
    private static void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario:");
            for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
                System.out.println("Producto: " + entry.getKey() + ", Cantidad: " + entry.getValue());
            }
        }
    }
}



