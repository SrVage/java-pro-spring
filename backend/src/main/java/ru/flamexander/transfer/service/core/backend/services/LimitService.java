package ru.flamexander.transfer.service.core.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flamexander.transfer.service.core.api.dtos.LimitDtoRequest;
import ru.flamexander.transfer.service.core.backend.integrations.LimitsServiceIntegration;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class LimitService {
    private final LimitsServiceIntegration limitsServiceIntegration;

    public boolean getLimit(Long clientId, BigDecimal amount){
        LimitDtoRequest limitDtoRequest = new LimitDtoRequest(amount);
        return limitsServiceIntegration.getLimit(limitDtoRequest, clientId).isHasLimit();
    }

    public void rollbackLimit(Long clientId, BigDecimal amount){
        LimitDtoRequest limitDtoRequest = new LimitDtoRequest(amount);
        limitsServiceIntegration.rollbackLimit(limitDtoRequest, clientId);
    }
}
