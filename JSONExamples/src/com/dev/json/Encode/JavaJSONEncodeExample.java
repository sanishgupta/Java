package com.dev.json.Encode;

import org.json.simple.JSONObject;

public class JavaJSONEncodeExample {
	public static void main(String args[]) {
		
		JSONObject obj = new JSONObject();
		
		obj.put("name", "sonoo");
		obj.put("age", new Integer(27));
		obj.put("salary", new Double(600000));
		System.out.print("JSONObject :==> " + obj);
	}
}