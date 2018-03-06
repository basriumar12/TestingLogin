package info.blogbasbas.logintesting.db.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "UserTb",indexes = {
		@Index(value = "userId", unique = true)
})
public class UserTbl{
	@Id(autoincrement = true)
	@SerializedName("UserId")
	private long userId;

	@SerializedName("HomeAddress")
	private String homeAddress;

	@SerializedName("Email")
	private String email;

	@SerializedName("UserRoleId")
	private int userRoleId;

	@SerializedName("UserKey")
	private String userKey;

	@SerializedName("SchoolAddress")
	private String schoolAddress;

	@SerializedName("Token")
	private String token;

	@SerializedName("Name")
	private String name;

	@SerializedName("School")
	private String school;

	@SerializedName("Username")
	private String username;


	@SerializedName("CreatedDate")
	private String createdDate;

	@SerializedName("ClassName")
	private String className;

	@SerializedName("Password")
	private String password;

	@Generated(hash = 1403766690)
	public UserTbl(long userId, String homeAddress, String email, int userRoleId,
			String userKey, String schoolAddress, String token, String name,
			String school, String username, String createdDate, String className,
			String password) {
		this.userId = userId;
		this.homeAddress = homeAddress;
		this.email = email;
		this.userRoleId = userRoleId;
		this.userKey = userKey;
		this.schoolAddress = schoolAddress;
		this.token = token;
		this.name = name;
		this.school = school;
		this.username = username;
		this.createdDate = createdDate;
		this.className = className;
		this.password = password;
	}

	@Generated(hash = 585658511)
	public UserTbl() {
	}

	public void setHomeAddress(String homeAddress){
		this.homeAddress = homeAddress;
	}

	public String getHomeAddress(){
		return homeAddress;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUserRoleId(int userRoleId){
		this.userRoleId = userRoleId;
	}

	public int getUserRoleId(){
		return userRoleId;
	}

	public void setUserKey(String userKey){
		this.userKey = userKey;
	}

	public String getUserKey(){
		return userKey;
	}

	public void setSchoolAddress(String schoolAddress){
		this.schoolAddress = schoolAddress;
	}

	public String getSchoolAddress(){
		return schoolAddress;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSchool(String school){
		this.school = school;
	}

	public String getSchool(){
		return school;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public long getUserId(){
		return userId;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setClassName(String className){
		this.className = className;
	}

	public String getClassName(){
		return className;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	@Override
 	public String toString(){
		return 
			"UserTbl{" + 
			"homeAddress = '" + homeAddress + '\'' + 
			",email = '" + email + '\'' + 
			",userRoleId = '" + userRoleId + '\'' + 
			",userKey = '" + userKey + '\'' + 
			",schoolAddress = '" + schoolAddress + '\'' + 
			",token = '" + token + '\'' + 
			",name = '" + name + '\'' + 
			",school = '" + school + '\'' + 
			",username = '" + username + '\'' + 
			",userId = '" + userId + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",className = '" + className + '\'' + 
			",password = '" + password + '\'' + 
			"}";
		}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}