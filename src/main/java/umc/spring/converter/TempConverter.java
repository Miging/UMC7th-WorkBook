package umc.spring.converter;

import umc.spring.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("TEST")
                .build();
    }
}
