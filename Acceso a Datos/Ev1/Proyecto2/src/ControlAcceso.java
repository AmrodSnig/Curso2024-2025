import java.sql.*;

public class ControlAcceso {
    private static Connection conexion;

    public static Connection ControlAcceso() throws SQLException {
        String user = "root";
        String pass = "3menos1dos"; //abc123.  //3menos1dos
        String url = "jdbc:mysql://localhost/productos";
        conexion = DriverManager.getConnection(url, user, pass);
        return conexion;
    }

    public static void agregarCategoriaBaseDatos(String nombre) throws SQLException {
        String query = "INSERT INTO categorias (nombre_categoria) VALUES (?)";
        try (PreparedStatement preparado = ControlAcceso().prepareStatement(query)){
            preparado.setString(1, nombre);
            preparado.execute();
        }
    }

    public static void eliminarUsuario(int id) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id_usuario = (?)";
        try (PreparedStatement preparado = conexion.prepareStatement(query)) {
            preparado.setInt(1, id);
            preparado.execute();
            System.out.println("Usuario'" + id + "' eliminado con éxito.");
        }
    }


    public static void listarProductosBajoStock(int stock) throws SQLException {
        String query = "SELECT nombre FROM productos WHERE stock < (?)";
        try (PreparedStatement preparado = conexion.prepareStatement(query)) {
            preparado.setInt(1, stock);
            ResultSet resultado = preparado.executeQuery();
            System.out.println("Productos en stock:");
            while (resultado.next()) {
                System.out.println("-" + resultado.getString("nombre"));
            }
        }
    }
    public static void obtenerTotalPedidosUsuarios() throws SQLException {
        String query = "SELECT COUNT * AS total FROM pedidos";
        try (Statement preparado = conexion.createStatement(); ResultSet resultado = preparado.executeQuery(query)) {
            if (resultado.next()) {
                System.out.println("Total pedidos: " + resultado.getInt("total"));
            }
        }
    }
}

