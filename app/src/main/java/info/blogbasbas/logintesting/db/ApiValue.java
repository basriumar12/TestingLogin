package info.blogbasbas.logintesting.db;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import info.blogbasbas.logintesting.db.model.LibraryTblItem;
import info.blogbasbas.logintesting.db.model.PaymentRegistrationResponseTbl;
import info.blogbasbas.logintesting.db.model.PaymentRegistrationTbl;
import info.blogbasbas.logintesting.db.model.SubscriptionTbl;
import info.blogbasbas.logintesting.db.model.UserTbl;


public class ApiValue{

	@SerializedName("UserTbl")
	public UserTbl userTbl;

	@SerializedName("SubscriptionTbl")
	public SubscriptionTbl subscriptionTbl;

	@SerializedName("ScoreTbl")
	private List<Object> scoreTbl;

	@SerializedName("PaymentRegistrationTbl")
	private PaymentRegistrationTbl paymentRegistrationTbl;

	@SerializedName("LibraryTbl")
	public List<LibraryTblItem> libraryTbl;

	@SerializedName("PaymentRegistrationResponseTbl")
	private PaymentRegistrationResponseTbl paymentRegistrationResponseTbl;

	public void setUserTbl(UserTbl userTbl){
		this.userTbl = userTbl;
	}

	public UserTbl getUserTbl(){
		return userTbl;
	}

	public void setSubscriptionTbl(SubscriptionTbl subscriptionTbl){
		this.subscriptionTbl = subscriptionTbl;
	}

	public SubscriptionTbl getSubscriptionTbl(){
		return subscriptionTbl;
	}

	public void setScoreTbl(List<Object> scoreTbl){
		this.scoreTbl = scoreTbl;
	}

	public List<Object> getScoreTbl(){
		return scoreTbl;
	}

	public void setPaymentRegistrationTbl(PaymentRegistrationTbl paymentRegistrationTbl){
		this.paymentRegistrationTbl = paymentRegistrationTbl;
	}

	public PaymentRegistrationTbl getPaymentRegistrationTbl(){
		return paymentRegistrationTbl;
	}

	public void setLibraryTbl(List<LibraryTblItem> libraryTbl){
		this.libraryTbl = libraryTbl;
	}

	public List<LibraryTblItem> getLibraryTbl(){
		return libraryTbl;
	}

	public void setPaymentRegistrationResponseTbl(PaymentRegistrationResponseTbl paymentRegistrationResponseTbl){
		this.paymentRegistrationResponseTbl = paymentRegistrationResponseTbl;
	}

	public PaymentRegistrationResponseTbl getPaymentRegistrationResponseTbl(){
		return paymentRegistrationResponseTbl;
	}

	@Override
 	public String toString(){
		return 
			"ApiValue{" + 
			"userTbl = '" + userTbl + '\'' + 
			",subscriptionTbl = '" + subscriptionTbl + '\'' + 
			",scoreTbl = '" + scoreTbl + '\'' + 
			",paymentRegistrationTbl = '" + paymentRegistrationTbl + '\'' + 
			",libraryTbl = '" + libraryTbl + '\'' + 
			",paymentRegistrationResponseTbl = '" + paymentRegistrationResponseTbl + '\'' + 
			"}";
		}
}