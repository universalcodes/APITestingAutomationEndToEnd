package a.restassuredd.basicss;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EChapterDeleteMethod {
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

        Response deleteMethodTest = RestAssured
                .given()   ---- given must be first method
                .body("{ \"name\": \"Khushi\", \"age\": 2 }")  -- This is not sequential order
                .header("Content-Type", "application/json") ---  This is also not sequential order
                .delete();  -- delete is the method which is used to delete the existing resource,
                delete method is also used in place of put method as both are same in nature
                but delete method is used to delete the existing resource and put method is used to update the existing resource.

Technique 2
 Example - with request Specification

        Response deleteMethodTest = RestAssured
                .with()   ---- given must be first method
                .body("{ \"name\": \"Khushi\", \"age\": 2 }")  -- This is not sequential order
                .header("Content-Type", "application/json") ---  This is also not sequential order
                .delete();  -- delete is the method which is used to delete the existing resource,
                delete method is also used in place of put method as both are same in nature
                but delete method is used to delete the existing resource and put method is used to update the existing resource.

         */


        RestAssured.baseURI = "http://localhost:8080";
        //RestAssured.basePath="/students"; //  // basePath is the inbuilt static property of RestAssured Class which is used to set the base path.

//        RestAssured.basePath = "/students ,6y";  // This is Commented as path is Provided in the put() -- refer loc 52


        //Technique 1 with Request Specification

        // ✅ Direct Put call without .given()
        String studentBodyPayload = "{ \"name\": \"Khushi\", \"age\": 2 }";

        Response deleteMethodTest = RestAssured
                .with()   // shortcut for request specification
                .body(studentBodyPayload)
                .header("Content-Type", "application/json")  // while put method header is mandate, without header is not possible.
                .delete("/students/{id}", 7);  // we have defined path & Unique ID is Provided to delete Existing Resourc


        // Another Way to get the Status Code & Response Body
        int getAPIStatusCodeValue = deleteMethodTest.getStatusCode();
        System.out.println("The Status Code of API is Stored as:" + getAPIStatusCodeValue);

        String getAPIResponseBodyValue = deleteMethodTest.getBody().asString();
        System.out.println("The Response Body of API is Stored as:" + getAPIResponseBodyValue);

        Response validateResponseAfterDelete = RestAssured.get("/students");  // Response is the Interface which initiates the RestAssured Class //.get() is the inbuilt method which helps to invoke get method of API

        System.out.println("Validated Actual API Response Body After Delete ");
        String getResponseBodyAsPrettyStr = validateResponseAfterDelete.asPrettyString();  //.asPrettyString(); is the inbuilt method where its returns' response with proper format. Return type is String  as its groups of Characters
        System.out.println("Response Body as Pretty String: " + getResponseBodyAsPrettyStr);

    }
}