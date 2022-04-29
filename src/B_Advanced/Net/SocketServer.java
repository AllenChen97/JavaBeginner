package B_Advanced.Net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 服务端
public class SocketServer {
    /*
    * backlog 等待队列长度，默认50，-1表示无限
     * */
    public static void main(String[] arg){
        BufferedReader br = null;
        PrintWriter pw = null;
        try{
            ServerSocket serverSocket = new ServerSocket(99);

            // 获取接收的信息
            while (true){
                Socket socket  = serverSocket.accept();
                // 获取输入/输出流
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                pw = new PrintWriter(socket.getOutputStream(),true);

                String str = null;

                // 读取输入流
                str = br.readLine();
                // 发送相同的数据给客户端
                pw.println(str);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (br != null) {
                    br.close();
                }
                if (pw != null) {
                    pw.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
