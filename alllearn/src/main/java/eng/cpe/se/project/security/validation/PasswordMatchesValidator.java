package eng.cpe.se.project.security.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import eng.cpe.se.project.model.Account;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		Account user = (Account) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}

	
}
