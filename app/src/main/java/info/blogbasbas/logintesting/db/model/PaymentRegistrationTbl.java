package info.blogbasbas.logintesting.db.model;


import com.google.gson.annotations.SerializedName;


public class PaymentRegistrationTbl{

	@SerializedName("Description")
	private String description;

	@SerializedName("AuthCode")
	private String authCode;

	@SerializedName("UpdatedDate")
	private String updatedDate;

	@SerializedName("PaymentRegId")
	private int paymentRegId;

	@SerializedName("TransactionNo")
	private int transactionNo;

	@SerializedName("TransactionExpire")
	private String transactionExpire;

	@SerializedName("CustomerAccount")
	private String customerAccount;

	@SerializedName("ChannelId")
	private String channelId;

	@SerializedName("TransactionAmount")
	private int transactionAmount;

	@SerializedName("SubscriptionId")
	private int subscriptionId;

	@SerializedName("Currency")
	private String currency;

	@SerializedName("CreatedDate")
	private String createdDate;

	@SerializedName("CustomerName")
	private String customerName;

	@SerializedName("DeletedDate")
	private String deletedDate;

	@SerializedName("TransactionDate")
	private String transactionDate;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setAuthCode(String authCode){
		this.authCode = authCode;
	}

	public String getAuthCode(){
		return authCode;
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

	public void setTransactionNo(int transactionNo){
		this.transactionNo = transactionNo;
	}

	public int getTransactionNo(){
		return transactionNo;
	}

	public void setTransactionExpire(String transactionExpire){
		this.transactionExpire = transactionExpire;
	}

	public String getTransactionExpire(){
		return transactionExpire;
	}

	public void setCustomerAccount(String customerAccount){
		this.customerAccount = customerAccount;
	}

	public String getCustomerAccount(){
		return customerAccount;
	}

	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	public String getChannelId(){
		return channelId;
	}

	public void setTransactionAmount(int transactionAmount){
		this.transactionAmount = transactionAmount;
	}

	public int getTransactionAmount(){
		return transactionAmount;
	}

	public void setSubscriptionId(int subscriptionId){
		this.subscriptionId = subscriptionId;
	}

	public int getSubscriptionId(){
		return subscriptionId;
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

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public String getCustomerName(){
		return customerName;
	}

	public void setDeletedDate(String deletedDate){
		this.deletedDate = deletedDate;
	}

	public String getDeletedDate(){
		return deletedDate;
	}

	public void setTransactionDate(String transactionDate){
		this.transactionDate = transactionDate;
	}

	public String getTransactionDate(){
		return transactionDate;
	}

	@Override
 	public String toString(){
		return 
			"PaymentRegistrationTbl{" + 
			"description = '" + description + '\'' + 
			",authCode = '" + authCode + '\'' + 
			",updatedDate = '" + updatedDate + '\'' + 
			",paymentRegId = '" + paymentRegId + '\'' + 
			",transactionNo = '" + transactionNo + '\'' + 
			",transactionExpire = '" + transactionExpire + '\'' + 
			",customerAccount = '" + customerAccount + '\'' + 
			",channelId = '" + channelId + '\'' + 
			",transactionAmount = '" + transactionAmount + '\'' + 
			",subscriptionId = '" + subscriptionId + '\'' + 
			",currency = '" + currency + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",customerName = '" + customerName + '\'' + 
			",deletedDate = '" + deletedDate + '\'' + 
			",transactionDate = '" + transactionDate + '\'' + 
			"}";
		}
}