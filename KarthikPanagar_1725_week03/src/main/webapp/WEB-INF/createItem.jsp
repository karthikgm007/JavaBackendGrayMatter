<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Item</title>
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

.form-group {
    margin-bottom: 20px;
    text-align: left;
}

label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

input[type="text"],
input[type="number"] {
    width: calc(100% - 22px);
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 14px;
}

input[type="text"]:focus,
input[type="number"]:focus {
    border-color: #e74c3c;
    outline: none;
}

.btn {
    background-color: #e74c3c;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    margin-top: 20px;
    text-decoration: none;
    display: inline-block;
}

.btn:hover {
    background-color: #c0392b;
}

.back-link {
    background-color: #333;
    color: #ffffff;
    text-decoration: none;
}

.back-link:hover {
    background-color: #555;
}
    
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Item</h1>
        <form action="AddItemServlet" method="post">
            <div class="form-group">
                <label for="name">Item Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="cost">Cost:</label>
                <input type="number" id="cost" name="cost" step="0.01" required>
            </div>
            <input type="submit" value="Add Item" class="btn">
        </form>
    </div>
</body>
</html>
