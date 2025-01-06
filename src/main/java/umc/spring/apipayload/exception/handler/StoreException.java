package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class StoreException extends GeneralException {
    public StoreException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
