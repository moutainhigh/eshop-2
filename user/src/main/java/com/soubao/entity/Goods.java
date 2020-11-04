package com.soubao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.soubao.common.utils.TimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.HtmlUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@ApiModel(value = "商品主体对象", description = "goods表")
public class Goods implements Serializable {
    @ApiModelProperty(value = "商品id")
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;
    @ApiModelProperty(value = "一级商品分类id")
    private Integer catId1;
    @ApiModelProperty(value = "二级商品分类id")
    private Integer catId2;
    @ApiModelProperty(value = "三级商品分类id")
    private Integer catId3;
    @ApiModelProperty(value = "店铺一级商品分类")
    private Integer storeCatId1;
    @ApiModelProperty(value = "店铺二级商品分类")
    private Integer storeCatId2;
    @ApiModelProperty(value = "商品编号")
    private String goodsSn;
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    @ApiModelProperty(value = "点击数")
    private Integer clickCount;
    @ApiModelProperty(value = "品牌表主键")
    private Integer brandId;
    @ApiModelProperty(value = "库存数量")
    private Integer storeCount;
    @ApiModelProperty(value = "商品收藏数")
    private Integer collectSum;
    @ApiModelProperty(value = "商品评论数")
    private Short commentCount;
    @ApiModelProperty(value = "商品重量(克)")
    private Integer weight;
    @ApiModelProperty(value = "商品体积(立方米)")
    private Double volume;
    @ApiModelProperty(value = "市场价(RMB)")
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "本店价(RMB)")
    private BigDecimal shopPrice;
    @ApiModelProperty(value = "商品成本价(RMB)")
    private BigDecimal costPrice;
    @ApiModelProperty(value = "积分兑换(0不参与积分兑换)")
    private Integer exchangeIntegral;
    @ApiModelProperty(value = "商品关键词")
    private String keywords;
    @ApiModelProperty(value = "商品简单描述")
    private String goodsRemark;
    @ApiModelProperty(value = "商品主图url")
    private String originalImg;
    @ApiModelProperty(value = "是否为虚拟商品(1是,0否)")
    private Integer isVirtual;
    @ApiModelProperty(value = "虚拟商品有效截止日期(时间戳)")
    private Integer virtualIndate;
    @ApiModelProperty(value = "虚拟商品购买上限")
    private Short virtualLimit;
    @ApiModelProperty(value = "虚拟商品是否允许过期退款(1是,0否)")
    private Integer virtualRefund;
    @ApiModelProperty(value = "0下架,1上架,2违规下架")
    private Integer isOnSale;
    @ApiModelProperty(value = "是否包邮")
    private Integer isFreeShipping;
    @ApiModelProperty(value = "商品上架时间(时间戳)")
    private Long onTime;
    @ApiModelProperty(value = "商品排序权重值")
    private Short sort;
    @ApiModelProperty(value = "是否推荐")
    private Integer isRecommend;
    @ApiModelProperty(value = "是否新品")
    private Integer isNew;
    @ApiModelProperty(value = "是否热卖")
    private Integer isHot;
    @ApiModelProperty(value = "最后更新时间")
    private String lastUpdate;
    @ApiModelProperty(value = "商品模型表主键")
    private Integer goodsType;
    @ApiModelProperty(value = "购买商品时赠送积分")
    private Integer giveIntegral;
    @ApiModelProperty(value = "真实的商品销量总数")
    private Integer salesSum;
    @ApiModelProperty(value = "商品虚拟销量总数")
    private Integer virtualSalesSum;
    @ApiModelProperty(value = "商品活动类型(0默认,1抢购,2团购,3优惠促销,4预售,5虚拟(其实没用),6拼团)")
    private Integer promType;
    @ApiModelProperty(value = "商品活动主键")
    private Integer promId;
    @ApiModelProperty(value = "佣金用于分销分成(RMB)")
    private BigDecimal distribut;
    @ApiModelProperty(value = "店铺表主键")
    private Integer storeId;
    @ApiModelProperty(value = "spu")
    private String spu;
    @ApiModelProperty(value = "sku")
    private String sku;
    @ApiModelProperty(value = "商品审核状态(0待审核,1审核通过,2审核失败)")
    private Integer goodsState;
    @ApiModelProperty(value = "违规下架原因")
    private String closeReason;
    @ApiModelProperty(value = "供应商表主键")
    private Short suppliersId;
    @ApiModelProperty(value = "运费模板表主键")
    private Integer templateId;
    @ApiModelProperty(value = "视频地址url")
    private String video;
    @ApiModelProperty(value = "商品标签表主键")
    private String labelId;
    @ApiModelProperty(value = "关联版式头部")
    private Integer plateTop;
    @ApiModelProperty(value = "关联版式底部")
    private Integer plateBottom;
    @ApiModelProperty(value = "pc商品详细描述(html文本)")
    private String goodsContent;

    public String getGoodsContent() {
        if (goodsContent != null) {
            return HtmlUtils.htmlUnescape(goodsContent);
        }
        return null;
    }

    @ApiModelProperty(value = "移动端商品详细描述(html文本)")
    private String mobileContent;
    @ApiModelProperty(value = "1:第三方自营店,2:总平台自营店")
    private Integer isOwnShop;
    /**
     * 以下不是数据库字段
     */
    @ApiModelProperty(value = "规格最小价(RMB)")
    @TableField(exist = false)
    private BigDecimal minShopPrice;
    @ApiModelProperty(value = "规格最高价(RMB)")
    @TableField(exist = false)
    private BigDecimal maxShopPrice;
    @ApiModelProperty(value = "商品上下架描述(0下架,1出售中,2违规下架)")
    @TableField(exist = false)
    private String isOnSaleDesc;

    public String getIsOnSaleDesc() {
        if (isOnSale != null) {
            if (isOnSale == 0) {
                return "下架";
            } else if (isOnSale == 1) {
                return "出售中";
            } else if (isOnSale == 2) {
                return "违规下架";
            }
        }
        return null;
    }

    @ApiModelProperty(value = "商品上架时间格式化")
    @TableField(exist = false)
    private String onTimeDesc;

    public String getOnTimeDesc() {
        if (onTime != null) {
            return TimeUtil.transForDateStr(onTime, "yyyy-MM-dd");
        }
        return onTimeDesc;
    }

    @ApiModelProperty(value = "最终的商品销量总数")
    @TableField(exist = false)
    private Integer showSaleSum;

    public Integer getShowSaleSum() {
        if (salesSum != null && virtualSalesSum != null) {
            showSaleSum = salesSum + virtualSalesSum;
        }
        return showSaleSum;
    }

    @ApiModelProperty(value = "商品审核状态描述(待审核,通过,未通过)")
    @TableField(exist = false)
    private String goodsStateDesc;

    public String getGoodsStateDesc() {
        if (goodsState != null) {
            if (goodsState == 0) {
                return "待审核";
            } else if (goodsState == 1) {
                return "通过";
            } else if (goodsState == 2) {
                return "未通过";
            }
        }
        return null;
    }

    @ApiModelProperty(value = "商品归属描述(平台联营,平台自营,加盟店)")
    @TableField(exist = false)
    private String isOwnShopDesc;

    public String getIsOwnShopDesc() {
        if (isOwnShop != null) {
            if (isOwnShop == 1) {
                return "平台联营";
            } else if (isOwnShop == 2) {
                return "平台自营";
            } else {
                return "加盟店";
            }
        }
        return null;
    }


    @ApiModelProperty(value = "商品离某定位的距离")
    @TableField(exist = false)
    private String distance;
    @ApiModelProperty(value = "店铺节点")
    @TableField(exist = false)
    private Store store;
    @ApiModelProperty(value = "商品分佣比例(%)")
    @TableField(exist = false)
    private Integer commission;
    @ApiModelProperty(value = "是否配送")
    @TableField(exist = false)
    private Integer isDelivery;

    private static final long serialVersionUID = 1L;
}