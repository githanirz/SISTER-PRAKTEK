package githani04102023;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class MulticastChatServer {
    private static final String address = "211.0.0.1";
    private static final int port = 123456;
    private static final int max_user = 10;
    
    private static Map<String, InetAddress> users = new HashMap<>();
    
    public static void main(String[] args) throws UnknownHostException, IOException{
        InetAddress group = InetAddress.getByName(address);
        MulticastSocket multicashSocket = new MulticastSocket(port);
        multicashSocket.joinGroup(group);
        System.out.println("Multicash chat server running...");
        while (true) {            
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            multicashSocket.receive(packet);
            
            String message = new String(packet.getData(),0,packet.getLength());
            String[] parts = message.split(": ",2);
            if(parts.length==2){
                String username = parts[0].trim();
                String content = parts[1].trim();
                if(!users.containsKey(username)){
                    if(users.size()>=max_user){
                        System.out.println("User penuh. "+username+" tidak bisa masuk");
                        continue;
                    }
                    users.put(username, packet.getAddress());
                    System.out.println(username+"Join");
                }
                for (Map.Entry<String, InetAddress> entry : users.entrySet()) {
                    if(!entry.getKey().equals(username)){
                        InetAddress userAddress;
                        userAddress = entry.getValue();
                    }
                    
                }
                
            }
        }
    }

}