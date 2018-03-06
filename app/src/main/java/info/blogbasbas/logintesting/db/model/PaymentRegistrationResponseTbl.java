package info.blogbasbas.logintesting.db.model;


import com.google.gson.annotations.SerializedName;


public class PaymentRegistrationResponseTbl{

	@SerializedName("AdditionalData")
	private Object additionalData;

	@SerializedName("InsertId")
	private int insertId;

	@SerializedName("InsertMessage")
	private String insertMessage;

	@SerializedName("UpdatedDate")
	private String updatedDate;

	@SerializedName("PaymentRegId")
	private int paymentRegId;

	@SerializedName("Currency")
	private String currency;

	@SerializedName("CreatedDate")
	private String createdDate;

	@SerializedName("DeletedDate")
	private String deletedDate;

	@SerializedName("ChannelId")
	private String channelId;

	@SerializedName("InsertStatus")
	private String insertStatus;

	@SerializedName("PaymentRegResponseId")
	private int paymentRegResponseId;

	public void setAdditionalData(Object additionalData){
		this.additionalData = additionalData;
	}

	public Object getAdditionalData(){
		return additionalData;
	}

	public void setInsertId(int insertId){
		this.insertId = insertId;
	}

	public int getInsertId(){
		return insertId;
	}

	public void setInsertMessage(String insertMessage){
		this.insertMessage = insertMessage;
	}

	public String getInsertMessage(){
		return insertMessage;
	}

	public void setUpdatedDate(String updatedDate){
		this.updatedDate = updatedDate;
	}

	public String getUpdatedDate(){
		return updatedDate;
	}

	public void setPaymentRegId(int paymentRegId){
		this.paymentRegId = paymentRegId;
	}

	public int getPaymentRegId(){
		return paymentRegId;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setDeletedDate(String deletedDate){
		this.deletedDate = deletedDate;
	}

	public String getDeletedDate(){
		return deletedDate;
	}

	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	public String getChannelId(){
		return channelId;
	}

	public void setInsertStatus(String insertStatus){
		this.insertStatus = insertStatus;
	}

	public String getInsertStatus(){
		return insertStatus;
	}

	public void setPaymentRegResponseId(int paymentRegResponseId){
		this.paymentRegResponseId = paymentRegResponseId;
	}

	public int getPaymentRegResponseId(){
		return paymentRegResponseId;
	}

	@Override
 	public String toString(){
		return 
			"PaymentRegistrationResponseTbl{" + 
			"additionalData = '" + additionalData + '\'' + 
			",insertId = '" + insertId + '\'' + 
			",insertMessage = '" + insertMessage + '\'' + 
			",updatedDate = '" + updatedDate + '\'' + 
			",paymentRegId = '" + paymentRegId + '\'' + 
			",currency = '" + currency + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",deletedDate = '" + deletedDate + '\'' + 
			",channelId = '" + channelId + '\'' + 
			",insertStatus = '" + insertStatus + '\'' + 
			",paymentRegResponseId = '" + paymentRegResponseId + '\'' + 
			"}";
		}
}