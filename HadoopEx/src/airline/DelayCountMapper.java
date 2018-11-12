package airline;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//Mapper
public class DelayCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable outputValue=new IntWritable(1);
	private Text outputKey=new Text();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		DelayParser parser=new DelayParser(value);
		//depature delay count by month and year
		//outputKey.set(parser.getYear()+","+parser.getMonth());
		//depature delay count by carrier
		outputKey.set(parser.getUniqueCarrier());
		if(parser.getDepDelayTime()>0) {
			context.write(outputKey, outputValue);
		}
	}
}
