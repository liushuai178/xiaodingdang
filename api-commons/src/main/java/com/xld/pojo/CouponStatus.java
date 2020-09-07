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
@ApiModel(value="CouponStatus对象", description="")
public class CouponStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "优惠券状态id")
    @TableId(value = "coupon_status_id", type = IdType.AUTO)
    private Integer couponStatusId;

    @ApiModelProperty(value = "优惠券状态名称")
    private String couponStausName;


}
