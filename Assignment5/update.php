<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "student";

$conn = mysqli_connect($servername, $username, $password, $dbname);
if (!$conn) {
    die("Connection Failed: ");
}
    $roll  = $_POST['rollno1'];
    $name  = $_POST['name1'];
    $marks = $_POST['mark1'];

    $q = "UPDATE students 
          SET Name='$name', Marks='$marks' 
          WHERE Roll_No='$roll'";

    $result = mysqli_query($conn, $q);

    if ($result) {
        echo "Record Updated Successfully";
    } else {
        echo "Error: can't update record";
    }

echo '<br><a href="Forms.html">Back to Main Page</a>';

mysqli_close($conn);

?>