package avro;

import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.mapred.AvroKey;
import org.apache.avro.mapred.AvroValue;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTempMapper extends Mapper<LongWritable, Text, AvroKey<String>, AvroValue<GenericRecord>> {
	private static final int MISSING=9999;
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		Schema schema=new Schema.Parser().parse(
		      "{" +
		      "  \"type\": \"record\"," +
		      "  \"name\": \"WeatherRecord\"," +
		      "  \"doc\": \"A weather reading.\"," +
		      "  \"fields\": [" +
		      "    {\"name\": \"year\", \"type\": \"int\"}," +
		      "    {\"name\": \"temperature\", \"type\": \"int\"}," +
		      "    {\"name\": \"stationId\", \"type\": \"string\"}" +
		      "  ]" +
		      "}"
			);
		GenericRecord datum=new GenericData.Record(schema);
		
		String line=value.toString();
		String year=line.substring(15, 19);
		String stationId=line.substring(4, 10)+"-"+line.substring(10, 15);
		int temp;
		if(line.charAt(87)=='+') {
			temp=Integer.parseInt(line.substring(88, 92));
		} else {
			temp=Integer.parseInt(line.substring(87, 92));
		}
		String quality=line.substring(92, 93);
		if(temp!=MISSING && quality.matches("[01459]")) {
			//context.write(new Text(year), new IntWritable(temp));
			datum.put("year", year);
			datum.put("temp", temp);
			datum.put("stationId", stationId);
			context.write(new AvroKey<String>(year), new AvroValue<GenericRecord>(datum));
		}
	}
}
