<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            max-width: 600px;
            margin: auto;
            border: 1px solid #ccc;
            border-radius: 10px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="number"], input[type="password"], input[type="text"], input[type="decimal"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h2>Account Registration Form</h2>

    <form action="CreateAccountServlet">
      <input type="hidden" id="storedEmail" name="email">
       <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="account_pin">Account PIN:</label>
            <input type="password" id="account_pin" name="account_pin" required>
        </div>
        <div class="form-group">
            <label for="balance">Balance:</label>
            <input type="number" step="0.01" id="balance" name="balance" value="0.00" required>
        </div>
        <div class="form-group">
            <label for="ifsc">IFSC Code:</label>
            <input type="text" id="ifsc" name="ifsc" maxlength="10">
        </div>
        <div class="form-group">
            <label for="branch">Branch:</label>
            <input type="text" id="branch" name="branch" maxlength="255">
        </div>
        <div class="form-group">
            <label for="ifsc">Aadhaar :</label>
            <input type="text" id="aadhaar" name="aadhaar" maxlength="55">
        </div>
        <div class="form-group">
            <label for="pan"> PAN:</label>
            <input type="text" id="pan" name="pan" maxlength="55">
        </div>
        <button type="submit">Submit</button>
    </form>

	<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function() {
		    var email = localStorage.getItem("email");
		    document.getElementById("storedEmail").value = email;
		});
	</script>
</body>
</html>
