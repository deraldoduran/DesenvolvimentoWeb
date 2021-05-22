import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main (String args[]) {
        // arguments supply message and hostname of destination
        Socket s = null;
        try{
            int serverPort = 7896;
            s = new Socket("localhost", serverPort);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out = new DataOutputStream( s.getOutputStream());
            // Envio da mensagem ao Server - Socket (ip, porta)
            out.writeUTF("[Cliente] 'Olá mundo!'"); // UTF is a string encoding
            // Retorno da mensagem enviada ao Server
            String data = in.readUTF();
            //Imprime no Cliente a mensagem recebida
            System.out.println("Received: " + data);
        } catch (UnknownHostException e){
            System.out.println("Sock:" + e.getMessage());
        } catch (EOFException e){
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e){
            System.out.println("IO:" + e.getMessage());
        } finally {
            if(s != null)
            try {
                s.close();
            } catch (IOException e){
                System.out.println("close:" + e.getMessage());
            }
        }
    }
}
