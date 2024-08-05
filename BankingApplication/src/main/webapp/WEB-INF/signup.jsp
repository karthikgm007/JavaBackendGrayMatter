


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User SignUp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>User SignUp</h1>
    <form action="SignupServlet" >
        <label for="first_name" class="form-label">First Name:</label>
        <input type="text" id="first_name" name="first_name" class="form-control" required>
        <label for="last_name" class="form-label">Last Name:</label>
        <input type="text" id="last_name" name="last_name" class="form-control" required>
        

        <label for="email" class="form-label">Email:</label>
        <input type="email" id="email" name="email" class="form-control" required>
 
        <label for="password" class="form-label">Password:</label>
        <input type="password" id="password" name="password" class="form-control" required>
 

        <label for="phone_number" class="form-label">Phone Number:</label>
        <input type="tel" id="phone_number" name="phone_number" class="form-control">

        <label for="address" class="form-label">Address:</label>
        <input type="text" id="address" name="address" class="form-control">
        <input type="submit" class="btn btn-primary" value="Sign Up">
    </form>
</body>
</html>