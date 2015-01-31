/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalsandbox;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A ScoreIO is responsible for reading and writing a record of scores achieved 
 * by the local users of the application
 * @author showland17
 */
public class ScoreIO {
    /**
     * Appends an integer score to a given file
     * @param destination The file the score is to be added to
     * @param score The high score to be kept on file
     */
    public void writeScore (File destination, Integer score) {
        try {
            BufferedWriter wrtr = new BufferedWriter (new FileWriter (destination, false));
            String line = score.toString();
            wrtr.write(line);
            wrtr.newLine();
            wrtr.close();
        }
        catch (IOException ex) {
            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Reads each line of the given file, attempting to convert each string
     * found to an integer, then adding it to the ArrayList of scores to be 
     * used by the application
     * @param destination The file whose contents are to be read
     * @param score The high score value to be used by the application
     */
    public int readScore (File destination) {
        int score = 900;
        
        try {
            BufferedReader rdr = new BufferedReader (new FileReader (destination));
            String line = "";
            
            while ((line = rdr.readLine()) != null) {
                try {
                    Integer rdrVal = Integer.parseInt(line);
                    score = rdrVal;
                }
                catch (NumberFormatException ex) {
                    Logger.getLogger(ScoreIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            rdr.close();
        }
        catch (IOException ex) {
            Logger.getLogger(ScoreIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return score;
    }
}