package hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HdfsFile {
	public static void main(String[] args) throws IOException {
		if(args.length != 2) {
			System.out.println("How to use : HdfsFile <savefilename> <contents>");
			System.exit(0);
		}
		//setting file system
		Configuration conf=new Configuration();
		FileSystem hdfs=FileSystem.get(conf);
		Path path=new Path(args[0]);
		if(hdfs.exists(path)) {
			hdfs.delete(path, true);
		}
		//save file
		FSDataOutputStream os=hdfs.create(path);
		os.writeUTF(args[1]);
		os.close();
		//show file
		FSDataInputStream is=hdfs.open(path);
		String msg=is.readUTF();
		System.out.println("Input data : "+msg);
	}
}