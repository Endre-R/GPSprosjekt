package no.hvl.dat100ptc.test.oppgave4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class GPSComputerTester {
	
	private int EXP_TOTALTIME = 1 * 60 + 20;
	private double EXP_TOTALDISTANCE = 1080 + 5835 + 5835 + 1080;
	private double EXP_TOTALELEVATION = 10 + 30 + 10;
	private double[] EXP_SPEEDS =  {108.0, 194.5, 194.5, 108.0 };
	private double EXP_MAXSPEED = 194.5 ;
	private double EXP_AVERAGESPEED = (EXP_TOTALDISTANCE / EXP_TOTALTIME);
			
	private GPSComputer gpscomp;
	
	@BeforeEach
	public void SetUp() {

		GPSPoint g0 = GPSDataConverter.convert("2017-08-13T08:00:00.000Z","60.376988","5.227082","10");
		GPSPoint g1 = GPSDataConverter.convert("2017-08-13T08:00:10.000Z","60.385390","5.217217","20");
		GPSPoint g2 = GPSDataConverter.convert("2017-08-13T08:00:40.000Z","60.379527","5.3227322","10");
		GPSPoint g3 = GPSDataConverter.convert("2017-08-13T08:01:10.000Z","60.385390","5.217217","40");
		GPSPoint g4 = GPSDataConverter.convert("2017-08-13T08:01:20.000Z","60.376988","5.227082","50");
		
		GPSPoint[] gpspoints = new GPSPoint[5];
		
		gpspoints[0] = g0;
		gpspoints[1] = g1;
		gpspoints[2] = g2;
		gpspoints[3] = g3;
		gpspoints[4] = g4;
		
		gpscomp = new GPSComputer(gpspoints);
	}
	
	@Test
	public void testTotalDistance() {
		assertEquals(EXP_TOTALDISTANCE,gpscomp.totalDistance(),0.5);
	}
	
	@Test
	public void testTotalElevation() {
		assertEquals(EXP_TOTALELEVATION,gpscomp.totalElevation(),0);
	}

	@Test
	public void testTotalTime() {
		assertEquals(EXP_TOTALTIME,gpscomp.totalTime());
	}
	@Test
	public void testSpeeds() {
		assertArrayEquals(EXP_SPEEDS,gpscomp.speeds(),0.1);
	}
	
	@Test
	public void testMaxSpeed() {
		assertEquals(EXP_MAXSPEED,gpscomp.maxSpeed(),0.1);
	}
	
	@Test
	public void testAverageSpeed() {
		assertEquals(EXP_AVERAGESPEED,gpscomp.averageSpeed(),0.1);
	}
	
	@Test
	public void testkcal() {
		assertEquals(8.0/3600.0,gpscomp.kcal(1.0, 1, 13.0/GPSComputer.MS),0.1);
		assertEquals(2*8.0/3600.0,gpscomp.kcal(2.0, 1, 13.0/GPSComputer.MS),0.1);
		assertEquals(3*2*8.0/3600.0,gpscomp.kcal(3.0, 2, 13.0/GPSComputer.MS),0.1);
	}
	
	@Test
	public void testtotalkcal () {
		assertEquals(28.44,gpscomp.totalKcal(80.0),0.01);
		
	}
	
	public void test_displayStatictics(String filename) {
		
		GPSComputer gpscomp = new GPSComputer(filename);
		
		gpscomp.displayStatistics();
		
	}
	
	@Test
	public void test_displayshort() {
		
		test_displayStatictics("short");
	}
	
	@Test
	public void test_displaysmedium() {
		
		test_displayStatictics("medium");
	}
	
	@Test
	public void test_displaylong() {
		
		test_displayStatictics("long");
	}
	
	@Test
	public void test_displayvm() {
		
		test_displayStatictics("vm");
	}
}
