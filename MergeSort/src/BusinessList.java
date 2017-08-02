/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Education Unlimited
 */
public class BussinessList {
    private int numberOfBusinesses;
    private BusinessRecord[] b;
    private int searches;
    private int failed;
    
    public BusinessList(int num){
         BussinessRecord[] b = new By[100];
          
            int index=0;
        String FILENAME = "hello.txt";
	try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
           
            String currentLine = reader.readLine();
        
            while (currentLine != null) {
		r[index]=currentLine;
                index++;
                currentLine = reader.readLine();
            }

	}
        catch (IOException e) {
            e.printStackTrace();
	}
        
    }
    
}
