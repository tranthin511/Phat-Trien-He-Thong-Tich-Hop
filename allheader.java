import java.net.*;
import java.io.*;
public class allheader {
 public static void main(String args[]) {
 
 try {
 URL u = new URL("http://iuh.edu.vn");
 URLConnection uc = u.openConnection( );
 for (int j = 1; ; j++) {
 String header = uc.getHeaderField(j);
 if (header == null) break;
 System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
 }
 }
 catch (MalformedURLException ex) {
 }
 catch (IOException ex) {
 System.err.println(ex);
 }
 System.out.println( );
 }
 }
