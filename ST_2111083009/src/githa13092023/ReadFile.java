/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githa13092023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        System.out.println("Nama File");
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        filename = br.readLine();
        System.out.println("Now Reading from " + filename + " ");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found. ");
        }
        try {
            char data;
            int temp;
        do {
            temp = fis.read();
            data = (char) temp;
            if (temp != -1){
                System.out.print(data);
                System.out.print(temp);
            }
        }while (temp != -1);
        } catch (IOException ex){
             System.out.println("Problem in reading from the file. ");
        }
    }
}
