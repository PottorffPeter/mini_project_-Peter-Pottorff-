package com.Persistance;

import com.models.Users;
import com.utils.ConnectionManager;
import com.utils.CustomCRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.utils.ConnectionManager.connection;

public class UserDAO implements CustomCRUDInterface<User> {

    Connection connection;

    public UserDAO(){
        connection = ConnectionManager.getConnection();
    }

    @Override
    public Integer create(User user) {

        try {
            String sql = "INSERT INTO zodiacUser (user_id,user_name,pass_word,first_name,last_name,email,zodiac_sign) VALUES (DEFAULT,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,user.getUser_name());
            pstmt.setString(2, user.getPass_word());
            pstmt.setString(3, user.getFirst_name());
            pstmt.setString(4,user.getLast_name());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getZodiac_sign());


            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();
            return rs.getInt("user_id");

        } catch(Exception e){
            System.out.println("Error in the user Dao: " + e.getMessage());
        }

        return null;
    }

    @Override
    public User read(Integer id) {

        try{

            String sql = "SELECT * FROM zodiacUser WHERE user_id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            User user = new User();

            while (rs.next()){

                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setPass_word(rs.getString("pass_word"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setZodiac_sign(rs.getString("zodiac_sign"));
                user.setMood(rs.getString("mood"));


            }
            return user;


        }catch (Exception e){
            System.out.println("This is the UserDAO: " + e.getMessage());
        }

        return null;
    }

    @Override
    public User update(User user) {

        try {
        String sql = "UPDATE zodiacUser WHERE mood = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1,user.getMood());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();


        while (rs.next()){
            user.setMood(rs.getString("mood"));
        }

        return user;

    } catch (Exception e){
        System.out.println(e.getMessage());
    }


        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
    public Users loginCurrentUser (String email, String user_password){

        try {
            String sql = "SELECT * FROM zodiacUser WHERE email = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // 1 indicates parameter of question mark, email is what it's taking in
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next() && rs.getString("pass_word").equals(user_password)){
                return new Users(rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("pass_word"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("zodiac_sign"),
                        rs.getString("mood"));
            }


        }catch (Exception e){
            System.out.println("This is the UserDAO " + e.getMessage());
        }
        return null;
    }
}
