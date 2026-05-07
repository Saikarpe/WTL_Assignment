package demo_Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 */
@WebServlet("/sample")
public class sample extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String chParam = request.getParameter("ch");

            if (chParam == null || chParam.isEmpty()) {
                out.println("<h3>Please select an operation</h3>");
                return;
            }

            int ch = Integer.parseInt(chParam);

            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/empdb",
                    "root",
                    "Saikarpe123#@"
            );

            out.println("<html><body>");
            out.println("<h2>Result</h2>");

            // 🔹 INSERT
            if (ch == 1) {

                String en = request.getParameter("name");
                String idParam = request.getParameter("id");
                String salParam = request.getParameter("salary");

                if (idParam.isEmpty() || salParam.isEmpty() || en.isEmpty()) {
                    out.println("<h3>All fields are required</h3>");
                } else {
                    int eid = Integer.parseInt(idParam);
                    int es = Integer.parseInt(salParam);

                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO emp(id, ename, esalary) VALUES (?, ?, ?)"
                    );
                    ps.setInt(1, eid);
                    ps.setString(2, en);
                    ps.setInt(3, es);

                    int rows = ps.executeUpdate();
                    out.println("<h3>Inserted Successfully. Rows: " + rows + "</h3>");
                }
            }

            // 🔹 DELETE
            else if (ch == 2) {

                String idParam = request.getParameter("id");

                if (idParam == null || idParam.trim().isEmpty()) {
                    out.println("<h3>ID is required for delete</h3>");
                } else {
                    int eid = Integer.parseInt(idParam);

                    PreparedStatement ps = con.prepareStatement(
                            "DELETE FROM emp WHERE id = ?"
                    );
                    ps.setInt(1, eid);

                    int rows = ps.executeUpdate();
                    out.println("<h3>Deleted Successfully. Rows: " + rows + "</h3>");
                }
            }

            // 🔹 UPDATE
            else if (ch == 3) {

                String en = request.getParameter("name");
                String idParam = request.getParameter("id");
                String salParam = request.getParameter("salary");

                if (idParam.isEmpty() || salParam.isEmpty() || en.isEmpty()) {
                    out.println("<h3>All fields are required for update</h3>");
                } else {
                    int eid = Integer.parseInt(idParam);
                    int es = Integer.parseInt(salParam);

                    PreparedStatement ps = con.prepareStatement(
                            "UPDATE emp SET ename = ?, esalary = ? WHERE id = ?"
                    );
                    ps.setString(1, en);
                    ps.setInt(2, es);
                    ps.setInt(3, eid);

                    int rows = ps.executeUpdate();
                    out.println("<h3>Updated Successfully. Rows: " + rows + "</h3>");
                }
            }

            // 🔹 READ
            else if (ch == 4) {

                PreparedStatement ps = con.prepareStatement("SELECT * FROM emp");
                ResultSet rs = ps.executeQuery();

                out.println("<h3>Employee Records:</h3>");
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

            else {
                out.println("<h3>Invalid Choice</h3>");
            }

            out.println("<br><a href='form.html'>Go Back</a>");
            out.println("</body></html>");

            con.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
