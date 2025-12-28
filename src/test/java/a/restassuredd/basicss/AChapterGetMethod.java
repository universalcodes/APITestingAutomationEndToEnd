package a.restassuredd.basicss;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.concurrent.TimeUnit;

public class AChapterGetMethod {
    public static void main(String[] args) {

        /*
        Points to Remember
        RestAssured is the class which contains different methods
        .get .post .delete .put
        // Response is the Interface which initiates the RestAssured Class
        //.get() is the inbuilt method which helps to invoke get method of API
          /*
        Response is the interface which contains:
        getStatusCode(); returns response level status code
        getStatusLine(); returns response level statusLine
         getBody(); returns response body Object instead of Actual API Response
         getPrettyString(); returns response level Actual API Response
         getContentType(); returns response level Actual Content Type of Tested API
           ContentType(); returns  response level Actual Content Type of Tested API
            getHeaders(); returns response level all Headers of the API
         getHeader(); returns response level one Header of the API

         */



       RestAssured.baseURI="http://localhost:8080";  // baseURI is the inbuilt static property of RestAssured Class which is used to set the base URI which is also called Domain
       RestAssured.basePath="/students"; //  // basePath is the inbuilt static property of RestAssured Class which is used to set the base path.

        System.out.println("Validated Response Interface Object  ");
        Response validateDifferentResponse = RestAssured.get();  // Response is the Interface which initiates the RestAssured Class //.get() is the inbuilt method which helps to invoke get method of API
        System.out.println(validateDifferentResponse);  // Returns Response Object Reference

        System.out.println("Validated Content Type Response Level");
        String getAPIContentType = validateDifferentResponse.contentType();  // contentType() helps to Response level Content Type of the API.  Return type of contentType() is String
        System.out.println("Get ContentType of API: " + getAPIContentType);

        System.out.println("Validated Get Content Type Response Level");
        String getAPIContentTypes = validateDifferentResponse.getContentType();  // getContentType() helps to Response level Content Type of the API.  Return type of contentType() is String
        System.out.println("Get ContentType of API: " + getAPIContentTypes);

        System.out.println("Validated One Header Response Level");
        String getAPISingleHeader = validateDifferentResponse.getHeader("Connection");  //  getHeader(String) helps to get one Header Response level of the API. In Parameter user has to pass one Header field, it returns value. In our Example id is the header field & it returns id value// Return type of getHeader("id") is String
        System.out.println("Get One Header  of API: " + getAPISingleHeader);
        
        System.out.println("Validated All Header Response Level");
        Headers getAPIHeaderDetails = validateDifferentResponse.getHeaders();  // getHeaders() helps to get all Headers Response level of the API . Return type is Headers. Headers is the Inbuilt Class of RestAssured Lib
        System.out.println("Get All Headers of API: " + getAPIHeaderDetails);

        System.out.println("Validated Response Status Code");
        int getStatusCode = validateDifferentResponse.getStatusCode();  // getStatusCode() helps to get response status code of API. Return type is int as its number
        System.out.println("Status Code: " + getStatusCode);

        System.out.println("Validated Response Status Line");
        String getStatusLine = validateDifferentResponse.getStatusLine();  // getStatusLine() helps to get response status line of API. Return type is String as its groups of Characters
        System.out.println("Status Line: " + getStatusLine);

        System.out.println("Validated Response Body Object");
        ResponseBody getResponseBodyObject = validateDifferentResponse.getBody();  //.getBody(); is the inbuilt method where its returns' responseBody Object instead of Actual Response. Return type is ResponseBody
        System.out.println("Response Body Object: " + getResponseBodyObject);


        System.out.println("Validated Response Body Object 2");
        ResponseBody getBodyObject = validateDifferentResponse.body();  //.body(); is the inbuilt method where its returns' responseBody Object instead of Actual Response. Return type is ResponseBody
        System.out.println("Response Body: " + getBodyObject);

        System.out.println("Validated Actual API Response Body ");
        String getResponseBodyAsPrettyStr = validateDifferentResponse.asPrettyString();  //.asPrettyString(); is the inbuilt method where its returns' response with proper format. Return type is String  as its groups of Characters
        System.out.println("Response Body as Pretty String: " + getResponseBodyAsPrettyStr);

        System.out.println("Validated Time Spent in Mili Seconds on API Execution");
        long timeTakenForAPIInMS = validateDifferentResponse.getTime();  // getTime() helps to get total time execution for API Result. Return type is as long as its 64-bit Number, By Default time type is Milli Second
        System.out.println("Response Time Taken in Mili Seconds: " + timeTakenForAPIInMS);

        System.out.println("Validated Time Spent in  Seconds on API Execution");
        long timeTakenForAPIInMinutes = validateDifferentResponse.getTimeIn(TimeUnit.SECONDS);  // getTime() helps to get total time execution for API Result. Return type is as long as its 64-bit Number, TimeUnit is the Enum where .SECONDS in the Enum Constant
        System.out.println("Response Time Taken in Seconds: " + timeTakenForAPIInMinutes);


        System.out.println("Result Based on API Responses on SOUT No Return Type is Used");

        Response res = RestAssured.get();
        System.out.println("Status Code: " + res.getStatusCode());        //  returns API Response Status Code
        System.out.println("Status Line: " + res.getStatusLine());        //  returns API Response Status Line
        System.out.println("Content Type: " + res.getContentType());      //  returns API Response ContentType
        System.out.println("Single Header (Connection): " + res.getHeader("Connection")); // returns API Response One Header
        System.out.println("All Headers: " + res.getHeaders());           // returns API Response All Headers
        System.out.println("Response Body Object:\n" + res.getBody()); // returns getBody Object
        System.out.println("Response Body:\n" + res.getBody().asPrettyString()); // returns API Response with Body
//        System.out.println("Response Time (ms): " + res.getTime());       // returns API Execution Time Spent in Mili Seconds
        System.out.println("Response Time in (sec): " + res.getTimeIn(TimeUnit.SECONDS)); // returns API Execution Time Spent in Seconds
    }
}
