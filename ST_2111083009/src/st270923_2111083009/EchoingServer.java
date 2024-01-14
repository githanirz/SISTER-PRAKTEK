package st270923_2111083009;

 import java.net.*;
 import java.io.*;
 public class EchoingServer {
   public static void main(String [] args) {
      ServerSocket server = null;
      Socket client;
      String tess;
      
      try {
         server = new ServerSocket(1234);
          //1234 is an unused port number
      } catch (IOException ie) {
         System.out.println("Cannot open socket.");
         System.exit(1);
      }
      while(true) {
         try {
            System.out.println("Listening...");
            client = server.accept();               
            OutputStream clientOut = client.getOutputStream();
            PrintWriter pw = new PrintWriter(clientOut, true); 
            InputStream clientIn = client.getInputStream();   
            BufferedReader br = new BufferedReader(new 
                                 InputStreamReader(clientIn));
             tess = br.readLine();
                System.out.println(tess);
                pw.println(tess);
         } catch (IOException ie) {
         }
      }
   }
 }