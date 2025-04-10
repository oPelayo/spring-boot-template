package es.nextdigital.demo.service.Interface;

import java.math.BigDecimal;

public interface IAccountService {
    BigDecimal getAccountBalance(Long accountId) throws Exception;
}
