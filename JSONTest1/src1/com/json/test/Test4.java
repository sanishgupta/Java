package com.json.test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONValue;

public class Test4 {
	
	public static void main (String[] s) throws IOException
	{
		   Map obj=new LinkedHashMap();
		   obj.put("name","foo");
		   obj.put("num",new Integer(100));
		   obj.put("balance",new Double(1000.21));
		   obj.put("is_vip",new Boolean(true));
		   obj.put("nickname",null);
		   StringWriter out = new StringWriter();
		   JSONValue.writeJSONString(obj, out);
		   String jsonText = out.toString();
		   System.out.print(jsonText);
	}

}
