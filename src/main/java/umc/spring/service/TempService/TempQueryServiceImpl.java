package umc.spring.service.TempService;

import org.springframework.stereotype.Service;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.TempHandler;

@Service
public class TempQueryServiceImpl implements TempQueryService{
    public void CheckFlag(Integer flag){
        if(flag == 1){
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
