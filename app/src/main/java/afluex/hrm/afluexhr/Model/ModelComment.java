package afluex.hrm.afluexhr.Model;

public class ModelComment {
    private Integer user_photo;
    private String userName,userComment;


    public ModelComment() {
    }

    public ModelComment(Integer user_photo, String userName, String userComment) {
        this.user_photo = user_photo;
        this.userName = userName;
        this.userComment = userComment;
    }

    public Integer getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(Integer user_photo) {
        this.user_photo = user_photo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}
