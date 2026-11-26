/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author so06
 */
public class Conexion {

    /**
     * @param args the command line arguments
    */
         // 1. Las variables globales deben ir fuera del main
    private static final String URL = "jdbc:postgresql://localhost:5432/BDControlBiblioteca";
    private static final String USUARIO = "Alvaro";
    private static final String PASSWORD = "Segura";
    // 2. El método conectar debe ser un miembro directo de la clase, no estar dentro de otro método
    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("¡Conexión exitosa a PostgreSQL!");
            Statement s=conexion.createStatement();
            s.executeUpdate("insert into alumno values ('202406','alvaro');");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}
