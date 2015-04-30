package testing.allData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FilterFromAlexa {

	String whiteListPath ="data/alexa-1m.txt";
	ArrayList<String> whiteList = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		FilterFromAlexa mainClass = new FilterFromAlexa();
		mainClass.getWhiteList();

	}

	void getWhiteList() throws IOException{
		FileReader fr = new FileReader(this.whiteListPath);
		BufferedReader br = new BufferedReader(fr);
		Set<String> intSet = new HashSet<String>();
		while(br.ready()){
			String line = br.readLine();
//			if(line.split("/").length>1){
//				System.out.println(line+"\t"+line.split("/").length);
//			}
			line = line.split("/")[0];
//			if(!this.whiteList.contains(line)){
//				this.whiteList.add(line);	//陣列大小：990850
//			}
			
			intSet.add(line);
			
		}
		br.close();
		Object[] tempArray = intSet.toArray();
		System.out.println("set 陣列大小："+tempArray.length);
		for(Object element:tempArray){
			this.whiteList.add(element.toString());
		}
		System.out.println("whiteList 陣列大小："+this.whiteList.size());
	}
}
