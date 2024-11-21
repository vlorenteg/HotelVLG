package es.studium.jdbc;

public class TestHotelVLG {

    public static void main(String[] args) {
        // Llama a los métodos que quieres usar, comentando los que no necesites
        //crearClientes(); 
        //leerClientes();
        //actualizarCliente();
        eliminarCliente();
    }

    public static void crearClientes() {
        // Crea los clientes con los campos correspondientes
        int id1 = ClientePersistenciaVLG.crearCliente("Valentín", "Lorente", "valentin@gmail.com", "25478963A", "clave123");
        int id2 = ClientePersistenciaVLG.crearCliente("Ana", "García", "ana@gmail.com", "14523698B", "clave456");
        int id3 = ClientePersistenciaVLG.crearCliente("Luis", "Martínez", "luis@gmail.com", "28975463C", "clave789");
        
        System.out.println("Clientes creados con ID: " + id1 + ", " + id2 + ", " + id3);
    }


    // Método para leer clientes
    public static void leerClientes() {
        int id1 = 1; // Reemplaza con el ID real si es necesario
        int id2 = 2; // Reemplaza con el ID real si es necesario
        int id3 = 3; // Reemplaza con el ID real si es necesario

        //Muestra por consola los clientes
        System.out.println("Cliente 1: " + ClientePersistenciaVLG.leerCliente(id1, "nombre"));
        System.out.println("Cliente 2: " + ClientePersistenciaVLG.leerCliente(id2, "nombre"));
        System.out.println("Cliente 3: " + ClientePersistenciaVLG.leerCliente(id3, "nombre"));
    }

    // Método para actualizar un cliente
    public static void actualizarCliente() {
        int id1 = 1; // Reemplaza con el ID real si es necesario

        boolean actualizado = ClientePersistenciaVLG.actualizarCliente(id1, "email", "nuevo_email@example.com");
        System.out.println("Actualización cliente 1: " + actualizado);
    }


    // Método para eliminar un cliente
    public static void eliminarCliente() {
        int id3 = 3; // Reemplaza con el ID real si es necesario
        boolean eliminado = ClientePersistenciaVLG.eliminarCliente(id3);
        System.out.println("Eliminación cliente 3: " + eliminado);
    }
}


