package com.capgemini.CopyService;

import java.io.*;
import java.nio.file.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ServiceTransfer {
	
	@RequestMapping(value="/copy" , method=RequestMethod.GET)
	public String copyfile() throws IOException
	{
		Path temp = Files.copy
		        (Paths.get("C:\\Users\\adharewa\\abc.txt"), 
		        Paths.get("D:\\Ashwini\\abc.txt"));
		 
		        if(temp != null)
		        {
		            System.out.println("File renamed and moved successfully");
		        }
		        else
		        {
		            System.out.println("Failed to move the file");
		        }
		         return "file transfered successfully";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delfile() throws IOException
	{
		 File file = new File("D:\\Ashwini\\abc.txt");
         
	        if(file.delete())
	        {
	            System.out.println("File deleted successfully");
	        }
	        else
	        {
	            System.out.println("Failed to delete the file");
	        }
		         return "file deleted successfully";
	}

	
	@RequestMapping(value="/move",method=RequestMethod.GET)
	public String movefile() throws IOException
	{
		Path temp = Files.move
		        (Paths.get("C:\\Users\\adharewa\\abc.txt"), 
		        Paths.get("D:\\Ashwini\\newAbc.txt"));
		 
		        if(temp != null)
		        {
		            System.out.println("File renamed and moved successfully");
		        }
		        else
		        {
		            System.out.println("Failed to move the file");
		        }
		         return "file transfered successfully";
	}
	
	@RequestMapping(value="/update" , method= RequestMethod.GET)
    public String updateFile() {

         BufferedWriter bw = null;
         FileWriter fw = null;

         try {

               String data = " This is new content";

               File file = new File("D:\\Ashwini\\newAbc.txt");

               // if file doesnt exists, then create it
               if (!file.exists()) {
                      file.createNewFile();
               }

               // true = append file
               fw = new FileWriter(file.getAbsoluteFile(), true);
               bw = new BufferedWriter(fw);

               bw.write(data);

               System.out.println("File updated successfully");

         } catch (IOException e) {

               e.printStackTrace();

         } finally {

               try {

                      if (bw != null)
                             bw.close();

                      if (fw != null)
                             fw.close();

               } catch (IOException ex) {

                      ex.printStackTrace();
                      System.out.println("File update failed");

               }
         }
         return "File updated Successfully";

  }


}
