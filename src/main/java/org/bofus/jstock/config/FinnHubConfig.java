package org.bofus.jstock.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "api.finnhub")
public class FinnHubConfig {
  private String baseUrl;
  private String apiKey;

  private String symbols_endpoint;
  private String symbol_lookup_endpoint;
  private String market_status_endpoint;
  private String market_holiday_endpoint;
  private String market_news_endpoint;
  private String company_news_endpoint;
  private String company_financials_endpoint;
  private String covid_19_endpoint;
}
