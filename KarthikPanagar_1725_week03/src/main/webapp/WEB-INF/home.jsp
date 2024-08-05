<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
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
    max-width: 500px;
    width: 100%;
}

h1 {
    color: #e74c3c;
    margin-bottom: 20px;
    font-weight: 700;
}

.welcome-message {
    margin-bottom: 20px;
    font-size: 18px;
    color: #555;
}

.links {
    margin-top: 20px;
}

.btn {
    display: inline-block;
    background-color: #e74c3c;
    color: white;
    padding: 10px 20px;
    border-radius: 5px;
    text-decoration: none;
    font-size: 16px;
    margin: 5px;
    transition: background-color 0.3s, transform 0.2s;
}

.btn:hover {
    background-color: #c0392b;
}

.logout {
    background-color: #333;
    color: #ffffff;
}

.logout:hover {
    background-color: #555;
}
    
    </style>
</head>
<body>
    <div class="container">
        <h1>Home</h1>
        <p class="welcome-message">Welcome, <%= session.getAttribute("userName") %></p>
        <div class="links">
            <a href="NavigationServlet?page=addOrder" class="btn">Place Order</a>
            <a href="NavigationServlet?page=addItem" class="btn">Add Item</a>
            <a href="NavigationServlet?page=removeItem" class="btn">Remove Item</a>
            <a href="NavigationServlet?page=logout" class="btn logout">Logout</a>
        </div>
    </div>
</body>
</html>
