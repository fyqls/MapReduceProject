package lisong.qiu;

import org.apache.hadoop.io.Text;

/**
 * Created by qls on 10/13/15.
 */
public class Test {
     public static void main(String[] args){
        System.out.println("aa@adfjas".substring(2));

         String fileName= "hdfs://service/tmp/mrtest/join/aa.txt";
         String tmprowkey="1";
         String tmpvalue ="aa";
         if(fileName.contains("aa.txt")){
             String tmp="aa@"+tmpvalue;
             System.out.println(new Text(tmprowkey));
             System.out.println(new Text(tmp));
         }else{
             String tmp="bb@"+tmpvalue;
             System.out.println(new Text(tmprowkey));
             System.out.println(new Text(tmp));
         }
     }
}
