/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Education Unlimited
 */
import java.io.*;
public class BusinessList {
    private int numberOfBusinesses;
    private BusinessRecord[] b;
    private int searches;
    private int failed;
    
    public BusinessList(int num){
         BusinessRecord[] b = new BusinessRecord[100];
          
            int index=0;
        String FILENAME = "hello.txt";
	try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
           
            String currentLine = reader.readLine();
        
            while (currentLine != null) {
                BusinessRecord n = new BusinessRecord(currentLine, "696969669");
		b[index] = n;
                index++;
                currentLine = reader.readLine();
            }

	}
        catch (IOException e) {
            e.printStackTrace();
	}
        
    }
    
}
