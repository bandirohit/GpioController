package rohit.clienttest;

/**
 * Created by Rohit on 09-11-2016.
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
import android.widget.TextView;

public class Client extends AsyncTask<Void, Void, Void>
{

    String dstAddress;
    int dstPort;
    String response = "";
    //TextView textResponse;

    Client(String addr, int port) {
        dstAddress = addr;
        dstPort = port;
        //this.textResponse = textResponse;
    }

    @Override
    protected Void doInBackground(Void... arg0)
    {

        Socket socket = null;
        try {
            socket = new Socket(dstAddress, dstPort);

            OutputStream outstream = socket .getOutputStream();
            PrintWriter out = new PrintWriter(outstream);
            String toSend = "Rohit is here";
            out.print(toSend);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        //textResponse.setText(response);
        super.onPostExecute(result);
    }
}