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
@ApiModel(value="Coupon对象", description="")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "优惠券id")
    @TableId(value = "coupon_id", type = IdType.AUTO)
    private Integer couponId;

    @ApiModelProperty(value = "优惠券分类，1代表店铺优惠券，2代表平台优惠券")
    private String couponType;

    @ApiModelProperty(value = "优惠券状态，1未使用，2已使用，3已失效")
    private Integer couponStatus;

    @ApiModelProperty(value = "使用规则，1代表满减，2代表通用 3代表折扣")
    private Integer rule;

    @ApiModelProperty(value = "此处id为0代表全平台通用，不为0代表商家店铺的id，在此商家使用")
    private Integer storeId;


}
