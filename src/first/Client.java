package first;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import net.sf.json.JSONObject;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8888);
        OutputStream outputStream = socket.getOutputStream();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","root");
        jsonObject.put("password","123456");
        String string = jsonObject.toString();
        byte[] bytes = string.getBytes();
        outputStream.write(bytes);
        outputStream.flush();
        socket.shutdownInput();
        outputStream.close();
        socket.close();
        int port = socket.getLocalPort();
        System.out.println(port);
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket1 = serverSocket.accept();
        InputStream is = socket1.getInputStream();
        InputStreamReader inr = new InputStreamReader(is);
        BufferedReader bReader = new BufferedReader(inr);
        String data = bReader.readLine();
        while(data != null){
            System.out.println("数据是：" + data);
            data = bReader.readLine();
        }
        socket1.shutdownInput();
        bReader.close();
        inr.close();
        is.close();
        socket1.close();

    }
}
