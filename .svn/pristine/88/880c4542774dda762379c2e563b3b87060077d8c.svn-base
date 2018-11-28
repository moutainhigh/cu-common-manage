package com.aotain.common.utils.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateActiveResource {
	public static List<String> readFileByLine(File file) {
        BufferedReader reader = null;
        String temp = null;
        List<String> fileContexts = new ArrayList<>();
        try {
            reader= new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));//转成gbk就不乱码了
            while ((temp = reader.readLine()) != null) {
                fileContexts.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContexts;
    }
	
	public static void createActiveIpOrData(String dir,int[] colIndex,String suffix,long add) throws IOException{
		File file = new File(dir);
		File[] files = file.listFiles();
		for(File f : files ){
			if(!f.isFile()){
				continue;
			}
			List<String> lines = readFileByLine(f);
			File dst = new File(f.getParentFile().getCanonicalPath()+File.separator+"output"+File.separator+f.getName()+suffix);
			if(!dst.getParentFile().exists()){
				dst.getParentFile().mkdirs();
			}
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dst), "UTF-8"));
			for(String line : lines) {
				if(line == null || line.equals("")){
					continue;
				}
				String[] strs = line.split("\\|");
				if(strs != null){
					StringBuilder sb = new StringBuilder();
					boolean success = true;
					for(int i = 0; i < strs.length; i++){
						if(i > 0) {
							sb.append("|");
						}
						boolean a = false;
						for(int index : colIndex){
							if(i == index){
								sb.append(Long.parseLong(strs[i])+add);
								a = true;
							}
						}
						if(!a){
							if(strs[i] == null){
								strs[i] = "";
							}
							sb.append(strs[i]);
						}
					}
					if(success){
						writer.write(sb.append("\r\n").toString());
					}
				}
			}
			writer.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		createActiveIpOrData("C:\\Users\\Administrator\\Desktop\\jar\\hyzy\\domain\\domain", new int[]{7,8}, "_0908", -60*60*24);
		createActiveIpOrData("C:\\Users\\Administrator\\Desktop\\jar\\hyzy\\domain\\domain", new int[]{7,8}, "_0907", -60*60*24*2);
		createActiveIpOrData("C:\\Users\\Administrator\\Desktop\\jar\\hyzy\\ip\\ip", new int[]{5,6}, "_0907", -60*60*24*2);
		createActiveIpOrData("C:\\Users\\Administrator\\Desktop\\jar\\hyzy\\ip\\ip", new int[]{5,6}, "_0908", -60*60*24);
	}
}
