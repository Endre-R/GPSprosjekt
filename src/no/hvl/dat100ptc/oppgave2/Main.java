package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {

	GPSPoint point1 = new GPSPoint(25, 53.3232, 21.2343, 45.67);
	GPSPoint point2 = new GPSPoint(40, 23.3223, 23.3244, 23.34);

	GPSData gpsdata = new GPSData(2);

	gpsdata.insertGPS(point1);
	gpsdata.insertGPS(point2);

	gpsdata.print();
		
	}
}
