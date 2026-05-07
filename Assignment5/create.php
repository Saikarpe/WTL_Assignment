<?php

 $servername = "localhost";
 $username = "root";
 $password = "";
 $dbname = "student";

 $conn = mysqli_connect($servername, $username, $password, $dbname);

 if(!$conn)
    die("Connection failed");
 else
    echo "Connected to database successful"."<br>";
 
 $name = $_POST['name1'];
 $marks = $_POST['mark1'];
 $roll = $_POST['rollno1'];

 $query = "INSERT INTO students(Roll_NO, Name, Marks) VALUES ('$roll', '$name', '$marks')";
 
 $result = mysqli_query($conn,$query);

if($result){
    echo ("Record inserted Successfully.");
} else {
    echo ("Operation Failed");
}

echo '<br><a href="Forms.html">Back to Main Page</a>';

mysqli_close($conn);

?>