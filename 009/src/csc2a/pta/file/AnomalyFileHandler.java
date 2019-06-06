package csc2a.pta.file;

/* TODO: Imports */
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;

import java.io.File;

import java.io.FileNotFoundException;

import csc2a.pta.model.ScannedAnomaly;
import csc2a.pta.model.UnscannedAnomaly;
import csc2a.pta.model.Anomaly;
import csc2a.pta.model.EAnomalyType;

public final class AnomalyFileHandler {
	
	/** This method takes a file handler as an argument
   *  Reads the content of the file.
   *  @param anomalyFile some
   *  @return list an array of objects.
   */
	public static ArrayList<Anomaly> readAnomalys(File anomalyFile) {

    // if file does not exists.
    if (!anomalyFile.exists()) {
      System.err.println("Specified file does not exist.");
      return null;
    }

		ArrayList<Anomaly> list = new ArrayList<>();

    Scanner scanner = null;

    try {

      scanner = new Scanner(anomalyFile);
		
      /* TODO: Read each line of the file      */
      /* 	 TODO: Validate using validate method */
      /* 	 TODO: Create correct instance        */
      /* 	 TODO: Add to ArrayList               */
      /* 	 TODO: Handle problems                */
      /* TODO: Free resources                 */
  
      while (scanner.hasNext()) {
        String line = scanner.nextLine();
  
        Anomaly anomaly = null;
  
        if (ScannedAnomaly.validate(line)) {
  
          // splits the line by spaces.
          StringTokenizer token = new StringTokenizer(line, "\t");
  
          String location = token.nextToken();
  
          int x = Integer.parseInt(location.split("@")[0]);
          int y = Integer.parseInt(location.split("@")[1]);
  
          EAnomalyType type = getType(token.nextToken());
          int size = Integer.parseInt(token.nextToken());
          String clas = token.nextToken();
  
          anomaly = new ScannedAnomaly(x, y, type, size, clas);
          
          list.add(anomaly);
  
        } else if (UnscannedAnomaly.validate(line)) {
  
          // splits the line by spaces.
          StringTokenizer token = new StringTokenizer(line, "\t");
  
          String location = token.nextToken();
          
          int x = Integer.parseInt(location.split("@")[0]);
          int y = Integer.parseInt(location.split("@")[1]);
  
          EAnomalyType type = getType(token.nextToken());
          String scale = token.nextToken();
  
          anomaly = new UnscannedAnomaly(x, y, type, scale);
          
          list.add(anomaly);
        }
      }
    } catch (FileNotFoundException e) {

    } finally {
      scanner.close();
    }
			
		return list;
  }

  private static EAnomalyType getType(String line) {

    EAnomalyType type = null;

    if (line.equalsIgnoreCase("gravitational")) {
      type = EAnomalyType.GRAVITATIONAL;
    } else if (line.equalsIgnoreCase("spatial")) {
      type = EAnomalyType.SPATIAL;
    } else if (line.equalsIgnoreCase("temporal")) {
      type = EAnomalyType.TEMPORAL;
    } else if (line.equalsIgnoreCase("geological")) {
      type = EAnomalyType.GEOLOGICAL;
    }

    return type;
  }
}
