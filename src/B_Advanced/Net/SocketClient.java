package B_Advanced.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 客户端
public class SocketClient {
    /*
    * TcpNoDelay
    *   Nagle算法：客户端向服务器发送数据时，如果数据量很小 会等待和后面的大包合并后一起发出。并且需要等到服务端响应后再发出下一个。
    *   这种算法虽然可以有效地改善网络传输的效率，但对于网络速度比较慢，而且对实现性的要求比较高的情况下（如游戏、Telnet等），使用这种方式传输数据会使得客户端有明显的停顿现象。
    *   Nagle算法是开启的，使用setTcpNoDelay（true）将Nagle算法关闭
    *
    * SoLinger 延迟关闭
    *   期间系统将尽量将未送出的数据包发送出去
    *   if(socket.getSoLinger() == -1)
    *       socket.setSoLinger(true, 60)
    * SoTimeout 设置超时
    *   等待了timeout毫秒后会抛出一个InterruptedIOException例外
    *   socket1.setSoTimeout(30 * 1000);
    * */
    public static void main(String[] arg){
        BufferedReader br = null;
        PrintWriter pw = null;
        try{
            Socket socket = new Socket("localhost", 99);
            // 获取输入流与输出流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));//InputStreamReader第二个参数可选填，默认为GBK
            pw = new PrintWriter(socket.getOutputStream(),true);

            // 向服务器发送数据
            pw.println("你好!");

            // 接收服务器发回的消息
            String str = null;
            while(true){    //如果接收到的消息为空（没有接收到消息），则继续此循环
                str = br.readLine();
                if(str!=null) break; //如果接收到的消息不为空（接收到了消息），则跳出此循环
            }
            System.out.println(str);

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                if (br != null) {
                    br.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
