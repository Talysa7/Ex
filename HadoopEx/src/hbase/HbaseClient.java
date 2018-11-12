package hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class HbaseClient {
	public static void main(String[] args) throws IOException {
		Configuration conf=HBaseConfiguration.create();
		HBaseAdmin admin=new HBaseAdmin(conf);
		try {
			TableName tableName=TableName.valueOf("test");
			HTableDescriptor htd=new HTableDescriptor(tableName);
			HColumnDescriptor hcd=new HColumnDescriptor("data");
			htd.addFamily(hcd);
			admin.createTable(htd);
			HTableDescriptor[] tables=admin.listTables();
			if(tables.length!=1&&Bytes.equals(tableName.getName(), tables[0].getTableName().getName())) {
				admin.close();
				throw new IOException("테이블 생성 실패");
			}
			HTable table=new HTable(conf, tableName);
			try {
				for(int i=1; i<4; i++) {
					byte[] rows=Bytes.toBytes("row"+i);
					Put put=new Put(rows);
					byte[] cf=Bytes.toBytes("data");
					byte[] qualifier=Bytes.toBytes(String.valueOf(1));
					byte[] value=Bytes.toBytes("value"+i);
					put.add(cf, qualifier, value);
					table.put(put);
				}
				Get get=new Get(Bytes.toBytes("row"));
				Result result=table.get(get);
				System.out.println("Get : "+result);
				Scan scan=new Scan();
				ResultScanner scanner=table.getScanner(scan);
				for(Result scannerResult:scanner) {
					System.out.println("Scan : "+scannerResult);
				}
				if(result==null) scanner.close();
				admin.disableTable(tableName);
				admin.deleteTable(tableName);
			} finally {
			table.close();
			}
		} finally {
		admin.close();
		}
	}
}