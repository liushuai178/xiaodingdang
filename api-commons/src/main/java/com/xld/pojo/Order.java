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
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "这是订单的主键")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @ApiModelProperty(value = "卧槽，没这个咋创建订单")
    private Integer goodsId;

    @ApiModelProperty(value = "你家商品不得人买啊")
    private Integer userId;

    @ApiModelProperty(value = "描述付款状态,默认0未付款")
    private Integer payStatus;

    @ApiModelProperty(value = "描述收货状态，默认0未收货")
    private Integer goodsStatus;

    @ApiModelProperty(value = "描述评价状态，默认0未评价，显示")
    private Integer evaluateStatus;

    @ApiModelProperty(value = "描述退款状态  ，默认0未产生")
    private Integer refundStatus;

    @ApiModelProperty(value = "描述退款结束或订单完成，默认0未结束或完成")
    private Integer dissapperStatus;


}
