package F_Request;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Request {
    public static void main(String[] args) throws Exception{
         URL url = new URL("https://www.baidu.com?wd=try");
//         URLConnection conn = url.openConnection();
//         // is 字节流
//         InputStream is = conn.getInputStream();

        InputStream is = url.openStream();
         // bf 缓冲流
         BufferedReader bf = new BufferedReader(new InputStreamReader(is));

         String result = bf.readLine();
         System.out.println(result);

         for(int i =1;i>0;i++){

             result = bf.readLine();
             if(result==null){
                 break;
             }
             System.out.println(result);
         }
    }
}