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

    @ApiModelProperty(value = "关注用户id")
    private Integer concernArtcleId;

    @ApiModelProperty(value = "粉丝id（用户id）")
    private Integer fansId;

    @ApiModelProperty(value = "文章足迹id")
    private Integer trackArtcleId;

    @ApiModelProperty(value = "收藏文章id")
    private Integer collectArtcleId;



}
