package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.service.region.RegionCommandService;
import umc.spring.validation.annotation.ExistRegion;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion,Long> {

    private final RegionCommandService regionService;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    //regionId가 DB에 있는지 확인
    @Override
    public boolean isValid(Long regionId, ConstraintValidatorContext context) {
        boolean isValid=regionService.existsById(regionId);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
