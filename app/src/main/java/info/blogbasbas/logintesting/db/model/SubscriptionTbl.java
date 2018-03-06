package info.blogbasbas.logintesting.db.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "SubscriptionTbl",indexes = {
		@Index(value = "subscriptionId", unique = true)
})

public class SubscriptionTbl{

	@SerializedName("PaymentFlag")
	private int paymentFlag;

	@Id(autoincrement = true)
	@SerializedName("SubscriptionId")
	private long subscriptionId;

	@SerializedName("UserId")
	private int userId;

	@SerializedName("PlanId")
	private int planId;

	@SerializedName("SubscriptionEndTimestamp")
	private String subscriptionEndTimestamp;

	@SerializedName("CreatedDate")
	private String createdDate;

	@SerializedName("SubscriptionStartTimestamp")
	private String subscriptionStartTimestamp;

	@SerializedName("TotalTransaction")
	private int totalTransaction;

	@SerializedName("ActiveFlag")
	private int activeFlag;

	@Generated(hash = 1523128432)
	public SubscriptionTbl(int paymentFlag, long subscriptionId, int userId,
			int planId, String subscriptionEndTimestamp, String createdDate,
			String subscriptionStartTimestamp, int totalTransaction, int activeFlag) {
		this.paymentFlag = paymentFlag;
		this.subscriptionId = subscriptionId;
		this.userId = userId;
		this.planId = planId;
		this.subscriptionEndTimestamp = subscriptionEndTimestamp;
		this.createdDate = createdDate;
		this.subscriptionStartTimestamp = subscriptionStartTimestamp;
		this.totalTransaction = totalTransaction;
		this.activeFlag = activeFlag;
	}

	@Generated(hash = 1887535069)
	public SubscriptionTbl() {
	}

	public void setPaymentFlag(int paymentFlag){
		this.paymentFlag = paymentFlag;
	}

	public int getPaymentFlag(){
		return paymentFlag;
	}

	public void setSubscriptionId(int subscriptionId){
		this.subscriptionId = subscriptionId;
	}

	public long getSubscriptionId(){
		return subscriptionId;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setPlanId(int planId){
		this.planId = planId;
	}

	public int getPlanId(){
		return planId;
	}

	public void setSubscriptionEndTimestamp(String subscriptionEndTimestamp){
		this.subscriptionEndTimestamp = subscriptionEndTimestamp;
	}

	public String getSubscriptionEndTimestamp(){
		return subscriptionEndTimestamp;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setSubscriptionStartTimestamp(String subscriptionStartTimestamp){
		this.subscriptionStartTimestamp = subscriptionStartTimestamp;
	}

	public String getSubscriptionStartTimestamp(){
		return subscriptionStartTimestamp;
	}

	public void setTotalTransaction(int totalTransaction){
		this.totalTransaction = totalTransaction;
	}

	public int getTotalTransaction(){
		return totalTransaction;
	}

	public void setActiveFlag(int activeFlag){
		this.activeFlag = activeFlag;
	}

	public int getActiveFlag(){
		return activeFlag;
	}

	@Override
 	public String toString(){
		return 
			"SubscriptionTbl{" + 
			"paymentFlag = '" + paymentFlag + '\'' + 
			",subscriptionId = '" + subscriptionId + '\'' + 
			",userId = '" + userId + '\'' + 
			",planId = '" + planId + '\'' + 
			",subscriptionEndTimestamp = '" + subscriptionEndTimestamp + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",subscriptionStartTimestamp = '" + subscriptionStartTimestamp + '\'' + 
			",totalTransaction = '" + totalTransaction + '\'' + 
			",activeFlag = '" + activeFlag + '\'' + 
			"}";
		}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
}