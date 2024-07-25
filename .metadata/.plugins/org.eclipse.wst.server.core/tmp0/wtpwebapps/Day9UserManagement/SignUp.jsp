<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
</head>
<body>

 <form action="UserServlet" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    
    <label for="id">UserId:</label>
    <input type="text" id="id" name="id" required>
    
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    
    <label for="mobile">Mobile Number:</label>
    <input type="text" id="mobile" name="mobile" pattern="\d{10}" required>
    
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
        
    <button type="submit">Submit</button>
 </form>

</body>
</html>
