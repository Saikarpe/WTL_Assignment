<?php
 $servername = "localhost";
 $username = "root";
 $password = "";
 $dbname = "student";

 $conn = new mysqli($servername, $username, $password, $dbname);

if (!$conn) {
    die("Connection Failed: ");
}
    $roll = $_POST['rollno1'];  

    $query = "DELETE FROM students WHERE Roll_No='$roll'";

    $result = mysqli_query($conn, $query);

    if ($result) {
        echo "Record Deleted Successfully";
    } else {
        echo "Error: ";
    }

echo '<br><a href="Forms.html">Back to Main Page</a>';

mysqli_close($conn);

?>