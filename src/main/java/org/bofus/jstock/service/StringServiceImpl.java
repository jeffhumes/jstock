package org.bofus.jstock.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.domain.StringBean;
import org.bofus.jstock.mapper.StringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StringServiceImpl implements StringService {
  @Autowired StringMapper stringMapper;

  @Override
  public List<StringBean> getStringBeanList() {
    return stringMapper.getStringBeanList();
  }
}
