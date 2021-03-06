package com.licyun.blog.core.dal.mapper;

import java.util.List;

import com.licyun.blog.core.dal.entity.Category;
import com.licyun.blog.core.plugin.MapContainer;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings("unchecked")
public interface CategoryMapper extends BaseMapper{

  List<MapContainer> list();

  Category loadByName(String name);

  /**
   * 获取指定分类的子分类
   * 
   * @param category
   * @return
   */
  List<Category> loadChildren(Category category);

  void updateInsertLeftv(int rightv);

  void updateInsertRightv(int rightv);

  void delete(@Param("leftv") int leftv, @Param("rightv") int rightv);

  void updateDeleteLeftv(@Param("leftv") int leftv, @Param("length") int length);

  void updateDeleteRightv(@Param("rightv") int rightv, @Param("length") int length);

}
