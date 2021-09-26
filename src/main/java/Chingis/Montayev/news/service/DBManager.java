package Chingis.Montayev.news.service;

import Chingis.Montayev.news.model.Comment;
import Chingis.Montayev.news.model.Like;
import Chingis.Montayev.news.model.News;
import Chingis.Montayev.news.model.Users;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    static String image = "https://www.pngitem.com/pimgs/m/35-350426_profile-icon-png-default-profile-picture-png-transparent.png";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Chingis", "root", "daneen13");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(String login, String email) {
        boolean exist = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email=? or login=?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                exist = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return exist;
    }

    public static void remove(int i) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Chingis.items " +
                    "WHERE id=?");
            statement.setLong(1, i);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean creatUser(Users user) {
        int rows = 0;
        try {

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (full_name,email,login,password,path_image) " +
                            "VALUES (?, ?, ?, ?,?)"
            );
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPass());
            statement.setString(5, image);

            rows = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rows > 0;
    }

    public static Users getUserByLogin(String login, String password) {
        Users user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * from users " +
                    "where login = ? and password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new Users(
                        rs.getLong("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("login"),
                        rs.getString("path_image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<News> getAllNews() throws SQLException {
        ArrayList<News> news = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT news.id as news_id, news.topic, news.description, " +
                "users.full_name, users.id , users.email, users.login, users.password, users.path_image " +
                "FROM news " +
                "inner JOIN users ON news.users_id = users.id ");

        PreparedStatement statement2 = connection.prepareStatement("SELECT  users.full_name, users.id, users.email, users.login, users.password, users.path_image, " +
                " comment.comment, comment.id as comid, comment.id_users,comment.news_id " +
                "from comment " +
                "inner JOIN users ON comment.id_users = users.id " +
                "where news_id=? ");

        while (resultSet.next()) {
            ArrayList<Comment> commentArrayList = new ArrayList<>();
            String topic = resultSet.getString("topic");
            String description = resultSet.getString("description");
            Integer id_news = resultSet.getInt("news_id");

            Long userId = resultSet.getLong("id");
            String full_name = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            String path_image = resultSet.getString("path_image");

            getComments(id_news, commentArrayList, statement2);
            news.add(new News(id_news, topic, description,
                    new Users(userId, full_name, email, login, password, path_image),
                    commentArrayList));

        }
        return news;

    }

    public static boolean creatNews(News news) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO news (users_id,topic,description) " +
                            "VALUES (?, ?, ?)"
            );
            statement.setLong(1, news.getUsersId());
            statement.setString(2, news.getTopic());
            statement.setString(3, news.getDescription());

            rows = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows > 0;

    }

    public static boolean creatComment(Comment comment1) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO comment (id_users,news_id,comment) " +
                            "VALUES (?, ?, ?)"
            );
            statement.setInt(1, comment1.getIdUser());
            statement.setInt(2, comment1.getNewsId());
            statement.setString(3, comment1.getComment());
            rows = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows > 0;
    }

    public static ArrayList<Like> getAllLike() {
        ArrayList<Like> likes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * from like where users_id=? "
            );


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Comment> getCommentByNewsId(Integer id) {

        ArrayList<Comment> comment = new ArrayList<>();
        try {

            PreparedStatement statement2 = connection.prepareStatement("SELECT  users.full_name, users.id, users.email, users.login, users.password, users.path_image, " +
                    " comment.comment, comment.id as comid, comment.id_users,comment.news_id " +
                    "from comment " +
                    "inner JOIN users ON comment.id_users = users.id " +
                    "where news_id=? ");

            getComments(id, comment, statement2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }
    private static void getComments(Integer id, ArrayList<Comment> comment, PreparedStatement statement2) throws SQLException {
        statement2.setInt(1, id);
        ResultSet commentR = statement2.executeQuery();
        while (commentR.next()) {
            comment.add(new Comment(
                            commentR.getInt("comid"),
                            commentR.getInt("id_users"),
                            commentR.getInt("news_id"),
                            commentR.getString("comment"),
                            new Users(
                                    commentR.getLong("id"),
                                    commentR.getString("full_name"),
                                    commentR.getString("email"),
                                    commentR.getString("login"),
                                    commentR.getString("password"),
                                    commentR.getString("path_image")
                            )

                    )
            );

        }
    }

    private static Users getUserById(Integer comId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT users.id, users.full_name, users.email, users.login, users.path_image " +
                "FROM comment " +
                "inner JOIN users ON comment.id_users = users.id " +
                "where news_id=? ");

        statement.setLong(1, comId);
        Users users = null;
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String full_name = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            String login = resultSet.getString("login");
            String path_image = resultSet.getString("path_image");
            users = new Users(id, full_name, email, login, path_image);
        }
        return users;
    }
}
