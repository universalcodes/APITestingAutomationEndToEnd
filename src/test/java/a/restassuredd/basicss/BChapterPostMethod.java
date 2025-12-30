package a.restassuredd.basicss;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BChapterPostMethod {
    public static void main(String[] args) {

        /*
        Points to Remember
        The POST Method is used to create New Resource
        Some Prerequisites are required
        given() & with() both are used to build the request Specification -- Optional
        Request Body  -- Mandate
        Headers  -- Mandate
        Authenication (Optional Depends on the API Contract)

Technique 1
        Example - given request Specification

        Response postResponse = RestAssured
                .given()   ---- given must be first method
                .body("{ \"name\": \"Khushi\", \"age\": 2 }")  -- This is not sequential order
                .header("Content-Type", "application/json") ---  This is also not sequential order
                .post();  -- post must be last method 

Technique 2
 Example - with request Specification

        Response postResponse = RestAssured
                .with()   ---- given must be first method
                .body("{ \"name\": \"Khushi\", \"age\": 2 }")  -- This is not sequential order
                .header("Content-Type", "application/json") ---  This is also not sequential order
                .post();  -- post must be last method
         */


        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/students";


        //Technique 1 with Request Specification

        // ✅ Direct POST call without .given()
        String studentBodyPayload = "{ \"name\": \"Khushi\", \"age\": 2 }";

        Response response = RestAssured
                .with()   // shortcut for request specification
                .body(studentBodyPayload)
                .header("Content-Type", "application/json")  // while post method header is mandate, without header is not possible.
                .post();

        System.out.println("Status Code: " + response.getStatusCode());  // getStatusCode() returns response status code
        System.out.println("Response Body: " + response.getBody().asString());  // asString() helps to displays actual response

        Long studentId = response.jsonPath().getLong("id"); // To Retrieve any field value is jsonPath() useful, jsonPath() is the inbuilt method of JsonPath class. getLong() used as field data type is long so return type as long
        System.out.println("Auto-generated Student ID: " + studentId);

        // Retrieve String field value
        String getNameValue = response.jsonPath().getString("name"); // Here Return type is String & we have used getString() as the field type is String
        System.out.println("Retrieved name field value is : " + getNameValue); // prints name field value


        // Retrieve Invalid field value
        String getInvalidFieldValue = response.jsonPath().getString("namee"); // trying to retrieve invalid field value
        System.out.println("Retrieved Invalid field value is : " + getInvalidFieldValue);   // it returns null as field is invalid

        /* Validating Posted method Response through get Method */


        Response getResponse = RestAssured.get(String.valueOf(studentId));  //  as our id return type is long to convert long datatype value into String then (String.valueOf(studentId)) is used
        System.out.println("GET Status Code: " + getResponse.getStatusCode());
        System.out.println("GET Response Body: " + getResponse.getBody().asString());

        //Technique 2 given Request Specification

        Response postResponse = RestAssured
                .given()
                .body("{ \"name\": \"Khushi\", \"age\": 2 }")
                .header("Content-Type", "application/json")
                .post();

        System.out.println("POST Status Code: " + postResponse.getStatusCode());
        System.out.println("POST Response Body: " + postResponse.getBody().asString());


        Long studentId2 = postResponse.jsonPath().getLong("id");
        System.out.println("Auto-generated Fetched Student ID: " + studentId2);

        Response getResponse2 = RestAssured.get(String.valueOf(studentId));
        System.out.println("GET Status Code: " + getResponse2.getStatusCode());
        System.out.println("GET Response Body: " + getResponse2.getBody().asString());


    }
}