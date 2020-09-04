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
@ApiModel(value="Store对象", description="")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店铺id")
    @TableId(value = "store_id", type = IdType.AUTO)
    private Integer storeId;

    @ApiModelProperty(value = "店铺名")
    private String storeName;

    @ApiModelProperty(value = "店铺地址")
    private String storeAddress;


}
