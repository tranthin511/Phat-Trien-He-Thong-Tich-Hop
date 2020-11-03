import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import com.rmi.IFlight;

public class Client {
    public static void main(String args[]) {
        try {
            IFlight iFlight = (IFlight) Naming.lookup("rmi://localhost:2007/in4RMI");
            System.out.println("Connect Success!!!");
            System.out.println(iFlight.Display(0));
            String[] id = iFlight.DataId();
            for (int i = 0; i < id.length; i++) {
            	System.out.println((i+1)+">\tIdFlight: "+id[i]+"\t\tFrom: "+iFlight.getFlight(id[i]).getFrom()+"\t\tTo: "+iFlight.getFlight(id[i]).getTo()+"\t\tDate: "+iFlight.getFlight(id[i]).getDate());
			}
        	while(true){
        		System.out.print(">>>");
        		Scanner scan= new Scanner(System.in);
    			String text = scan.nextLine();
    			//
    			if(text.matches("[0-9]+")) { // [0-9]+ or \\d+
    				int x = Integer.parseInt(text);
    				//
    				if(x <= id.length && x > 0) {
    					System.out.println(iFlight.Display(1));
    					System.out.println("ID :\t"+iFlight.getFlight(id[x-1]).getId());
    					System.out.println("From : "+iFlight.getFlight(id[x-1]).getFrom()+"\t====>\tTo :"+iFlight.getFlight(id[x-1]).getTo());
    					System.out.println("Date :\t"+iFlight.getFlight(id[x-1]).getDate());
    					System.out.println("Total number of tickets :\t"+iFlight.getFlight(id[x-1]).getTotal());
    					System.out.println("Tickets sold : "+iFlight.getFlight(id[x-1]).getOdered()+"\t<----->\t Tickets not yet sold :"+(iFlight.getFlight(id[x-1]).getTotal()-iFlight.getFlight(id[x-1]).getOdered()));
    					//---details---pay---order
    					do {
    						int sold = iFlight.getFlight(id[x-1]).getOdered();
    						int total = iFlight.getFlight(id[x-1]).getTotal();
    						System.out.print(">>>");
    						Scanner scan1 = new Scanner(System.in);
    						String txt = scan1.nextLine();
    						if(txt.matches("[0-9]+")) {
    							int x1 = Integer.parseInt(txt);
    							switch(x1) {
    							case 1:{
    								if(sold >= total) {
        								System.out.println("Tickets are over");
        								scan1.nextLine();
        							}else {
        								while(true) {
        									System.out.println(" Input -> cancel to exit");3
        									System.out.print(" Number of Tickets =");
            								scan1 = new Scanner(System.in);
            								String od = scan1.nextLine();
            								//
            								if(od.matches("[0-9]+")){
            									int x2 = Integer.parseInt(od);
            									if(sold+x2 < total) {
            										System.out.print("Username : ");
                									String u = scan1.nextLine();
                									System.out.print("Password : ");
                									String p = scan1.nextLine();
                									System.out.println(iFlight.Order(id[x-1], x2,u,p));
                									scan1.nextLine();
                									break;
            									}else System.out.println("Not enough Ticket");
            								}else if(od.equalsIgnoreCase("cancel")) { break; }
            								else System.out.println("Input is not true");
            								//
        								}
        							}
        							//---return home
        							System.out.println(iFlight.Display(0));
        							for (int i = 0; i < id.length; i++) {
        				            	System.out.println((i+1)+">\tIdFlight: "+id[i]+"\t\tFrom: "+iFlight.getFlight(id[i]).getFrom()+"\t\tTo: "+iFlight.getFlight(id[i]).getTo()+"\t\tDate: "+iFlight.getFlight(id[i]).getDate());
        							}
        							break;
    							}
    							case 2:{
    								//
        							if(sold == 0) {
        								System.out.println("Tickets no data");
        								scan1.nextLine();
        							}else {
        								while(true) {
        									System.out.println(" Input -> cancel to exit");
        									System.out.print(" Number of Tickets = ");
            								scan1 = new Scanner(System.in);
            								String od = scan1.nextLine();
            								//
            								if(od.matches("[0-9]+")){
            									int x2 = Integer.parseInt(od);
            									if(x2 < sold) {
            										System.out.print("Username : ");
                									String u = scan1.nextLine();
                									System.out.print("Password : ");
                									String p = scan1.nextLine();
                									System.out.println(iFlight.Pay(id[x-1], x2,u,p));
                									scan1.nextLine();
                									break;
            									}else System.out.println("Not enough ticket");
            								}else if(od.equalsIgnoreCase("cancel")) { break; }
            								else System.out.println("Input is not true");
            								//
        								}
        							}
        							//---return display
        							System.out.println(iFlight.Display(0));
        							for (int i = 0; i < id.length; i++) {
        				            	System.out.println((i+1)+">\tIdFlight: "+id[i]+"\t\tFrom: "+iFlight.getFlight(id[i]).getFrom()+"\t\tTo: "+iFlight.getFlight(id[i]).getTo()+"\t\tDate: "+iFlight.getFlight(id[i]).getDate());
        							}
        							break;
    							}
    							case 3:{
    								System.out.println(iFlight.Display(0));
        							for (int i = 0; i < id.length; i++) {
        				            	System.out.println((i+1)+">\tIdFlight: "+id[i]+"\t\tFrom: "+iFlight.getFlight(id[i]).getFrom()+"\t\tTo: "+iFlight.getFlight(id[i]).getTo()+"\t\tDate: "+iFlight.getFlight(id[i]).getDate());
        							}
        							break;
    							}
    							default:{
    								System.out.println("Input data errol!!!");
    								break;
    							}
    						}
    							break;
    						}else System.out.println("Input data errol!!!");
    					}while(true);	
    				//
    				}else System.out.println("Input number not true !!!");
    				//
    				
    			}else if(text.equalsIgnoreCase("exit")) break;
    					else System.out.println("Input data errol!!! Input must is number");
    			//
        	}
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
