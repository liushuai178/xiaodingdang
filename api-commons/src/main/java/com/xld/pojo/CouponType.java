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
@ApiModel(value="CouponType对象", description="")
public class CouponType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "优惠券类型id")
    @TableId(value = "coupon_type_id", type = IdType.AUTO)
    private Integer couponTypeId;

    @ApiModelProperty(value = "优惠券类型名称")
    private String couponTypeName;


}
