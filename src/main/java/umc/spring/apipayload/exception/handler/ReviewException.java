package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
