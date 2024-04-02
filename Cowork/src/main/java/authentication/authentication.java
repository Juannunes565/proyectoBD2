/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authentication;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 *
 * @author andres
 */
public class authentication {
    
    public static void agregarUsuario(MongoDatabase database, String nombre, String apellido, int cedula,String contraseña) {
        // Obtener referencia a la colección "usuario"
        MongoCollection<Document> usuarioCollection = database.getCollection("users");

        // Crear un nuevo documento para agregar a la colección "usuario"
        Document newUser = new Document("nombre", nombre)
                            .append("apellido", apellido)
                            .append("cedula", cedula)
                            .append("contraseña",contraseña);

        // Insertar el nuevo documento en la colección "usuario"
        usuarioCollection.insertOne(newUser);

        System.out.println("Nuevo usuario agregado exitosamente.");
    }
    
    public static boolean validarCedula(int cedula) {
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://andres:1234@cluster0.6c5y2rf.mongodb.net")) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("users");
            
            // Buscar si existe un documento con la cédula proporcionada
            Document usuario = collection.find(Filters.eq("cedula", cedula)).first();
            
            return usuario != null; // Devolver true si el usuario existe, false si no existe
        } catch (Exception e) {
            System.err.println("Error al validar la cédula: " + e.getMessage());
            return false; // Manejar el error y devolver false
        }
    }
    
    public static boolean validarCredenciales(int cedula, String contraseña) {
    try (MongoClient mongoClient = MongoClients.create("mongodb+srv://andres:1234@cluster0.6c5y2rf.mongodb.net")) {
        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> collection = database.getCollection("users");
        
        // Buscar si existe un documento con la cédula proporcionada
        Document usuario = collection.find(Filters.eq("cedula", cedula)).first();
        
        // Verificar si se encontró un usuario con la cédula proporcionada
        if (usuario != null) {
            // Obtener la contraseña almacenada para el usuario encontrado
            String contrasenaAlmacenada = usuario.getString("contraseña");
            
            // Verificar si la contraseña proporcionada coincide con la contraseña almacenada
            if (contrasenaAlmacenada.equals(contraseña)) {
                return true; // Las credenciales son válidas
            }
        }
        
        return false; // Credenciales no válidas (usuario no encontrado o contraseña incorrecta)
    } catch (Exception e) {
        System.err.println("Error al validar las credenciales: " + e.getMessage());
        return false; // Manejar el error y devolver false
    }
}

    
    
}

    

