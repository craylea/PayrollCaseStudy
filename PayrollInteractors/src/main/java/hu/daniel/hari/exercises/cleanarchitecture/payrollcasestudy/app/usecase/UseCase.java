package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.usecase;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.request.Request;

@Deprecated
public interface UseCase<R extends Request> {
	void execute(R request);
}