package validators;

import annotations.USA;
import annotations.ZipCode;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    /*@Inject
    @USA
    private ZipCodeValidator checker;*/
    private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");
    public void initialize(ZipCode zipcode){}
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(value == null)
            return true;
        Matcher m = zipPattern.matcher(value);
        if(!m.matches())
            return false;
        return false;
        //return checker.isZipCodeValid(value);
    }
}
