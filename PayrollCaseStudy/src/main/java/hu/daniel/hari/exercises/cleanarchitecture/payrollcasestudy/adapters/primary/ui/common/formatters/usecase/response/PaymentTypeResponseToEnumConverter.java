package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.adapters.primary.ui.common.formatters.usecase.response;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.adapters.primary.ui.views_and_controllers.mainframe.mainpanel.employeemanager.EmployeeViewItem.PaymentType;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.ui.response.employee.paymenttype.CommissionedPaymentTypeResponse;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.ui.response.employee.paymenttype.HourlyPaymentTypeResponse;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.ui.response.employee.paymenttype.SalariedPaymentTypeResponse;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.ui.response.employee.paymenttype.PaymentTypeResponse.PaymentTypeResponseVisitor;

public class PaymentTypeResponseToEnumConverter implements PaymentTypeResponseVisitor<PaymentType> {

	@Override
	public PaymentType visit(SalariedPaymentTypeResponse salariedPaymentTypeResponse) {
		return PaymentType.SALARIED;
	}

	@Override
	public PaymentType visit(HourlyPaymentTypeResponse hourlyPaymentTypeResponse) {
		return PaymentType.HOURLY;
	}

	@Override
	public PaymentType visit(CommissionedPaymentTypeResponse commissionedPaymentTypeResponse) {
		return PaymentType.COMMISSIONED;
	}

}
