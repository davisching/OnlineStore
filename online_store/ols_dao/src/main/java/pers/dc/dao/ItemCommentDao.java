package pers.dc.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pers.dc.bean.ItemsComments;
import pers.dc.bean.vo.CommentRecordVO;

import java.util.List;

public interface ItemCommentDao extends JpaRepository<ItemsComments, String> {
    List<ItemsComments> findAllByItemId(String itemId);

    @Query("select new pers.dc.bean.vo.CommentRecordVO(c.content, c.sepcName, u.nickname, u.face, c.createdTime) from ItemsComments c left join Users u on c.userId = u.id where c.itemId = ?1 and c.commentLevel = ?2")
    Page<CommentRecordVO> findAllByItemIdAndCommentLevel(String itemId, long commentLevel, Pageable pageable);

    @Query("select new pers.dc.bean.vo.CommentRecordVO(c.content, c.sepcName, u.nickname, u.face, c.createdTime) from ItemsComments c left join Users u on c.userId = u.id where c.itemId = ?1")
    Page<CommentRecordVO> findAllByItemId(String itemId, Pageable pageable);

}
