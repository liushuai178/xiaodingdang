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
@ApiModel(value="CouponRule对象", description="")
public class CouponRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "优惠券使用规则id")
    @TableId(value = "coupon_rule_id", type = IdType.AUTO)
    private Integer couponRuleId;

    @ApiModelProperty(value = "优惠券使用规则名称")
    private String couponRuleName;


}
