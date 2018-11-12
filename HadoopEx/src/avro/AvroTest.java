package avro;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;

public class AvroTest {
	public static void main(String[] args) throws IOException {
		Schema schema=new Schema.Parser().parse(new File("src/avro/StringPair.avsc"));
		GenericRecord datum=new GenericData.Record(schema);
		datum.put("left", "Links");
		datum.put("right", "Rechts");
		datum.put("center", "Mitte");
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		DatumWriter<GenericRecord> writer=new GenericDatumWriter<GenericRecord>(schema);
		Encoder encoder=EncoderFactory.get().binaryEncoder(out,null);
		writer.write(datum, encoder);
		encoder.flush();
		out.close();
		DatumReader<GenericRecord> reader=new GenericDatumReader<GenericRecord>(schema);
		Decoder decoder=DecoderFactory.get().binaryDecoder(out.toByteArray(), null);
		GenericRecord result=reader.read(null, decoder);
		System.out.println("left : "+result.get("left").toString());
		System.out.println("right : "+result.get("right").toString());
		System.out.println("center : "+result.get("center").toString());
	}
}
