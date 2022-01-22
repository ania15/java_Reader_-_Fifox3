package Reader;

import java.io.IOException;

import static Reader.Reader.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try{
            int x=Reader.readInt();
            System.out.println("Wczytany int: " + x);
        }catch(IOException ex){
            throw new IOException("Error reading int");
        }

        try{
            double y=Reader.readDouble();
            System.out.println("Wczytany double: " + y);
        }catch(IOException ex){
            throw new IOException("Error reading double");
        }

        try{
            double z=Reader.readHex();
            System.out.println("Wczytana liczba hex: " + z);
        }catch(IOException ex){
            throw new IOException("Error reading hex");
        }
    }
}
/*
/**
 * Reader class  @zdz
 * class contains metdhods to read characters, int-s, double-s and hexadecimal values
 * All functions reads characters and calculates the proper values
 */

