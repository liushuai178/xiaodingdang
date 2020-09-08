package com.xld.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2020-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Goods对象", description="")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品名")
    private String goodsName;

    @ApiModelProperty(value = "商品价格")
    private Double goodsPrice;

    @ApiModelProperty(value = "商品数量")
    private String goodsNumber;

    @ApiModelProperty(value = "商品信息")
    private String goodsInfo;

    @ApiModelProperty(value = "商品类别id")
    @TableField("goods_categoryId")
    private Integer goodsCategoryid;

    @ApiModelProperty(value = "商品参加的活动类型")
    private Integer activityId;

    @ApiModelProperty(value = "所属店铺的id")
    private Integer storeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//格式化时间
    @ApiModelProperty(value = "商品活动开始时间")
    private Date goodsActivityTime;

    @ApiModelProperty(value = "商品参加的活动类型")
    private Activity activityName;

    @ApiModelProperty(value = "商品所属的分类")
    private Category categoryName;

    @ApiModelProperty(value = "商品所属店铺")
    private Store storeName;




}
