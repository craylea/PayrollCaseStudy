package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.usecase.usecases.changeemployee.paymentmethod;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.entity.paymentmethod.PaymentMethod;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.entity.paymentmethod.PaymentMethod.PaymentMethodFactory;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.ui.request.changeemployee.ChangeEmployeeRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.secondary.database.EmployeeGateway;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.secondary.database.TransactionalRunner;

public class ChangeToPaymasterPaymentMethodUseCase extends ChangeToAbstractPaymentMethodUseCase<ChangeEmployeeRequest> {

	private PaymentMethodFactory paymentMethodFactory;

	public ChangeToPaymasterPaymentMethodUseCase(
			TransactionalRunner transactionalRunner,
			EmployeeGateway employeeGateway,
			PaymentMethodFactory paymentMethodFactory
			) {
		super(transactionalRunner, employeeGateway);
		this.paymentMethodFactory = paymentMethodFactory;
	}

	@Override
	protected PaymentMethod getPaymentMethod(ChangeEmployeeRequest request) {
		return paymentMethodFactory.paymasterPaymentMethod();
	}


}
