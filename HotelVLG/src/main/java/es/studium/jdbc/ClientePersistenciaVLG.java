package es.studium.jdbc;

import java.sql.*;

public class ClientePersistenciaVLG {
	// Conecta con la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/hotelVLG";
    private static final String USER = "root";
    private static final String PASSWORD = "Studium2023;";

    public static int crearCliente(String nombre, String apellidos, String email, String dni, String clave) {
    	// Prepara una sentencia sql para insertar datos en la tabla
        String sql = "INSERT INTO clienteVLG (nombre, apellidos, email, dni, clave) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); // Establece conexión con la base de datos con las credenciales 
        	// Prepara una sentencia sql para la inserción. Permite recuperar claves generadas automaticamente como el ID
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	// Establece los parámetros de la sentencia sql 
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, email);
            stmt.setString(4, dni);
            stmt.setString(5, clave);
            stmt.executeUpdate(); // Ejecuta la sentencia

            // Recupera el ID y lo guarda en id
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Error al crear
    }    

    public static String leerCliente(int idCliente, String campo) {
        String sql = "SELECT * FROM clienteVLG WHERE idCliente = ?"; // Consulta a la BD la información de un cliente
        // Establece conexión
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery(); // Ejecuta la consulta
            if (rs.next()) {
                return rs.getString(campo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Error al leer
    }


    public static boolean actualizarCliente(int idCliente, String campo, String nuevoValor) {
        String sql = "UPDATE clienteVLG SET " + campo + " = ? WHERE idCliente = ?"; // Actualiza un campo de un cliente dado su ID
        // Establece conexión
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	// Establecen los nuevo campos y se ejecuta
            stmt.setString(1, nuevoValor);
            stmt.setInt(2, idCliente);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Error al actualizar
    }

    public static boolean eliminarCliente(int idCliente) {
        String sql = "DELETE FROM clienteVLG WHERE idCliente = ?"; // Elimina un cliente
        // Establece conexión
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	// Establece el parámetro y ejecuta la sentencia
            stmt.setInt(1, idCliente);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Error al eliminar
    }
}
