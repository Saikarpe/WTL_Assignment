<?php

 $servername = "localhost";
 $username = "root";
 $password = "";
 $dbname = "student";

 $conn = new mysqli($servername, $username, $password, $dbname);

if (!$conn) {
    die("Connection Failed: " );
}

$query= "SELECT * FROM students";

$result = mysqli_query($conn, $query);

if (mysqli_num_rows($result) > 0) {

    while ($row = mysqli_fetch_assoc($result)) {

        echo "Roll No: " . $row['Roll_No'] . "<br>";
        echo "Name: " . $row['Name'] . "<br>";
        echo "Marks: " . $row['Marks'] . "<br><br>";

    }

} else {
    echo "No records found";
}

echo '<br><a href="Forms.html">Back to Main Page</a>';

mysqli_close($conn);

?>