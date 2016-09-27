package com.danielgm.nioFileUtilities;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;

 public class BasicSample {
	
	private static long fileScanedSize = 0;
	
	public static void main(String[] args) {
		main2(null);
		
		char t = 't';
		//System.out.println("cc"+t);
		
		FileSystem fileSystem = FileSystems.getDefault();
		
		Path currentDir = Paths.get("F://Daniel Gutierrez//Documentacion de proyectos");
		System.out.println(currentDir.toAbsolutePath());
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		try {
			  Files.walkFileTree(currentDir, new SimpleFileVisitor<Path>() {
			    
			    @Override
			    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			      String fileString = file.toAbsolutePath().toString();
			      //System.out.println("pathString = " + fileString);
			      fileScanedSize+=file.toFile().length();
			      /*if(fileString.endsWith(fileToFind)){
			        System.out.println("file found at path: " + file.toAbsolutePath());
			        return FileVisitResult.TERMINATE;
			      }
			      */
			      return FileVisitResult.CONTINUE;
			    }
			  });
			  String sze = DecimalFormat.getInstance().format(fileScanedSize/1024/1024/1024);
			  
			  //System.out.println(String.format("%.6f", Double.valueOf(fileScanedSize)/1024/1024/1024));
			} catch(IOException e){
			    e.printStackTrace();
			}
		
		
		
	}

	public void a(Long a){
		
	}
	
	public void a(Float a){
			
	}
	public void a(Double a){
		
	}
	public void a(Integer a){
		 
	}
	
	
	
	public static void main2(String[] args) {
		StringBuffer dato = new StringBuffer("hernan");
		dato.append("2");
		System.out.println(dato);
		
	}
	
	

}
 
 
 
 
