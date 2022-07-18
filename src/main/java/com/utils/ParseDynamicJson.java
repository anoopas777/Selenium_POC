package com.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseDynamicJson {

	 

	public static JSONArray ParseJson(String Key, String jsonfilepath) throws Exception {

		String file;
		JSONArray exampleArray = new JSONArray();
		file = convertFileIntoString(jsonfilepath);  
		System.out.println(file);  
		String searchKey = Key;
		String inputJson = file;
		if (inputJson.startsWith("[")){
			JSONArray inputJSONArray = new JSONArray(inputJson);
			for (int i = 0; i < inputJSONArray.length(); i++) {
				JSONObject inputJSONOBject = (JSONObject) inputJSONArray.get(i);
				if(inputJSONOBject.has(searchKey)) {
					//System.out.print(inputJSONOBject.get(searchKey) );
					exampleArray.put(inputJSONOBject.get(searchKey) );
					inputJSONOBject.remove(searchKey);
				}
				getKey(inputJSONOBject, searchKey,exampleArray);
			}
		}
		else {
			JSONObject inputJSONOBject = new JSONObject(inputJson);
			if(inputJSONOBject.has(searchKey)) {
				//System.out.print(inputJSONOBject.get(searchKey) );
				exampleArray.put(inputJSONOBject.get(searchKey) );
				inputJSONOBject.remove(searchKey);
			}
			getKey(inputJSONOBject, searchKey,exampleArray);
		}
		/*System.out.print("Output String array will be : ");
		for (int i = 0; i < exampleArray.length(); i++) {
			System.out.print(exampleArray.get(i) + " ");
		}*/
		return exampleArray;
	}

	public static void parseObject(JSONObject json, String key,JSONArray exampleArray) throws JSONException {
		// System.out.println(json.has(key));
		//System.out.println(json.get(key));
		exampleArray.put(json.get(key));

	}

	public static void getKey(JSONObject json, String key,JSONArray exampleArray) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {

					if (json.get(nextKeys) instanceof JSONObject) {

						if (exists == false) {
							getKey(json.getJSONObject(nextKeys), key,exampleArray);
						}

					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							if (!(jsonarrayString.startsWith("["))){
								JSONObject innerJSOn = new JSONObject(jsonarrayString);

								if (exists == false) {
									getKey(innerJSOn, key,exampleArray);
								}
							}
							else {
								JSONArray innerJSOnarray = new JSONArray(jsonarrayString);
								for (int j = 0; j < innerJSOnarray.length(); j++) {
									JSONObject innerJSOnobj = (JSONObject) innerJSOnarray.get(j);
									if (exists == false) {
										getKey(innerJSOnobj, key,exampleArray);
									}
								}
							}
						}

					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		} else {
			parseObject(json, key, exampleArray);
		}

	}



	public static String convertFileIntoString(String file)throws Exception  
	{  
		// declare a variable in which we store the JSON data as a string and return it to the main() method  
		String result;   
		// we use readAllBytes() method of Files to read byted data from the files  
		result = new String(Files.readAllBytes(Paths.get(file)));  
		// return result to the main() method  
		return result;  
	}  
}