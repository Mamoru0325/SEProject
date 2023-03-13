package eng.cpe.se.project.security.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import eng.cpe.se.project.model.dto.SignupDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		SignupDTO user = (SignupDTO) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}

	
}
