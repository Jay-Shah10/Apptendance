package com.example.jay_s.apptendance; /**
 * Created by jay_s on 11/8/2017.
 */
import java.sql.*;

import javax.xml.transform.Result;

public class AttendanceModel {

    private static final String  url = "jdbc:mysql://frankencluster.com:3306/mobileappteam3";
    private static final String user = "team3admin";
    private static final String pass = "Tardis10";


    public void addStudentToDataBase(String pantherNumber, String firstName, String lastName) {
        /*
        Method to add student data into the database.
        This will have strinng insert statements.
        It will pass in that string statment. It will use the text from the text input.

        This will add student's name to the database.
         */

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            String insertstring = "insert into mobileappteam3.Student(Panther Number, First Name, Last Name)" +
                    "valuse(?,?,?)";
           PreparedStatement smmt = con.prepareCall(insertstring);
           smmt.setString(1,pantherNumber);
           smmt.setString(2,firstName);
           smmt.setString(3,lastName);
           ResultSet rs = smmt.executeQuery(insertstring);

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public String getStudentDatabse(String s) throws SQLException{
        /*
        Method to pull students out of database.
        use select statments here
        String select will be passed in from the click action from the view.
        These will be displayed as the check boxes in the scroll view.

        It will be returning student name.
         */
        Connection con = null;

        String resultString;
        con = DriverManager.getConnection(url);
        Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery(s);
        while(rs.next()){
            resultString = rs.getString(s);
            return resultString;
        }
        return "Could not retrieve data";
    }



    // make methods to enter data into the database and to get data out of the database.
}
