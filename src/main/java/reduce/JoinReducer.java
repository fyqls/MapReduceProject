package reduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qls on 10/13/15.
 */
public class JoinReducer  extends Reducer<Text,Text,Text,Text> {

    private static Logger logger= LoggerFactory.getLogger(JoinReducer.class);
    private static final Text result =new Text();

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        List<String> list1 =new ArrayList<String>();
        List<String> list2 =new ArrayList<String>();
      try{
        for (Text val : values) {
            logger.info("*************************");
            logger.info("qls:   "+key.toString() + " : " + val.toString());
            logger.info("*************************");
           if(val.toString().startsWith("aa@")){
               list1.add(val.toString().substring(3));
           }else{
               list2.add(val.toString().substring(3));
           }
        }
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++) {
                String tmp = key.toString() +","+ list1.get(i)+","+list2.get(j);
                context.write(new Text(), new Text(tmp));
            }
        }
      }catch(Exception e){
          e.printStackTrace();
          logger.error(e.getMessage());
      }
    }
}
