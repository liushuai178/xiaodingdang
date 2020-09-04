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
@ApiModel(value="ShopCar对象", description="")
public class ShopCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "car_id", type = IdType.AUTO)
    private Integer carId;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "数量")
    private Integer goodsNumber;

    @ApiModelProperty(value = "总价")
    private Double totalPrice;

    @ApiModelProperty(value = "用户id")
    private Integer userId;


}
