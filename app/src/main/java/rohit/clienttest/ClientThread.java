package rohit.clienttest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Rohit on 09-11-2016.
 */

public class ClientThread implements Runnable
{
    public String serverAddress = "192.168.0.19";
    public int serverPort = 12555;
    public Socket socket;
    public String msg;
    @Override
    public void run()
    {
        try {
            socket = new Socket(serverAddress, serverPort);
            if(socket.isConnected())
            {
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                out.println(msg);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
