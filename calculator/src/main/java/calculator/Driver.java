package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Mahid
 * 
 * This program reads a list of animals from a resource called animals.txt and prints it to the terminal.
 *
 */
public class Driver {

  /**
   * The entry point for my animal lister program.
   * @param args the arguments enetred on the command line for this program (ignored).
   * @throws IOException thrown when we fail to read animals from the open animals.txt file.
   */
  public static void main(String[] args) throws IOException {
    InputStream is = Driver.class.getResourceAsStream("/animals.txt");
    Animals animals = new Animals();
    if (is != null) {
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line = br.readLine();
      while (line != null) {
        animals.add(line);
        line = br.readLine();
      }
    } else {
      animals.add("Elephant");
    }
    System.out.println(animals);
  }

}

