 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Education Unlimited
 */
package Final;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class game {
    
    private class room
    {
        String[] options = new String [12];
        String name;
        String description;
        String[] roomNext = new String [12];
        
       
    
    }
  private ArrayList<room> r;
  
  public game()
  {
     
       String FILENAME = "hello.txt";
	try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
           
            String currentLine = reader.readLine();
           
          while (currentLine != null)
          {
             room x = new room();
            if (currentLine.charAt(0) == 'r')
            {  
                x.name = currentLine.substring(1,currentLine.length());
                x.description = "";
                currentLine = reader.readLine();
            }
            while(currentLine.charAt(0) == 'd')
            {
                x.description = x.description.concat(currentLine);
                currentLine = reader.readLine();
            }
            int i = 0;
            while (currentLine.charAt(0) == 'o')
            {
                 x.options[i] = currentLine;
                 currentLine = reader.readLine();
                x.roomNext[i] = currentLine;
                i++;
                currentLine = reader.readLine();
                 }
            r.add(x);
          }
        }

   catch (IOException e) {
            e.printStackTrace();
	}
  }
  
  public void bubbleSort() {
        int n = r.size();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                int j = i + 1;
                int x = r.get(i).name.compareTo(r.get(j).name);
                if (x > 0) {
                    swapRooms(i, j, r);
                }
            }

        }
    }

    private static void swapRooms(int i, int j, ArrayList<room> r) {

        room temp;
        temp = r.get(j);
        r.remove(j);
        r.add(j, r.get(i));
        r.remove(i);
        r.add(i, temp);
    }
    
    public room search()
    {
        int i = 0;
        while (1 == 0){
            
        }
    }
}

