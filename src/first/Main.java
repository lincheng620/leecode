package first;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.*;

public class Main {
    public static final String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf8&useSSL=false";
    public static final String user = "root";
    public static final String pass = "123456";
    private static Connection connection = null;
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("***服务器已打开***");

            Socket socket = null;
            Integer count = 0;
            socket = serverSocket.accept();
            DataInputStream inputStream = null;
            DataOutputStream outputStream = null;
            String strInputStream = "";
            inputStream = new DataInputStream(socket.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[2048];
            int n;
            while((n = inputStream.read(bytes)) != -1){
                baos.write(bytes,0,n);
            }
            strInputStream = new String(baos.toByteArray());
            socket.shutdownInput();
            baos.close();

            JSONObject jsonObject = JSONObject.fromObject(strInputStream);
            String username = jsonObject.optString("username");
            String pass = jsonObject.optString("pass");
            System.out.println(jsonObject.toString());

            //Connection connection = DBUtil.connection();
            connection = (Connection) DriverManager.getConnection(url,user,pass);
            String sql = "insert into usertable values(?,?)";
            PreparedStatement ptmt = connection.prepareStatement(sql);
            ptmt.setString(1,username);
            ptmt.setString(2,pass);
            ptmt.execute();

            int port = socket.getPort();
            System.out.println(port);

            Socket socket1 = new Socket("localhost",port);
            OutputStream os = socket1.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("数据已录入数据库");
            pw.flush();
            socket1.shutdownOutput();
            pw.close();
            os.close();
            socket1.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}
