package testing.allData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import tools.ReadWrite;

public class ReadUnzipFile {

	String inputPath = "data/unzipFileTotal.dns";
	String malwareListPath ="data/selectMalware";
	String outputFolderPath = "data/selectMalwareFile/";

	ArrayList<String> malwareList = new ArrayList<String>();
	ArrayList<String> pcapList = new ArrayList<String>();
	ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
	ReadWrite rw = new ReadWrite();
	
	public static void main(String[] args) throws Exception {
		ReadUnzipFile mainClass = new ReadUnzipFile();
		mainClass.setData();
		mainClass.setMalwareList();
		mainClass.filterMalware();
		System.out.println("___Finish___");
	}
	
	void filterMalware(){
		for(String malware:this.malwareList){
			for(int i=0;i<this.dataList.size();i++){
//				System.out.println("原來："+this.dataList.get(i));
				String filename = this.dataList.get(i).get(0).toString();
//				System.out.println("竊取："+filename);
				if(filename.indexOf(malware)>=0){
//					System.out.println(line);
					for(int j=1;j<this.dataList.get(i).size();j++){
						rw.appendWrite(this.outputFolderPath+malware, dataList.get(i).get(j));
						
					}
				}
				
//				System.out.println(this.dataList.get(i).get(0)+","+i+","+this.dataList.get(i).size());
			}
		}
		
	}
	
	void setData() throws Exception{
		FileReader fr = new FileReader(this.inputPath);
		BufferedReader br = new BufferedReader(fr);
		int mIndex = 0;
		while(br.ready()){
			String line = br.readLine();
//			if(line.indexOf("Alurewo")>=0){
//				System.out.println(line);
//			}
//			System.out.println(line);
			
			if(line.indexOf(".pcap")>=0){
				ArrayList<String> list = new ArrayList<String>();
				list.add(line.split(".pcap")[0]);
				int ii = mIndex;
				this.dataList.add(ii, list);
//				this.dataList.add(mIndex, list);
				mIndex++;
			}else{
				int inIndex = this.dataList.size()-1;
				ArrayList<String> list = new ArrayList<String>();
				list = this.dataList.get(inIndex);
				list.add(line);
				this.dataList.set(inIndex, list);
			}
//			if(mIndex==10){
//				System.out.println(this.dataList);
//				break;
//			}
		}
//		for( ArrayList<String> list:this.dataList){
		for( int i=0; i<this.dataList.size();i++){
//			System.out.println(list.get(0)+","+list.get(1));
//			System.out.println(this.dataList.get(i).get(0)+" , "+this.dataList.get(i).size());
//			System.out.println(this.dataList.get(i));
		}
//		System.out.println(this.dataList);
	}
	

	void setMalwareList() throws Exception{
		FileReader fr = new FileReader(this.malwareListPath);
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()){
			String line = br.readLine();
			this.malwareList.add(line);
		}
//		System.out.println(this.malwareList);
	}
	
	void setPcapList() throws Exception{
		FileReader fr = new FileReader(this.inputPath);
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()){
			String line = br.readLine();
			if(line.indexOf(".pcap")>=0){
//				System.out.println(line+"\t"+line.split(".pcap")[0]);
				pcapList.add(line.split(".pcap")[0]);
			}
		}
	}
}
