package testing.allData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UniDNSFromFile {

//	String p_o = "C:\\Users\\chu\\Desktop\\畢業論文\\FromGithub\\DGA-master\\dga_wordlists";
//	String path = "data/selectMalwareFile/Alurewo";
//	String path = "data/selectMalwareFile/cryptolocker";
//	String path = "data/selectMalwareFile/Drowor_worm";
//	String path = "data/selectMalwareFile/Lader-dlGameoverZeus";
//	String path = "data/selectMalwareFile/sality";
//	String path = "data/selectMalwareFile/torpigminiloader";	//6
	String path = "data/selectMalwareFile/SpyEye";
	
//	String path = "data/dga_wordlists/conficker.txt";
	
	ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		UniDNSFromFile mainClass = new UniDNSFromFile();
		mainClass.getUniDNS();
//		System.out.println(mainClass.list);
		mainClass.getDNS();
	}
	
	void getUniDNS() throws IOException{
		FileReader fr = new FileReader(this.path);
		System.out.println("path:"+this.path);
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()){
			String line = br.readLine();
//			line = line.split("\\.")[1].toString();	//DNS ArrayList size ：22	,totally:9
//			System.out.println(line);
			if(line.split("\\.").length<5){	//level數量不可以多4個，最多4個
				if(!this.list.contains(line)){
					this.list.add(line);
				}else{
//					System.out.println("重複的網域名稱："+line);	//重複的網域名稱
				}
				
			}
		}
		Collections.sort(this.list);
	}
	
	void getDNS(){
		int iou = 0;
		for(String dnsUp:this.list){
//			String dns = dnsUp.split("\\.")[0].toString();
			String dns = dnsUp;
			String[] d = dns.split("");
			Set s=new HashSet(); 
			ArrayList<String> aeiou = getaeiou();
			
			int a = 0;
			for(String uni:d){
				if(aeiou.contains(uni)){a++;}
				s.add(uni);
			}

			if(iou<a){
				iou = a;
			}
			
			System.out.println("DNS："+dns+"\t字串長度："+dns.length()+"\t字母aeiou的數量:"+a);
//			System.out.println(s+"\t"+s.size()+"\n");
			
		}
		System.out.println("DNS ArrayList size ："+this.list.size()+"\t,totally:"+iou);
	}
	ArrayList<String> getaeiou(){
		ArrayList<String> aeiou = new ArrayList<String>();
		aeiou.add("a");
		aeiou.add("e");
		aeiou.add("i");
		aeiou.add("o");
		aeiou.add("u");
		aeiou.add("A");
		aeiou.add("E");
		aeiou.add("I");
		aeiou.add("O");
		aeiou.add("U");
		return aeiou;
	}

}
