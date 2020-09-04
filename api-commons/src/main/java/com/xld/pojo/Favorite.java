package com.xld.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户对商品的收藏
 * </p>
 *
 * @author liushuai
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Favorite对象", description="用户对商品的收藏")
public class Favorite implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "外键的作用——用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private Integer goodsId;


}
