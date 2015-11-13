package lisong.qiu;

import mapper.JoinMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import reduce.JoinReducer;

/**
 * Created by qls on 10/13/15.
 */
public class MapJoin {


    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        if (args.length != 2) {
            System.err.println("Usage: joinTest <in> <out>");
            System.exit(2);
        }
        Job job = new Job(conf, "join test");
        job.setJarByClass(MapJoin.class);
        job.setMapperClass(JoinMapper.class);
        job.setReducerClass(JoinReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
      }
}
