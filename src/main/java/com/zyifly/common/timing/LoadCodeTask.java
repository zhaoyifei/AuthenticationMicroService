package com.zyifly.common.timing;


import com.alibaba.fastjson.JSON;
import com.zyifly.util.ConfigUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 启动监听器
 * 
 * @author ygm
 */
public class LoadCodeTask implements ApplicationListener<ContextRefreshedEvent>{

	public static Map<String, Map<String, String>> codeMap = new HashMap<String, Map<String,String>>();


	@Override
	public void onApplicationEvent(ContextRefreshedEvent evt) {
		if (evt.getApplicationContext().getParent() == null) {
			loadCodeFromFile();
		}
	}
	
     @SuppressWarnings("unchecked")
	public void loadCodeFromFile(){
    	 String path = ConfigUtil.getInstance().get("code.url");
    	 FileReader fileReader = null;
    	 BufferedReader br = null;
    	 StringBuilder sb = new StringBuilder();
    	 try {
			fileReader = new FileReader(new File(path));
			br = new BufferedReader(fileReader);
			String line = br.readLine().trim(); 
			while(null != line){
				 sb.append(line);
				 line = br.readLine(); 
			}
			String result = sb.toString();
			if(null != result){
				Map<String, Map<String, String>> map = (Map<String, Map<String, String>>) JSON.parse(result);
				codeMap = map;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null != br){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != fileReader){
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
     }
}
