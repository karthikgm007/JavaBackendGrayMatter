<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome -  QuickBite</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
    <style type="text/css">
    body {
    font-family: 'Roboto', sans-serif;
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
    padding: 30px 50px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;
}

h1 {
    color: #e74c3c;
    margin-bottom: 30px;
    font-weight: 700;
}

.radio-group {
    margin-bottom: 20px;
    display: flex;
    justify-content: space-around;
    align-items: center;
}

input[type="radio"] {
    display: none;
}

input[type="radio"] + label {
    display: inline-block;
    padding: 10px 20px;
    border: 2px solid #e74c3c;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s, color 0.3s;
}

input[type="radio"]:checked + label {
    background-color: #e74c3c;
    color: #ffffff;
}

input[type="radio"] + label:hover {
    background-color: #e74c3c;
    color: #ffffff;
}

.submit-btn {
    background-color: #e74c3c;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    margin-top: 20px;
}

.submit-btn:hover {
    background-color: #c0392b;
}
    
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to QuickBite</h1>
        <form action="ProcessSelection">
            <div class="radio-group">
                <input type="radio" id="login" name="action" value="login" required>
                <label for="login">Login</label>
                <input type="radio" id="signup" name="action" value="signup" required>
                <label for="signup">Signup</label>
            </div>
            <input type="submit" value="Submit" class="submit-btn">
        </form>
    </div>
</body>
</html>
