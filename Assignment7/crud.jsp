<%@ page import="java.sql.*" %>

<html>
<body>

<%
try {

    String chParam = request.getParameter("ch");

    if (chParam == null || chParam.isEmpty()) {
        out.println("Please select operation");
        return;
    }

    int ch = Integer.parseInt(chParam);

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/empdb",
        "root",
        "Saikarpe123#@"
    );

    if (ch == 1) {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int salary = Integer.parseInt(request.getParameter("salary"));

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO emp(id, ename, esalary) VALUES (?, ?, ?)"
        );

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, salary);

        int rows = ps.executeUpdate();
        out.println("<h3>Inserted Successfully: " + rows + "</h3>");
    }

    else if (ch == 2) {

        int id = Integer.parseInt(request.getParameter("id"));

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM emp WHERE id = ?"
        );

        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        out.println("<h3>Deleted Successfully: " + rows + "</h3>");
    }

    else if (ch == 3) {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int salary = Integer.parseInt(request.getParameter("salary"));

        PreparedStatement ps = con.prepareStatement(
            "UPDATE emp SET ename=?, esalary=? WHERE id=?"
        );

        ps.setString(1, name);
        ps.setInt(2, salary);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();
        out.println("<h3>Updated Successfully: " + rows + "</h3>");
    }

    else if (ch == 4) {

        PreparedStatement ps = con.prepareStatement("SELECT * FROM emp");
        ResultSet rs = ps.executeQuery();

        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Salary</th></tr>");

        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("ename") + "</td>");
            out.println("<td>" + rs.getInt("esalary") + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
    }

    con.close();

} catch(Exception e) {
    out.println(e);
}
%>

<br><br>
<a href="form.jsp">Go Back</a>

</body>
</html>
