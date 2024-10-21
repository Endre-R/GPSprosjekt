package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	public static int toSeconds(String timestr) {
		int secs;
		int hr, min, sec;

        String[] gpsTid = (timestr.substring((timestr.indexOf('T')) + 1, timestr.indexOf('.'))).split(":");

        hr = Integer.parseInt(gpsTid[0]);
        min = Integer.parseInt(gpsTid[1]);
        sec = Integer.parseInt(gpsTid[2]);

        secs = hr * 3600 + min * 60 + sec;

		return secs;
	}

	public static class GPSPoint {
		private int time;
		private double latitude, longitude, elevation;
	
		//Konstruktører
		public GPSPoint(int time, double latitude, double longitude, double elevation) {
			this.time = time;
			this.latitude = latitude;
			this.longitude = longitude;
			this.elevation = elevation;
		}
	
		public int getTime() {
			return time;
		}
	
		public double getLatitude() {
			return latitude;
		}
	
		public double getLongitude() {
			return longitude;
		}
	
		public double getElevation() {
			return elevation;
		}
	
		public String toString() {
			return "GPSPoint [time=" + time + ", latitude=" + latitude + ", longitude=" + longitude + ", elevation=" + elevation + "]";
		}
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		GPSPoint gpsPoint;
		int time;
		double latitude, longitude, elevation;

		time = toSeconds(timeStr);
		latitude = Double.parseDouble(latitudeStr);
		longitude = Double.parseDouble(longitudeStr);
		elevation = Double.parseDouble(elevationStr);
		
		gpsPoint = new GPSPoint(time, latitude, longitude, elevation);

		return gpsPoint;
	}
}