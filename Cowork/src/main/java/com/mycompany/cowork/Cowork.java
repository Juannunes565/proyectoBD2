/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cowork;
import GUI.Login;
import GUI.Window;
import authentication.authentication;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;


public class Cowork {
    
    public static void main(String[] args) {
                                                        
        String connectionString = "mongodb+srv://user:1234@cluster0.6c5y2rf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
                
        MongoClient client = MongoClients.create(settings);
        new Login(client).setVisible(true);
            
       
        
        
        
//        authentication authentication = new authentication();
//        
//        if(authentication.validarCedula(123456789)){ //aca llamamos al metodo validar cedula para ver si la cedula existe en la coleccion users
//            System.out.println("La cedula existe en la coleccion");
//            authentication.validarCredenciales(123456789,"Coco.123");
//            System.out.println("Inicio de sesion con exito");
//        }else{
//            System.out.println("La cedula no existe en la coleccion "); // si no existe obtenemos la bd que es sample_mflix y llamamos a la funcion agregar usuario
//             try (MongoClient mongoClient = MongoClients.create("mongodb+srv://andres:1234@cluster0.6c5y2rf.mongodb.net")) {
//                MongoDatabase database = mongoClient.getDatabase("sample_mflix");
//                authentication.agregarUsuario(database, "Juan", "Perez", 123456789,"Coco.123");
//            } catch (Exception e) {
//                System.err.println("Error al conectar con la base de datos: " + e.getMessage());
//            }
//            
//        }
        
        
    }
}





