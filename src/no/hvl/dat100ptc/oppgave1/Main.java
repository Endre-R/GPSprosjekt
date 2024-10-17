package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		GPSPoint point = new GPSPoint(1, 2.0, 3.0, 5.0);

		// Viser initiale verdier
        System.out.println(point.toString()); // Output: 1 (2.0,3.0) 5.0m

        // Bruker getter og setter metoder
        point.setTime(2);
        System.out.println("Oppdatert tid: " + point.getTime()); // Output: Oppdatert tid: 2
        
        // Viser oppdaterte punktdetaljer
        System.out.println(point.toString()); // Output: 2 (2.0,3.0) 5.0m	
    }
}