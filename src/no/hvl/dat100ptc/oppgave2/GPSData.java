package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {

		gpspoints = new GPSPoint[antall]; // Liste av GPS-punkter
			
		
		
	}

	public GPSPoint[] getGPSPoints() {
		
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			return true;
			
		}
		 
		return false;
		 
		
		 
	
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoints;

		int timeInt = GPSDataConverter.toSeconds(time);
		double doubLatitude = Double.parseDouble(latitude); 
		double doubLongitude = Double.parseDouble(longitude); 
		double doubElevation = Double.parseDouble(elevation); 

		gpspoints = new GPSPoint(timeInt, doubLatitude, doubLongitude, doubElevation);

		return insertGPS(gpspoints);

		// TODO 
		
	}

	

	public void print() {

		System.out.println("====== GPS Data - START ======");
    
		
		for (int i = 0; i < antall; i++) {
			
		System.out.println((i + 1) + " " + gpspoints[i].toString());
		
		}
		
		System.out.println("====== GPS Data - SLUTT ======"); 

		// TODO 
	}
}
