package afluex.hrm.afluexhr.Model;

import java.util.ArrayList;

public class ModelPost {

    String type,text,date,caption,likeCount,commentCount,userName,postDate;
    Integer image,imageUser;

    private ArrayList<ModelComment> commentArrayList;

    public ModelPost(String type, String text, String date, String caption, String likeCount,
                     String commentCount, String userName, String postDate, Integer image, Integer imageUser, ArrayList<ModelComment> commentArrayList) {
        this.type = type;
        this.text = text;
        this.date = date;
        this.caption = caption;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.userName = userName;
        this.postDate = postDate;
        this.image = image;
        this.imageUser = imageUser;
        this.commentArrayList = commentArrayList;
    }

    public ModelPost() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public Integer getImageUser() {
        return imageUser;
    }

    public void setImageUser(Integer imageUser) {
        this.imageUser = imageUser;
    }

    public ArrayList<ModelComment> getCommentArrayList() {
        return commentArrayList;
    }

    public void setCommentArrayList(ArrayList<ModelComment> commentArrayList) {
        this.commentArrayList = commentArrayList;
    }
}
