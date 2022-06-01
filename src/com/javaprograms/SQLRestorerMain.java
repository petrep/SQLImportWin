package com.javaprograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class SQLRestorerMain {

	public static void main(String[] args) throws IOException {
		System.out.println("testing begins");
		
		// You need to ensure:
		// Is mysql.exe available on the path environment variable
		// When exporting the db, you need to ensure that the .sql script creates a new empty db for the import, or you need to do this manually.
		
		
		//mysql -u root -ppassword -e "CREATE DATABASE mydb"
		
		ProcessBuilder pb = new ProcessBuilder();
		pb.redirectOutput(Redirect.INHERIT);
		pb.redirectError(Redirect.INHERIT);
		pb.command("cmd.exe", "/c", "mysql -u root -ppassword -e \"CREATE DATABASE mydb");
		
		Process p = pb.start();
		
		// mysql -u root -ppassword mydb < Dump20220601.sql
		pb.command("cmd.exe", "/c", "mysql -u root -ppassword mydb < c:\\tools\\Dump20220601.sql");
		p = pb.start();
		
		String line;
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		  while ((line = input.readLine()) != null) {
		    System.out.println(line);
		  }
		  input.close();
		
		
		
		System.out.println("testing ends");
	}
}
