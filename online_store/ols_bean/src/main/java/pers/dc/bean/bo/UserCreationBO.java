package pers.dc.bean.bo;

import pers.dc.validation.FieldMatch;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "兩次密碼不同！")
public class UserCreationBO {

    @NotBlank(message = "用戶名不能為空")
    private String username;

    @NotBlank(message = "密碼不能為空")
    @Size(min = 6, message = "密碼至少要6位")
    private String password;

    @NotBlank(message = "確認密碼不能為空")
    @Size(min = 6, message = "確認密碼至少要6位")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UserCreationBO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
