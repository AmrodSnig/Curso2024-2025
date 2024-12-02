import javax.naming.ldap.Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Categoria {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

public class SistemaCategorias {
    private List<Categoria> categorias;
    private ControlAcceso controlAcceso;

    public SistemaCategorias() {
        categorias = new ArrayList<>();
    }

    public void crearCategoria(String nombreCategoria) {
        if (nombreCategoria == null || nombreCategoria.isEmpty()) {
            System.out.println("Debes escribir un nombre para la categoría.");
            return;
        }

        Categoria nuevaCategoria = new Categoria(nombreCategoria);
        categorias.add(nuevaCategoria);
        System.out.println("Categoría '" + nombreCategoria + "' creada exitosamente.");
    }

    public void mostrarCategorias() {
        System.out.println("Categorías:");
        for (Categoria categoria : categorias) {
            System.out.println("- " + categoria.getNombre());
        }
    }

    public static void main(String[] args) throws SQLException {
        SistemaCategorias sistema = new SistemaCategorias();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el nombre de la categoría que quieras agregar: ");
        String agreecat = scanner.nextLine();
        ControlAcceso.agregarCategoriaBaseDatos(agreecat);

        System.out.println("Escribe el ID de usuario que quieras eliminar: ");
        int eliminar = Integer.parseInt(scanner.nextLine());
        ControlAcceso.eliminarUsuario(eliminar);

        System.out.println("Pon la cantidad máxima que desees ver de stock: ");
        int stock = Integer.parseInt(scanner.nextLine());
        ControlAcceso.listarProductosBajoStock(stock);

        System.out.println("Pedidos de usuarios.");
        ControlAcceso.obtenerTotalPedidosUsuarios();


        // Crear algunas categorías
        sistema.crearCategoria("Menaje");
        sistema.crearCategoria("Hogar");
        sistema.crearCategoria("Herramientas");

        // Mostrar las categorías creadas
        sistema.mostrarCategorias();

    }
}