package pers.dc.bean.vo;

import pers.dc.bean.ItemsComments;

import java.util.Date;

public class CommentRecordVO extends ItemsComments {
    private String specName;
    private String nickname;
    private String userFace;

    public CommentRecordVO(String content, String sepcName, String nickname, String userFace, Date createdTime) {
        this.specName = sepcName;
        this.nickname = encodeNickname(nickname);
        this.userFace = userFace;
        this.setContent(content);
        this.setCreatedTime(createdTime);
    }

    private String encodeNickname(String nickname) {
        StringBuilder res = new StringBuilder();
        res.append(nickname.charAt(0));
        for (int i = 0; i < nickname.length(); i++)
            res.append("*");
        res.append(nickname.charAt(nickname.length()-1));
        return res.toString();
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }
}
