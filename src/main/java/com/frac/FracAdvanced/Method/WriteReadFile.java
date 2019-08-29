package com.frac.FracAdvanced.Method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frac.FracAdvanced.model.MiniFracModel;
import com.frac.FracAdvanced.repository.MiniFracRepo;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;

@Component
public class WriteReadFile {
	
	
	private static MiniFracRepo service;
	private static HttpSession session;
	
	@Autowired
	public WriteReadFile(MiniFracRepo service1,HttpSession session1) {
		service=service1;
		session=session1;
	}
	
	
	public static void createInputFile()throws Exception {
		List<MiniFracModel> inputList= service.findAll();
		String path=session.getServletContext().getRealPath("/");
		String filename="InputFile.txt";
		int i=0;
		FileWriter write=new FileWriter(path+"/InputFile/"+filename);
		BufferedWriter buffer=new BufferedWriter(write);
		
		MiniFracModel pump=inputList.get(0);
		buffer.write("/*****************INPUT FILE**********************/");
		buffer.newLine();
		buffer.write("PUMPINGTIME="+pump.getPumptime());
		for(MiniFracModel frac:inputList) {
			buffer.newLine();
		buffer.write("DURATION"+i+"="+frac.getTime());
		buffer.newLine();
		buffer.write("PRESSURE"+i+"="+frac.getPressure());
		i++;
		}
		buffer.close();
		
	}
	
	
	public static Map<String, String> readInputFile()throws Exception {
		String fileName="InputFile.txt";
		Map<String, String> map=new LinkedHashMap<>();
		String path=session.getServletContext().getRealPath("/");
		FileReader fr=new FileReader(path+"/InputFile/"+fileName);
		BufferedReader br= new BufferedReader(fr);
		String line;
		while((line=br.readLine())!=null) {
			if(line.startsWith("/")) {continue;}else {
			int index=line.indexOf("=");
			String key=line.substring(0,index);
			String value=line.substring(index+1);
			map.put(key, value.trim());
			}
		}
		return map;
		
	}
	
}
