package umc.spring.service.region;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.region.RegionRepository;

@Service
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService {

    private final RegionRepository regionRepository;

    @Override
    public boolean existsById(Long regionId) {
        return regionRepository.existsById(regionId);
    }
}
