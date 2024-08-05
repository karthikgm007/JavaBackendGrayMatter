<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            padding: 50px;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }
        h1 {
            color: #333;
        }
        .btn {
            display: block;
            width: 200px;
            padding: 10px;
            margin: 10px auto;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Dashboard</h1>
        <a href="updateUserDetails.jsp" class="btn">Update your details</a>
        <a href="withdraw.jsp" class="btn">Withdraw</a>
        <a href="deposit.jsp" class="btn">Deposit</a>
        <a href="changePIN.jsp" class="btn">Change PIN</a>
        <a href="deleteAccount.jsp" class="btn">Delete Account</a>
    </div>
</body>
</html>
