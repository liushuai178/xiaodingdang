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
 * 
 * </p>
 *
 * @author liushuai
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Function对象", description="")
public class Function implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "function_id", type = IdType.AUTO)
    private Integer functionId;

    @ApiModelProperty(value = "收藏店铺id")
    private Integer concernShopsId;

    @ApiModelProperty(value = "收藏商品id")
    private Integer concernGoodsId;

    @ApiModelProperty(value = "粉丝id（用户id）")
    private Integer fansId;

    @ApiModelProperty(value = "店铺足迹id")
    private Integer trackShopsId;

    @ApiModelProperty(value = "商品足迹id")
    private Integer trackGoodsId;

    @ApiModelProperty(value = "收藏店铺id")
    private Integer collectShopsId;

    @ApiModelProperty(value = "收藏商品id")
    private Integer collectGoodsId;


}
