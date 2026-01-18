package a.restassuredd.basicss;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CChapterPutMethod {
    public static void main(String[] args) {

        /*
        Points to Remember
        The PUT Method is used to create update Entire Body Resource
        Some Prerequisites are required
        given() & with() both are used to build the request Specification -- Optional
        Request Body  -- Mandate
        Headers  -- Mandate
        Path Params or Query Params Needed to Update Existing Resource -- Manadate
        Authenication (Optional Depends on the API Contract)

Technique 1
        Example - given request Specification

        Response putResponse = RestAssured
                .given()   ---- given must be first method
                .body("{ \"name\": \"Khushi\", \"age\": 2 }")  -- This is not sequential order
                .header("Content-Type", "application/json") ---  This is also not sequential order
                .put();  -- put must be last method

Technique 2
 Example - with request Specification

        Response putResponse = RestAssured
                .with()   ---- given must be first method
                .body("{ \"name\": \"Khushi\", \"age\": 2 }")  -- This is not sequential order
                .header("Content-Type", "application/json") ---  This is also not sequential order
                .put();  -- put must be last method
         */


        RestAssured.baseURI = "http://localhost:8080";
//        RestAssured.basePath = "/students ,6y";  // This is Commented as path is Provided in the put() -- refer loc 52


        //Technique 1 with Request Specification

        // ✅ Direct Put call without .given()
        String studentBodyPayload = "{ \"name\": \"Sunitaa Kamra\", \"age\": 70 }";

        Response putResponse = RestAssured
                .with()   // shortcut for request specification
                .body(studentBodyPayload)
                .header("Content-Type", "application/json")  // while put method header is mandate, without header is not possible.
                .put("/students/{id}", 4);  // we have defined path & Unique ID is Provided to update Existing Resource

        // Another Way to get the Status Code & Response Body
        int getAPIStatusCodeValue= putResponse.getStatusCode();
        System.out.println("The Status Code of API is Stored as:"+getAPIStatusCodeValue);


        String getAPIResponseBodyValue= putResponse.getBody().asString();
        System.out.println("The Response Body of API is Stored as:"+getAPIResponseBodyValue);

        System.out.println("Status Code Method in sout: " + putResponse.getStatusCode());  // getStatusCode() returns put Response status code
        System.out.println("Response Body Method in sout: " + putResponse.getBody().asString());  // asString() helps to displays actual put Response

        Long studentId = putResponse.jsonPath().getLong("id"); // To Retrieve any field value is jsonPath() useful, jsonPath() is the inbuilt method of JsonPath class. getLong() used as field data type is long so return type as long
        System.out.println("Auto-generated Student ID: " + studentId);

        // Retrieve String field value
        String getNameValue = putResponse.jsonPath().getString("name"); // Here Return type is String & we have used getString() as the field type is String
        System.out.println("Retrieved name field value is : " + getNameValue); // prints name field value


        // Retrieve Invalid field value
        String getInvalidFieldValue = putResponse.jsonPath().getString("namee"); // trying to retrieve invalid field value
        System.out.println("Retrieved Invalid field value is : " + getInvalidFieldValue);   // it returns null as field is invalid

        /* InCorrect Way Validating put method Response through get Method as Address is ❌ http://localhost:8080/4.

         */

        System.out.println(" /* InCorrect Way Validating Put method Response through get Method */");
        Response getResponse = RestAssured.get(String.valueOf(studentId));  //  as our id return type is long to convert long datatype value into String then (String.valueOf(studentId)) is used
        System.out.println("GET Status Code: " + getResponse.getStatusCode());
        System.out.println("GET Response Body: " + getResponse.getBody().asString());

        System.out.println("/* Corrected Way - Validating Put method Response through get Method */");

        /* Corrected Way - Validating put method Response through get Method */
        Response getResponse2 = RestAssured.get("/students/" + studentId);
        System.out.println("GET Status Code: " + getResponse2.getStatusCode());
        System.out.println("GET Response Body: " + getResponse2.getBody().asString());

        //Response Body in Beautified format

        String getAPIResponseBodyValueBeautified= putResponse.getBody().asPrettyString();  //  asPrettyString() helps to Beautify the putResponse
        System.out.println("The Response Body of API is Stored as Beautified Format\n:"+getAPIResponseBodyValueBeautified);


//        //Technique 2 given Request Specification
//
//        Response putResponse = RestAssured
//                .given()
//                .body("{ \"name\": \"Khushi\", \"age\": 2 }")
//                .header("Content-Type", "application/json")
//                .put();
//
//        System.out.println("PUT Status Code: " + putResponse.getStatusCode());
//        System.out.println("PUT Response Body: " + putResponse.getBody().asString());
//
//
//        Long studentId2 = putResponse.jsonPath().getLong("id");
//        System.out.println("Auto-generated Fetched Student ID: " + studentId2);
//
//        Response getResponse2 = RestAssured.get(String.valueOf(studentId));
//        System.out.println("GET Status Code: " + getResponse2.getStatusCode());
//        System.out.println("GET Response Body: " + getResponse2.getBody().asString());

    }
}