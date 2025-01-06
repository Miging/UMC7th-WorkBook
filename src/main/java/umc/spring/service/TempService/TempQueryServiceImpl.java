package umc.spring.service.TempService;

import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.TempException;

@Service
public class TempQueryServiceImpl implements TempQueryService{
    public void CheckFlag(Integer flag){
        if(flag == 1){
            throw new TempException(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
