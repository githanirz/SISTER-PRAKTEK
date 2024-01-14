/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githani04102023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ChatServer {
    private static final int port=12345;
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    
    public static void main(String []args){
        System.out.println("Server Running");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
            new ClientHandler(serverSocket.accept()).start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private static class ClientHandler extends Thread{
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
                
         public ClientHandler(Socket socket){
         this.socket = socket;
         }
          @Override
        public void run(){
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            synchronized(clientWriters){
                clientWriters.add(out);
            }
        }
         private void broadcastMessage(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                    writer.flush();
                }
            }
    }
        
    }
     
}
