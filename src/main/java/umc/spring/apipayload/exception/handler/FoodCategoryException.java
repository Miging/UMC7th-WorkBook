package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class FoodCategoryException extends GeneralException {
    public FoodCategoryException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
