package lab3;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Artist {

    Connection connection;
    Statement statement;

    {
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/lab3", "root", "Mimoza1234");
            statement  = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addArtist(String first_name, String last_name, int age) throws SQLException {

            String addArtist = "INSERT INTO Artist(first_name, last_name, age) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(addArtist, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setInt(3, age);

            ResultSet rs = null;
            int artistId = 0;

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next())
                    artistId = rs.getInt(1);


            }

            System.out.println("artist have been inserted");
            return artistId;

    }

        public int deleteArtistAfterID(int id) throws SQLException {
            ResultSet rs = null;
            int actorId = 0;


        String deleteArtist = "DELETE FROM artist WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteArtist, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,id);


            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                rs = preparedStatement.getGeneratedKeys();
                if(rs.next())
                    actorId = rs.getInt(1);


            }

            System.out.println("Artist have been removed");

            return actorId;
        }

    public void updateTableArtist( String first_name, String last_name, int age, int id ) throws SQLException{

        String sqlUpdateName = "Update artist SET first_name = ?, last_name = ? , age = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateName);
        preparedStatement.setString(1,first_name);
        preparedStatement.setString(2,last_name);
        preparedStatement.setInt(3, age);
        preparedStatement.setInt(4,id);


        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("List Artist is updated");

    }


    public void showAllArtists() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM artist");
        while (resultSet.next()){
            System.out.println(
                  "id = " +  resultSet.getInt("id") + " Name = " +
                          resultSet.getString("first_name") + " Last name = " +
                            resultSet.getString("last_name") + " Age = " +
                            resultSet.getInt("age"));
        }
    }


    public void findArtistByID(int id) throws SQLException {

        String selectArtist = "SELECT * FROM artist WHERE id = ?";
        PreparedStatement preparedStatement1 = connection.prepareStatement(selectArtist);
        preparedStatement1.setInt(1, id);

        ResultSet resultSet = preparedStatement1.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + resultSet.getString("first_name") +
                    resultSet.getString("last_name") + resultSet.getInt("age"));


        }
    }


        public void findArtistByAge(int age) throws SQLException {

            String selectArtistByAge = "SELECT * FROM artist WHERE age = ?";
            PreparedStatement preparedStatement3 = connection.prepareStatement(selectArtistByAge);
            preparedStatement3.setInt(1, age);

            ResultSet resultSet1 = preparedStatement3.executeQuery();

            while (resultSet1.next()) {
                System.out.println(resultSet1.getInt("id") + resultSet1.getString("first_name") +
                        resultSet1.getString("last_name") + resultSet1.getInt("age"));

            }
        }



    public void findArtistByName(String name) throws SQLException {

        String selectArtistByAge = "SELECT * FROM artist WHERE first_name = ?";
        PreparedStatement preparedStatement4 = connection.prepareStatement(selectArtistByAge);
        preparedStatement4.setString(1, name);

        ResultSet resultSet2 = preparedStatement4.executeQuery();

        while (resultSet2.next()) {
            System.out.println(resultSet2.getInt("id") + resultSet2.getString("first_name") +
                    resultSet2.getString("last_name") + resultSet2.getInt("age"));

        }
    }













    }




















