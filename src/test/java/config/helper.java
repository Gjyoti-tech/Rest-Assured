package config;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class  helper {
	public static int decide(String request,String url)
	{
		int status;
		if(request.equals("GET"))
			 {
			     status=GETURL(url);
			 }
		else if(request.equals("POST"))
		 {
		    status=POSTURL(url);
		 }
		else if(request.equals("DELETE"))
		 {
		     status=DELETEURL(url);
		 }
		else
		 {
		     status=PUTURL(url);
		 }
		return status;
	}
	public  static int  GETURL(String url)
	{
		Response res=RestAssured.get(url);
		int actual=res.getStatusCode();
		return actual;
	}
	public static int POSTURL(String url)
	{
		RequestSpecification req=RestAssured.given();
		   req.header("Content-Type","application/json");
		   JSONObject json =new JSONObject();
		   json.put("userId","11");
		   json.put("id","201");
		   json.put("title", "post");
		   json.put("body","created");
		   
		   req.body(json.toString());
		   Response res=req.post(url);
		   int actual=res.getStatusCode();
		   return actual;
		   
		
	}
	public static int DELETEURL(String url)
	{
		RequestSpecification req=RestAssured.given();
        Response res=req.delete(url);
        int actual=res.getStatusCode();
        return actual;
	}
	public static int PUTURL(String url)
	{
		RequestSpecification req=RestAssured.given();
		JSONObject json=new JSONObject();
		json.put("userId","1");
		json.put("id","5");
		json.put("title","updated");
		json.put("body","updated");
		Response res=req.put(url);
		int actual=res.getStatusCode();
		return actual;
	}

}
