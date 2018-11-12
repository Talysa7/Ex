package airline;

import org.apache.hadoop.io.Text;

/*
[COLUMNS]
Year,			Month,				DayofMonth,			DayOfWeek,			DepTime,	
CRSDepTime,		ArrTime,			CRSArrTime,			UniqueCarrier,		FlightNum,		
TailNum,		ActualElapsedTime,	CRSElapsedTime,		AirTime,			ArrDelay,		
DepDelay,		Origin,				Dest,				Distance,			TaxiIn,		
TaxiOut,		Cancelled,			CancellationCode,	Diverted,			CarrierDelay,	
WeatherDelay,	NASDelay,			SecurityDelay,		LateAircraftDelay
*/

//filtering data
public class DelayParser {
	private int year;
	private int month;
	private String uniqueCarrier;
	private boolean arrDelay=true;
	private int arrDelayTime=0;
	private boolean depDelay=true;
	private int depDelayTime=0;
	private int distance=0;
	private boolean distanceAvailable=true;
	public DelayParser(Text text) {
		String[] columns=text.toString().split(",");
		year=Integer.parseInt(columns[0]);
		month=Integer.parseInt(columns[1]);
		uniqueCarrier=columns[8];
		if(!columns[15].equals("NA")) {
			depDelayTime=Integer.parseInt(columns[15]);
		} else {
			depDelay=false;
		}
		if(!columns[14].equals("NA")) {
			arrDelayTime=Integer.parseInt(columns[14]);
		} else {
			arrDelay=false;
		}
		if(!columns[18].equals("NA")) {
			distance=Integer.parseInt(columns[18]);
		} else {
			distanceAvailable=false;
		}
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public String getUniqueCarrier() {
		return uniqueCarrier;
	}
	public boolean isArrDelay() {
		return arrDelay;
	}
	public int getArrDelayTime() {
		return arrDelayTime;
	}
	public boolean isDepDelay() {
		return depDelay;
	}
	public int getDepDelayTime() {
		return depDelayTime;
	}
	public int getDistance() {
		return distance;
	}
	public boolean isDistanceAvailable() {
		return distanceAvailable;
	}
}