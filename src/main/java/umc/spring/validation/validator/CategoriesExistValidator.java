package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.repository.foodcategory.FoodCategoryRepository;
import umc.spring.validation.annotation.ExistCategories;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    //ListLong 값을 가진 카테고리가 모두 DB에 있는지 확인
    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid=values.stream()
                .allMatch(foodCategoryRepository::existsById);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
