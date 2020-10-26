

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try{
        Socket socket = new Socket("localhost",1021);
        
       
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        DataInputStream in = new DataInputStream(socket.getInputStream());
        
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.print("\nClient: ");
            out.writeUTF(input.nextLine());
            out.flush();
            
            String str = in.readUTF();
            
            if(str.equalsIgnoreCase("Exit")){
                break;
            }
            else System.out.println("Server said: "+str);
        }
        in.close();
        out.close();
        socket.close();
        } catch(IOException e){
        }
    }
}
