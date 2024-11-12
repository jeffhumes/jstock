package org.bofus.jstock.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class ArrayUtils {
  public List<String> deDupeStringList(List<String> list) {
    Set<String> set = new HashSet<>(list);
    list.clear();
    list.addAll(set);
    return list;
  }

  public List<Integer> deDupeIntegerList(List<Integer> list) {
    Set<Integer> set = new HashSet<>(list);
    list.clear();
    list.addAll(set);
    return list;
  }
}
