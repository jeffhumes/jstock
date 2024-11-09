package org.bofus.jstock.config;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "market.config")
public class MarketConfig {
  List<String> availableMarkets;
}
