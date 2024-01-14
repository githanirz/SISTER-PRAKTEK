/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githani11102023;

/**
 *
 * @author Asus
 */
public class Enkrip2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         String text = "Selamat Datang";
         String temp = "";
        int key = 20;
        for (int i=0;i<text.length();i++){
            int h = (int) (text.charAt(i));
            char t = (char) (h ^ key);
            temp += t;
//            System.out.println(h);
            }
            System.out.println("Sebelum : " + text);
            
            System.out.println("Hasil : " + temp);
            
    }
    
}
