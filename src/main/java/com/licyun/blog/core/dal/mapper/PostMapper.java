package com.licyun.blog.core.dal.mapper;

import java.util.List;

import com.licyun.blog.core.dal.entity.Post;
import com.licyun.blog.core.plugin.MapContainer;
import com.licyun.blog.core.plugin.PageModel;
import com.licyun.blog.service.vo.PageVO;
import com.licyun.blog.service.vo.PostVO;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings("unchecked")
public interface PostMapper extends BaseMapper{

  @Override
  public PostVO loadById(String postid);

  /**
   * 获取制定post的下一篇
   * 
   * @param postid
   * @return
   */
  Post getPrevPost(String postid);

  /**
   * 获取指定post的上一篇
   * 
   * @param postid
   * @return
   */
  Post getNextPost(String postid);

  /**
   * 获取页面(只包含ID和title)
   * 
   * @param onlyParent
   * @return
   */
  List<PageVO> listPage(boolean onlyParent);

  /**
   * 列出文章归档
   * 
   * @return
   */
  List<MapContainer> listArchive();

  int addRcount(@Param("postid") String postid, @Param("count") int count);

  int addCcount(@Param("commentid") String commentid, @Param("count") int count);

  /**
   * 获取最近发表文章
   * 
   * @return 文章id
   */
  List<String> listRecent(@Param("nums") int nums, @Param("creator") String creator);

  List<String> listByMonth(PageModel<String> model);

  List<String> listByCategory(PageModel<String> model);

  List<String> listByTag(PageModel<String> model);

  void updateCategory(@Param("oldCategoryIds") List<String> oldCategoryIds, @Param("newCategoryId") String newCategoryId);

}
