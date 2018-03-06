package info.blogbasbas.logintesting.db;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import info.blogbasbas.logintesting.db.model.LibraryTblItem;
import info.blogbasbas.logintesting.db.model.SubscriptionTbl;
import info.blogbasbas.logintesting.db.model.UserTbl;


public class ResponseLogin implements Parcelable {

	@SerializedName("UserTbl")
	private List<UserTbl> dataUser;
	@SerializedName("SubscriptionTbl")
	private List<SubscriptionTbl> dataSubcription;
	@SerializedName("LibraryTbl")
	private List<LibraryTblItem> dataLibrary;

	public List<SubscriptionTbl> getDataSubcription() {
		return dataSubcription;
	}

	public void setDataSubcription(List<SubscriptionTbl> dataSubcription) {
		this.dataSubcription = dataSubcription;
	}

	public List<LibraryTblItem> getDataLibrary() {
		return dataLibrary;
	}

	public void setDataLibrary(List<LibraryTblItem> dataLibrary) {
		this.dataLibrary = dataLibrary;
	}

	public List<UserTbl> getDataUser() {
		return dataUser;
	}

	public void setDataUser(List<UserTbl> dataUser) {
		this.dataUser = dataUser;
	}

	@SerializedName("ApiStatus")
	private int apiStatus;

	@SerializedName("ApiMessage")
	private String apiMessage;

	@SerializedName("ApiValue")
	public ApiValue apiValue;


	public void setApiStatus(int apiStatus){
		this.apiStatus = apiStatus;
	}

	public int getApiStatus(){
		return apiStatus;
	}

	public void setApiMessage(String apiMessage){
		this.apiMessage = apiMessage;
	}

	public String getApiMessage(){
		return apiMessage;
	}

	public void setApiValue(ApiValue apiValue){
		this.apiValue = apiValue;
	}

	public ApiValue getApiValue(){
		return apiValue;
	}

	@Override
 	public String toString(){
		return 
			"ResponseLogin{" + 
			"apiStatus = '" + apiStatus + '\'' + 
			",apiMessage = '" + apiMessage + '\'' + 
			",apiValue = '" + apiValue + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(this.dataUser);
		dest.writeList(this.dataSubcription);
		dest.writeList(this.dataLibrary);
		dest.writeInt(this.apiStatus);
		dest.writeString(this.apiMessage);

	}

	public ResponseLogin() {
	}

	protected ResponseLogin(Parcel in) {
		this.dataUser = new ArrayList<UserTbl>();
		in.readList(this.dataUser, UserTbl.class.getClassLoader());
		this.dataSubcription = new ArrayList<SubscriptionTbl>();
		in.readList(this.dataSubcription, SubscriptionTbl.class.getClassLoader());
		this.dataLibrary = new ArrayList<LibraryTblItem>();
		in.readList(this.dataLibrary, LibraryTblItem.class.getClassLoader());
		this.apiStatus = in.readInt();
		this.apiMessage = in.readString();

	}

	public static final Parcelable.Creator<ResponseLogin> CREATOR = new Parcelable.Creator<ResponseLogin>() {
		@Override
		public ResponseLogin createFromParcel(Parcel source) {
			return new ResponseLogin(source);
		}

		@Override
		public ResponseLogin[] newArray(int size) {
			return new ResponseLogin[size];
		}
	};
}