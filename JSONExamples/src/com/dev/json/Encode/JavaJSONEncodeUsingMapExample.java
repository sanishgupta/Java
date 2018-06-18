package com.dev.json.Encode;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONValue;

public class JavaJSONEncodeUsingMapExample {
	public static void main(String args[]) {

		List list = new ArrayList();
		
		list.add("sonoo");
		list.add(new Integer(27));
		list.add(new Double(600000));
		
		String jsonText = JSONValue.toJSONString(list);
		System.out.print(jsonText);
	}
}