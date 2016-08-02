package base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.sqlite.SQLiteConfig.Encoding;

public class ParseProperties {
	//Java中有个比较重要的类Properties（Java.util.Properties），主要用于读取Java的配置文件
	private  Properties pro = new Properties();
	String value = null;
	
	public  ParseProperties(String propertiespath){		
		this.loadProperties(propertiespath);
	}
	
	
	private void loadProperties(String propertiespath){			
		
		try {
			//FileInputStream和FileOutputStream类分别用来创建磁盘文件的输入流和输出流对象
			//InputStream 是字节输入流的所有类的超类,一般我们使用它的子类,如FileInputStream等
			//InputStreamReader 是字节流通向字符流的桥梁,它将字节流转换为字符流.
			//BufferedReader从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取
			InputStream in = new FileInputStream(propertiespath);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			//load从输入流中读取属性列表（键和元素对）。通过对指定的文件进行装载来获取该文
			//件中的所有键 - 值对。以供 getProperty ( String  key) 来搜索。
			pro.load(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//to get value of specific keyname
	public String getValue(String keyname){
		//java.util.Properties.getProperty(String key) 方法将搜索此属性列表中指定键的属性值
		//trim去掉字符串开头和结尾的空格
		value = pro.getProperty(keyname).trim();
	    try {
	    	//String.getBytes(String decode)方法会根据指定的decode编码返回某字符串在该编码下的byte数组表示 ,byte[] b_utf8 = "中".getBytes("UTF-8"); 
			//而与getBytes相对的，可以通过new String(byte[], decode)的方式来还原这个“中”字时，这个new String(byte[], decode)实际是使用decode指定的编码来将byte[]解析成字符串。
	    	value = new String(value.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	
	public  static void main(String[] args){
		ParseProperties a = new ParseProperties("E:/testeclipse/workspace/Haha/tool/test.properties");
	
		System.out.println(a.getValue("url"));
	}
	
}
