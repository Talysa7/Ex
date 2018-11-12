package avro;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class MaxTempAvro {
	public static void main(String[] args) throws Exception {
		if(args.length!=2) {
			System.out.println("How to use : MaxTempCombiner <file route> <output route>");
			System.exit(-1);
		}
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf, "MaxTempCombiner");
		job.setJarByClass(MaxTempAvro.class);
		job.setMapperClass(MaxTempMapper.class);
		job.setCombinerClass(MaxTempReducer.class);
		job.setReducerClass(MaxTempReducer.class);
		//set file directory
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//set input/output data type
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		//set key and value data type
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.waitForCompletion(true);
	}
}
