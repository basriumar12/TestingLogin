package info.blogbasbas.logintesting.db.model;


import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "LibraryTbl",indexes = {
		@Index(value = "libraryId", unique = true)
})
public class LibraryTblItem{
	@Id(autoincrement = true)
	@SerializedName("LibraryId")
	private long libraryId;

	@SerializedName("UserId")
	private int userId;

	@SerializedName("Content")
	private String content;

	@SerializedName("CreatedDate")
	private String createdDate;

	@SerializedName("Title")
	private String title;

	@SerializedName("Author")
	private String author;

	@SerializedName("Genre")
	private String genre;

	@Generated(hash = 1230685882)
	public LibraryTblItem(long libraryId, int userId, String content,
			String createdDate, String title, String author, String genre) {
		this.libraryId = libraryId;
		this.userId = userId;
		this.content = content;
		this.createdDate = createdDate;
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	@Generated(hash = 230828385)
	public LibraryTblItem() {
	}

	public void setLibraryId(int libraryId){
		this.libraryId = libraryId;
	}

	public long getLibraryId(){
		return libraryId;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setGenre(String genre){
		this.genre = genre;
	}

	public String getGenre(){
		return genre;
	}

	@Override
 	public String toString(){
		return 
			"LibraryTblItem{" + 
			"libraryId = '" + libraryId + '\'' + 
			",userId = '" + userId + '\'' + 
			",content = '" + content + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",title = '" + title + '\'' + 
			",author = '" + author + '\'' + 
			",genre = '" + genre + '\'' + 
			"}";
		}

	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}
}