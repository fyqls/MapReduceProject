package mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by qls on 10/13/15.
 */
public class JoinMapper extends Mapper<Object, Text, Text, Text>{


    private static Logger logger= LoggerFactory.getLogger(JoinMapper.class);
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
    ) throws IOException, InterruptedException {
       try {
           InputSplit inputSplit = context.getInputSplit();
           String fileName = ((FileSplit) inputSplit).getPath().toString();
           String tmprowkey = value.toString().split(",")[0];
           String tmpvalue = value.toString().split(",")[1];
           logger.info("================================");
           logger.info("fileName: " + fileName + " key: " + tmprowkey + " value: " + tmpvalue);
           logger.info("===============================");
           word.set(tmprowkey);
           String tmp="";
           if (fileName.contains("aa.txt")) {
               tmp = "aa@" + tmpvalue;
           } else {
               tmp = "bb@" + tmpvalue;
           }
           context.write(word, new Text(tmp));
       }catch(Exception e){
           logger.error(e.getMessage());
           return;
       }
    }

}
