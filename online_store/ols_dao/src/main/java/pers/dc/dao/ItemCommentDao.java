package pers.dc.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pers.dc.bean.ItemsComments;
import pers.dc.bean.vo.CommentRecordVO;
import pers.dc.bean.vo.center.MyCommentVO;

import java.util.List;

public interface ItemCommentDao extends JpaRepository<ItemsComments, String> {
    List<ItemsComments> findAllByItemId(String itemId);

    @Query("select new pers.dc.bean.vo.CommentRecordVO(c.content, c.sepcName, u.nickname, u.face, c.createdTime) from ItemsComments c left join Users u on c.userId = u.id where c.itemId = ?1 and c.commentLevel = ?2")
    Page<CommentRecordVO> findAllByItemIdAndCommentLevel(String itemId, long commentLevel, Pageable pageable);

    @Query("select new pers.dc.bean.vo.CommentRecordVO(c.content, c.sepcName, u.nickname, u.face, c.createdTime) from ItemsComments c left join Users u on c.userId = u.id where c.itemId = ?1")
    Page<CommentRecordVO> findAllByItemId(String itemId, Pageable pageable);

    @Query("select new pers.dc.bean.vo.center.MyCommentVO(img.url, c.itemName, c.content, c.sepcName, c.createdTime) from ItemsComments c, ItemsImg img where c.userId = ?1 and c.itemId = img.itemId order by c.createdTime desc")
    Page<MyCommentVO> findMyComment(String userId, Pageable pageable);
}
