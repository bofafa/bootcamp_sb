package bootcamp.com.bc_yahoo_finance.service.Impl;


import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.exception.LocalError;
import bootcamp.com.bc_yahoo_finance.infra.web.BusinessException;
import bootcamp.com.bc_yahoo_finance.infra.web.RedisHelper;
import bootcamp.com.bc_yahoo_finance.repository.TransactionRepository;
import bootcamp.com.bc_yahoo_finance.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {
  @Autowired
  private RedisHelper redisHelper;
  @Autowired
  private TransactionRepository stockPriceRepository;

  @Override
  public LocalDate getSysDate(String symbol) throws JsonProcessingException {
    String redisKey = "SYSDATE-".concat(symbol);
    String redisSysDate = this.redisHelper.get(redisKey, String.class);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
    if (redisSysDate == null) {
      Long lastMarketTime = stockPriceRepository.getMaxMarketTime(symbol);
      // System.out.println("lastMarketTime=" + lastMarketTime);
      if (lastMarketTime == null) {
        throw new BusinessException(null);
      }
      LocalDate dbSysDate = Instant.ofEpochSecond(lastMarketTime.longValue()) //
          .atZone(ZoneId.systemDefault()) //
          .toLocalDate();
      this.redisHelper.set(redisKey, dbSysDate.format(format),
          Duration.ofMinutes(5));
      return dbSysDate;
    }
    return LocalDate.parse(redisSysDate, format);
  }
}