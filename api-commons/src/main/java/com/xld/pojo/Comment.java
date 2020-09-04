package com.xld.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author liushuai
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @ApiModelProperty(value = "书本id")
    private Integer bookId;

    @ApiModelProperty(value = "评论内容")
    private String commentText;

    @ApiModelProperty(value = "评论时间")
    private LocalDateTime commentTime;

    @ApiModelProperty(value = "发评论的人")
    private Integer userId;

    @ApiModelProperty(value = "点赞")
    private Integer like;

    @ApiModelProperty(value = "收藏评论的状态")
    private Integer collect;


}
