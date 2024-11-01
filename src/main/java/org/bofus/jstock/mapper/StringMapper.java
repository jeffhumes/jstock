package org.bofus.jstock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bofus.jstock.domain.StringBean;

@Mapper
public interface StringMapper {
  @Select("SELECT STRING_NAME, STRING_TEXT FROM jstock.staticStrings")
  public List<StringBean> getStringBeanList();
}
