package main;

import model.Localizacion;
import model.Origen;
import model.Personaje;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import model.Personajes;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class UtilidadesAPI {
    private static Personajes personajes = new Personajes();
    public static void MostrarAPI() {
        try {
            String next = "https://rickandmortyapi.com/api/character";
            for (int j = 0; j < 5; j++) {
                URL api = new URL(next);
                HttpURLConnection ur1C = (HttpURLConnection) api.openConnection();
                InputStream inputStream = ur1C.getInputStream();
                BufferedInputStream reader = new BufferedInputStream(inputStream);
                int readerBuffer = reader.read();
                String myJson = "";
                while(readerBuffer != -1){
                    char u = (char) readerBuffer;
                    myJson += u;
                    readerBuffer = reader.read();
                }

                reader.close();
                inputStream.close();

                //Cambiar json -> gson (AUNQUE NO HACE FALTA) 
                JsonParser json = new JsonParser();
                JsonObject jsonObj = json.parse(myJson).getAsJsonObject();

                JsonObject informacion = jsonObj.getAsJsonObject("info");
                if(!informacion.get("next").isJsonNull()) {
                    next = informacion.get("next").getAsString();
                } else {
                    next = null;
                }

                JsonArray results = jsonObj.getAsJsonArray("results");
                
                for (int i = 0; i < results.size(); i++) {
                    JsonObject characterObject = results.get(i).getAsJsonObject();

                    int id = characterObject.get("id").getAsInt();
                    String name = characterObject.get("name").getAsString();
                    String status = characterObject.get("status").getAsString();
                    String specie = characterObject.get("species").getAsString();
                    String type = characterObject.get("type").getAsString();
                    String gender = characterObject.get("gender").getAsString();
                    String image = characterObject.get("image").getAsString();

                    JsonObject originObject = characterObject.getAsJsonObject("origin");
                    String nameOrigen = originObject.get("name").getAsString();
                    String urlOrigen = originObject.get("url").getAsString();

                    JsonObject locationObject = characterObject.getAsJsonObject("location");
                    String nameLocation = locationObject.get("name").getAsString();
                    String urlLocation = locationObject.get("url").getAsString();

                    Origen origin = new Origen(nameOrigen, urlOrigen);
                    Localizacion location = new Localizacion(nameLocation, urlLocation);

                    Personaje personaje = new Personaje(id, name, status, specie, type, gender, image, origin, location);
                    personajes.addPersonaje(personaje);
                }
            }
        } catch(MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch(IOException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void generarArchivo(Personajes personajes) throws IOException {
        FileOutputStream arquivo = new FileOutputStream("personajes.dat");
        ObjectOutputStream saida = new ObjectOutputStream(arquivo);
        saida.writeObject(personajes);
        
    }
    
    public static void leerArchivo() throws  ClassNotFoundException, IOException{
        FileInputStream arquivo = new FileInputStream("personajes.dat");
        ObjectInputStream entrada = new ObjectInputStream(arquivo);
        Personajes personaje = (Personajes) entrada.readObject();
        for(Personaje p : personaje.getPersonajes()){
            System.out.println(p.getId());
        }
    }
    
    public static Personajes existeArchivo() throws IOException, ClassNotFoundException {
        File file = new File("personajes.dat");
        if(file.exists()) {
            leerArchivo();
            return personajes;
        } else {
            generarArchivo(personajes);
            System.out.println("Archivo creado con exito");
        }
        return personajes;
    }
}