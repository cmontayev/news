package Chingis.Montayev.news.model;

import java.util.ArrayList;

public class News {
    private Integer id;
    private String topic;
    private String description;
    private ArrayList<Comment> comments;
    private Users users;
    private Integer usersId;

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public News(Integer id, Integer usersId, String topic, String description) {
        this.id = id;
        this.topic = topic;
        this.usersId=usersId;
        this.description = description;
    }

    public News(Integer id, String topic, String description, Users users, ArrayList<Comment> comments) {
        this.id = id;
        this.topic = topic;
        this.description = description;
        this.users = users;
        this.comments = comments;
    }

    public News(String topic, String description, Users users) {
        this.topic = topic;
        this.description = description;
        this.users = users;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", comments=" + comments +
                ", users=" + users +
                '}';
    }
}
