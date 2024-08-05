<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="loginStyles.css">
    <style type="text/css">
    body {
    font-family: 'Arial', sans-serif;
    background-color: #f8f8f8;
    color: #333;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    margin: 0;
}

.container {
    background-color: #ffffff;
    padding: 20px 40px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;
}

h1 {
    color: #e74c3c;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 15px;
    text-align: left;
}

label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

input[type="email"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

input[type="submit"].btn {
    background-color: #e74c3c;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    margin-top: 20px;
}

input[type="submit"].btn:hover {
    background-color: #c0392b;
}

.signup-link {
    display: block;
    margin-top: 15px;
    color: #2980b9;
    text-decoration: none;
}

.signup-link:hover {
    text-decoration: underline;
}
    
    </style>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" required>
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password" required>
            </div>
            <input type="submit" value="Login" class="btn">
        </form>
        
    </div>
</body>
</html>
