package avro;

import java.io.IOException;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.mapred.AvroKey;
import org.apache.avro.mapred.AvroValue;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTempReducer extends Reducer<AvroKey<String>, AvroValue<GenericRecord>, Text, IntWritable> {
	@Override
	protected void reduce(AvroKey<String> key, Iterable<AvroValue<GenericRecord>> values, Context context) throws IOException, InterruptedException {
		GenericRecord datum=null;
		int maxTemp=Integer.MIN_VALUE;
		for(AvroValue<GenericRecord> value:values) {
			datum=value.datum();
			if(maxTemp<(Integer)datum.get("temp")) {
				maxTemp=(Integer)datum.get("temp");
			}
		}
		context.write(new Text(key.toString()), new IntWritable(maxTemp));
	}
}
