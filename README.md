
📘 REST Assured – End To End Project
🔎 Overview
This repository demonstrates how to use RestAssured in Java for API testing.
We cover (GET), (POST), and (PUT) methods step‑by‑step with key concepts, prerequisites, and validations.

GET Method
✅ Covered Topics
- Introduction to RestAssured class and Response interface
- Base configuration:
- baseURI → domain
- basePath → resource path
- Response validations:
- getStatusCode() → status code
- getStatusLine() → status line
- getContentType() / contentType() → content type
- getHeader(String) → single header
- getHeaders() → all headers
- Response body handling:
- getBody() / body() → response body object
- asPrettyString() → formatted response body
- Execution time measurement:
- getTime() → milliseconds
- getTimeIn(TimeUnit.SECONDS) → seconds

📅 Day 2 – POST Method
✅ Covered Topics
- Purpose of POST → create new resource
- Prerequisites:
- Request body (mandatory)
- Headers (mandatory, e.g., Content-Type: application/json)
- Authentication (optional)
- Request specification techniques:
- .given() → build request specification
- .with() → shortcut for request specification
- Response handling:
- getStatusCode() → validate response
- getBody().asString() → raw response body
- jsonPath().getLong("id") → extract numeric field
- jsonPath().getString("name") → extract string field
- Handling invalid field extraction (returns null)
- Validation with GET:
- Using RestAssured.get(String.valueOf(studentId)) to validate newly created resource
- Comparison of techniques:
- Technique 1: .with()
- Technique 2: .given()

📅 Day 3 – PUT Method
✅ Covered Topics
- Purpose of PUT → update or replace existing resource
- Prerequisites:
- Request body (mandatory)
- Headers (mandatory)
- Path params or query params (mandatory for identifying resource)
- Authentication (optional)
- Request specification techniques:
- .given() → build request specification
- .with() → shortcut for request specification
- Response handling:
- getStatusCode() → validate response
- getBody().asString() → raw response body
- jsonPath().getLong("id") → extract numeric field
- jsonPath().getString("name") → extract string field
- Handling invalid field extraction (returns null)
- Validation with GET:
- Incorrect way → http://localhost:8080/4
- Correct way → http://localhost:8080/students/4
- Beautified response:
- asPrettyString() → formatted response body

🧾 Notes
- GET → Retrieve resource
- POST → Create new resource
- PUT → Update existing resource
- Always use Content-Type: application/json header for JSON payloads.
- Use jsonPath() for extracting values from response body.
- Validate responses with GET after POST/PUT operations.


✨ With this roadmap, you now have a Day‑wise structured guide for mastering RestAssured basics in API testing.
👉 Next step, I can extend README with (DELETE Method) topics to complete the CRUD cycle. Would you like me to add that section too?

## 🛠️ Technologies Used

- **Java**
- **Rest Assured**
- **Maven**
- **IntelliJ IDEA**

---

## ▶️ How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/universalcodes/APITestingAutomationEndToEnd.git
