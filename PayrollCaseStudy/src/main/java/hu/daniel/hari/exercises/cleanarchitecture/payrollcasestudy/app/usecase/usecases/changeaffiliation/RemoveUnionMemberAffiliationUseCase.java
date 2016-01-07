package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.usecase.usecases.changeaffiliation;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.entity.Employee;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.entity.affiliation.Affiliation.AffiliationFactory;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.usecase.TransactionalUseCase;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.usecase.usecases.AddServiceChargeUseCase;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.ui.requestresponse.request.Request.EmptyRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.ui.requestresponse.request.changeemployee.affiliation.RemoveUnionMemberAffiliationRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.secondary.database.EmployeeGateway;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.secondary.database.TransactionalRunner;

public class RemoveUnionMemberAffiliationUseCase extends TransactionalUseCase<RemoveUnionMemberAffiliationRequest> {
	
	private AffiliationFactory affiliationFactory;

	public RemoveUnionMemberAffiliationUseCase(
			TransactionalRunner transactionalRunner, 
			EmployeeGateway employeeGateway, 
			AffiliationFactory affiliationFactory
			) {
		super(transactionalRunner, employeeGateway);
		this.affiliationFactory = affiliationFactory;
	}

	@Override
	protected void executeInTransaction(RemoveUnionMemberAffiliationRequest request) {
		getEmployeeByUnionMemberId(request.unionMemberId).setAffiliation(affiliationFactory.noAffiliation());
	}

	private Employee getEmployeeByUnionMemberId(int unionMemberId) {
		return employeeGateway.findById(employeeGateway.findByUnionMemberId(unionMemberId));
	}

	public static interface RemoveUnionMemberAffiliationUseCaseFactory {
		RemoveUnionMemberAffiliationUseCase removeUnionMemberAffiliationUseCase();
	}

}