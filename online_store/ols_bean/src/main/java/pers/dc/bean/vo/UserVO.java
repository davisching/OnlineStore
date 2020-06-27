package pers.dc.bean.vo;

import pers.dc.bean.Users;

public class UserVO {
    private String id;
    private String username;
    private String nickname;
    private String realname;
    private String face;
    private long sex;

    public UserVO(Users user) {
        id = user.getId();
        username = user.getUsername();
        nickname = user.getNickname();
        realname = user.getRealname();
        face = user.getFace();
        sex = user.getSex();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", face='" + face + '\'' +
                ", sex=" + sex +
                '}';
    }
}
