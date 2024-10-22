package no.hvl.dat100ptc.oppgave3;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {
	public static double findMax(double[] da) {
		double max; 
		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	//a)
	public static double findMin(double[] da) {
		double min;
		min = da[0];

		for(double d : da){
			if(d < min){
				min = d; 
			}
		}
		
		return min; 
	}

	//b)
	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		//1. metoden skal først opprette en tabell av desimaltall med samme lengde som gpspoints-tabellen
		int length = gpspoints.length;
		double[] latitudes = new double[length];

		//2. Derette kopiere de enkelte breddegrader over i den nye tabellen.
		for(int i = 0; i < length; i++){
			latitudes[i] = gpspoints[i].getLatitude();
		}

		//Skriver ut tabellen med kopierte breddegrads verdier
		for(int j = 0; j < latitudes.length; j++){
			System.out.println(latitudes[j]);
		}

		return latitudes; 
	}

	//c
	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		int length = gpspoints.length;
		double[] longitudes = new double[length];

		for(int i = 0; i < length; i++){
			longitudes[i] = gpspoints[i].getLatitude();
		}
		
		for(int j = 0; j < longitudes.length; j++){
			System.out.println(longitudes[j]);
		}
		
		return longitudes;
	}

	private static final int R = 6371000; // jordens radius

	//d
	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
        double latitude1 = Math.toRadians(gpspoint1.getLatitude());
        double longitude1 = Math.toRadians(gpspoint1.getLongitude());
        double latitude2 = Math.toRadians(gpspoint2.getLatitude());
        double longitude2 = Math.toRadians(gpspoint2.getLongitude());

		//Her er haversine formel for deltaphi altså formel nr 2 i figuren
        double deltaPhi = Math.toRadians(latitude2 - latitude1);

		//Her er haversine formel for deltadelta altså formel nr3 i figuren
        double deltaDelta = Math.toRadians(longitude2 - longitude1);

		double a = compute_a(latitude1, latitude2, deltaPhi, deltaDelta);
        double c = compute_c(a);

		double d = R * c;
        
        return d;
    }

    private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
        double sinDeltaphi = Math.sin(deltaphi / 2);
        double sinDeltadelta = Math.sin(deltadelta / 2);

        return sinDeltaphi * sinDeltaphi + Math.cos(phi1) * Math.cos(phi2) * sinDeltadelta * sinDeltadelta;
    }

	private static double compute_c(double a) {
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return c;
	}

	//e)
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		int secs = 3600;
		double speed = distance(gpspoint1, gpspoint2) / secs; 

		return speed; 
	}

	//f
	public static String formatTime(int secs) {
		String timestr;

		int hr = secs / 3600;
        int min = secs % 3600 / 60;
        int sec = secs - (hr * 3600 + min * 60);
		
		String timeStr = String.format("%02d:%02d:%02d", hr, min, sec);
		return String.format("%10s", timeStr);
	}

	//g
	public static String formatDouble(double d) {
		String avrundet = String.format(Locale.US, "%.2f", d); // avrunder til 
		return String.format("%10s", avrundet);
	}
}
