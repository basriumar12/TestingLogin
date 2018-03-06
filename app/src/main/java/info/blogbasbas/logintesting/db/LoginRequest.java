package info.blogbasbas.logintesting.db;

import com.google.gson.annotations.SerializedName;



public class LoginRequest {
    @SerializedName(value = "Username")
    public String Username;

    @SerializedName(value = "Password")
    public String Password;

    @SerializedName(value = "Token")
    public String Token;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password, String token) {
        Username = username;
        Password = password;
        Token = token;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
