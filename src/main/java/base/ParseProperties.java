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
	//Java���и��Ƚ���Ҫ����Properties��Java.util.Properties������Ҫ���ڶ�ȡJava�������ļ�
	private  Properties pro = new Properties();
	String value = null;
	
	public  ParseProperties(String propertiespath){		
		this.loadProperties(propertiespath);
	}
	
	
	private void loadProperties(String propertiespath){			
		
		try {
			//FileInputStream��FileOutputStream��ֱ��������������ļ��������������������
			//InputStream ���ֽ���������������ĳ���,һ������ʹ����������,��FileInputStream��
			//InputStreamReader ���ֽ���ͨ���ַ���������,�����ֽ���ת��Ϊ�ַ���.
			//BufferedReader���ַ��������ж�ȡ�ı�����������ַ����Ӷ�ʵ���ַ���������еĸ�Ч��ȡ
			InputStream in = new FileInputStream(propertiespath);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			//load���������ж�ȡ�����б�����Ԫ�ضԣ���ͨ����ָ�����ļ�����װ������ȡ����
			//���е����м� - ֵ�ԡ��Թ� getProperty ( String  key) ��������
			pro.load(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//to get value of specific keyname
	public String getValue(String keyname){
		//java.util.Properties.getProperty(String key) �����������������б���ָ����������ֵ
		//trimȥ���ַ�����ͷ�ͽ�β�Ŀո�
		value = pro.getProperty(keyname).trim();
	    try {
	    	//String.getBytes(String decode)���������ָ����decode���뷵��ĳ�ַ����ڸñ����µ�byte�����ʾ ,byte[] b_utf8 = "��".getBytes("UTF-8"); 
			//����getBytes��Եģ�����ͨ��new String(byte[], decode)�ķ�ʽ����ԭ������С���ʱ�����new String(byte[], decode)ʵ����ʹ��decodeָ���ı�������byte[]�������ַ�����
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
