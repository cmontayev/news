package Chingis.Montayev.news.model;

public class Like {
    private Integer id;
    private Integer news_id;
    private Integer users_id;
    private boolean like;


    public Like(Integer id, Integer news_id, Integer users_id, boolean like) {
        this.id = id;
        this.news_id = news_id;
        this.users_id = users_id;
        this.like = like;
    }

    public Like() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public Integer getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
