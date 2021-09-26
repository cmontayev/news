package Chingis.Montayev.news.model;

public class Comment {

    private Integer id;
    private Integer idUser;
    private Integer newsId;
    private String comment;
    private Users users;



    public Comment(int comid, int id_users, int news_id, String comment, Users users) {
         this.id=comid;
        this.idUser=id_users;
        this.newsId=news_id;
        this.comment=comment;
        this.users=users;
    }


    public Users getUsers() {
        return users;
    }

    public Comment(Integer id, Integer idUser, Integer newsId, String comment) {
        this.id = id;
        this.idUser = idUser;
        this.newsId = newsId;
        this.comment = comment;
    }



    public Comment() {
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", newsId=" + newsId +
                ", comment='" + comment + '\'' +
                ", users=" + users +
                '}';
    }
}
