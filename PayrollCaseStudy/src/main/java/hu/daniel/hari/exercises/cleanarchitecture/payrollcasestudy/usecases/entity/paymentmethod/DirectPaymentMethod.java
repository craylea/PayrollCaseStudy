package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.usecases.entity.paymentmethod;

public abstract class DirectPaymentMethod implements PaymentMethod {
	
	public abstract String getAccountNumber();
	public abstract void setAccountNumber(String accountNumber);
}
