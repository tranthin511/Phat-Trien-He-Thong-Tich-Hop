import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server1{	
	public static String ReadNum(String x) {
		String rd;
		if(x.matches("[0-9]+")){
			int n = Integer.parseInt(x);
			if(n <= 100) {
				String chuc = "",dv = "";
				int mod = n%10;
				int div = n/10;
				switch(div) {
					case 2:{ dv = "hai"; break; }
					case 3:{ dv = "ba"; break; }
					case 4:{ dv = "bốn"; break; }
					case 5:{ dv = "năm"; break; }
					case 6:{ dv = "sáu"; break; }
					case 7:{ dv = "bảy"; break; }
					case 8:{ dv = "tám"; break; }
					case 9:{ dv = "chín"; break; }
				}
				switch(mod) {
					case 1:{ chuc = "mốt"; break; }
					case 2:{ chuc = "hai"; break; }
					case 3:{ chuc = "ba"; break; }
					case 4:{ chuc = "bốn"; break; }
					case 5:{ chuc = "lăm"; break; }
					case 6:{ chuc = "sáu"; break; }
					case 7:{ chuc = "bảy"; break; }
					case 8:{ chuc = "tám"; break; }
					case 9:{ chuc = "chín"; break; }		
				}
				if(n < 10) {
					if(n == 0) {rd = "không";}
					else if(n == 5) {rd = "năm";}
					else {rd = chuc;}
				}
				else {
					if(n == 10) rd = "mười";
					else if(n == 100) rd = "một trăm";
					else
					rd = dv + " mươi " + chuc;
				}
			}
			else {
				rd = "Dữ liệu là số dưới 100";
			}
		}
		else {
			rd = "Không phải là số";
		}
		return rd;
	}
	public static void main(String[] args){
		try {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(9540);
		System.out.println("Server da duoc tao");
		Socket client = server.accept();
		System.out.println("Client da ket noi den server");
		Scanner inFromClient = new Scanner(client.getInputStream());
		PrintStream outToClient = new PrintStream(client.getOutputStream());
		outToClient.println("Nhap so :");
		String txt = inFromClient.nextLine();
		outToClient.println("Result : " + ReadNum(txt));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
}