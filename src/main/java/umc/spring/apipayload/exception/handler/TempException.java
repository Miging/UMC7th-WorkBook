package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class TempException extends GeneralException {
    public TempException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
