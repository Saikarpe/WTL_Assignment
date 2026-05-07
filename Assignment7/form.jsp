<%@ page language="java" %>

<html>
<head>
    <title>Employee CRUD (JSP)</title>

    <script>
        function showFields(choice) {
            idDiv.style.display = "none";
            nameDiv.style.display = "none";
            salaryDiv.style.display = "none";

            if (choice == "1") {
                idDiv.style.display = "block";
                nameDiv.style.display = "block";
                salaryDiv.style.display = "block";
            }
            else if (choice == "2") {
                idDiv.style.display = "block";
            }
            else if (choice == "3") {
                idDiv.style.display = "block";
                nameDiv.style.display = "block";
                salaryDiv.style.display = "block";
            }
        }
    </script>
</head>

<body>

<h2>Employee CRUD (JSP)</h2>

<form action="Crud.jsp" method="post">

    Select Operation:
    <select name="ch" onchange="showFields(this.value)" required>
        <option value="">--Select--</option>
        <option value="1">Insert</option>
        <option value="2">Delete</option>
        <option value="3">Update</option>
        <option value="4">Read</option>
    </select>

    <br><br>

    <div id="idDiv" style="display:none;">
        ID: <input type="text" name="id"><br><br>
    </div>

    <div id="nameDiv" style="display:none;">
        Name: <input type="text" name="name"><br><br>
    </div>

    <div id="salaryDiv" style="display:none;">
        Salary: <input type="text" name="salary"><br><br>
    </div>

    <input type="submit" value="Submit">

</form>

</body>
</html>
