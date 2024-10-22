package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;


import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	//Objektvariabelen gpspoints som er en tabell med referanser til GPS punkter
	private GPSPoint[] gpspoints;

	//Konstruktør i klassen:
	public GPSComputer(String filename) {
		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();
	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {
		double totalDistance = 0.0;
	
		for (int i = 0; i < gpspoints.length - 1; i++) {
			totalDistance += GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);
		}
	
		return totalDistance;
	}
	

	public double totalElevation() {

		double elevation = 0;

		/*for(int i = 0; i < elevation.length; i++){
			elevation += GPSPoint.getElevation();

		}*/

		
		return elevation; 
		
		
		
	}

	public int totalTime() {

		
		// Tid brukt totalt, fra gpsdata
		if (gpspoints.length == 0) {
			if (gpspoints.length == 1) {
				return 0;
			
		}
			
		}
		return gpspoints[gpspoints.length - 1].getTime() - gpspoints[0].getTime();

		}

		

		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		// TODO
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO 
		throw new UnsupportedOperationException(TODO.method());
	
	}

	public double averageSpeed() {

		double average = 0;
		
		// TODO
		throw new UnsupportedOperationException(TODO.method());
		
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;		
		double speedmph = speed * MS;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
	}

public static void main(String[] args) {
    GPSPoint[] points = new GPSPoint[] {
        new GPSPoint(0, 60.385390, 5.332200, 50.0),
        new GPSPoint(10, 60.389390, 5.334200, 55.0),
        new GPSPoint(20, 60.392390, 5.338200, 60.0)
    };

    GPSComputer gpsComputer = new GPSComputer(points);
    double distance = gpsComputer.totalDistance();
    
    System.out.println("Total distance: " + distance + " meters");
}
}