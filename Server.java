

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {

    public static void main(String[] args) {
        try{
        ServerSocket server = new ServerSocket(1021);
        System.out.println("Server da duoc tao");
        Socket socket = server.accept();
        System.out.println("Client da ket noi den server");
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
     
        DataInputStream in = new DataInputStream(socket.getInputStream());

        Scanner input = new Scanner(System.in);

        while (true) {
            String str = in.readUTF();  
            if (str.equalsIgnoreCase("Exit")) {
                break;
            } else {
                System.out.println("Client said: " + str);
            }

            System.out.print("\nServer: ");
            out.writeUTF(input.nextLine()); 
            out.flush(); 
        }
        in.close();
        out.close();
        socket.close();
        server.close();
        
        } catch(IOException e){
        }
    }
}
