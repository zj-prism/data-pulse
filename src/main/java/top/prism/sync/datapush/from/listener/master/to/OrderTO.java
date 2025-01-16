package top.prism.sync.datapush.from.listener.master.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 订单
 *
 * Author jack jack@126.com
 * @since 1.0.0 2024-02-25
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class OrderTO {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 创建人
	 */
	private Long  creator;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新者
	 */
	private Long  updater;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	* 订单编号
	*/
	private String orderNum;

	/**
	* 运营商订单号
	*/
	private String operatorOrderNum;

	/**
	* 订单类型 1-号卡 2-存量
	*/
	private String orderType;

	/**
	* 订单来源
	*/
	private String orderSource;

	/**
	* 下单时间
	*/
	private Date orderTime;

	/**
	 * 运营商 ID
	 */
	private Long operatorId;

	/**
	 * 运营商Code
	 */
	private String operatorCode;

	/**
	* 商品id
	*/
	private Long commodityId;

	/**
	* 商品名称
	*/
	private String commodityName;

	/**
	 * 商品id
	 */
	private Long parentCommodityId;

	/**
	 * 商品名称
	 */
	private String parentCommodityName;

	/**
	* 商户id
	*/
	private Long merchantId;

	/**
	* 商户用户id
	*/
	private Long merchantUserId;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	* 用户联系手机号
	*/
	private String mobile;

	/**
	* 身份证
	*/
	private String idCard;

	/**
	* 省份
	*/
	private String province;

	/**
	* 市
	*/
	private String city;

	/**
	* 区县
	*/
	private String county;

	/**
	* 地址
	*/
	private String address;

	/**
	 * 原详细地址
	 */
	private String sourceAddress;


	/**
	* 售出号码
	*/
	private String sellMobile;

	/**
	* 验证码
	*/
	private String validCode;

	/**
	* 落地页地址
	*/
	private String processUrl;

	/**
	* 激活时间
	*/
	private Date activeTime;

	/**
	* 物流单号
	*/
	private String expressNum;

	/**
	* 快递公司
	*/
	private String expressCompany;

	/**
	 * 发货时间
	 */
	private Date shipTime;

	/**
	 * 退订时间
	 */
	private Date unsubscribeTime;

	/**
	* 订单状态
	*/
	private String orderStatus;

	/**
	* 运营商状态
	*/
	private String operatorStatus;

	/**
	* 失败原因
	*/
	private String msg;

	/**
	* 外部订单号
	*/
	private String outOrderNum;

	/**
	* 年龄
	*/
	private Long age;

	/**
	 * 特征值 ID
	 */
	private Long merchantEigenValId;

	/**
	 * 特征值
	 */
	private String merchantEigenValCode;

	/**
	 *转单进程id
	 */
	private String transferProcessId;

	/**
	 *转单记录id
	 */
	private Long transferRecordId;


	/**
	 * 扣量标识0-不扣 1-扣订单 2-扣激活
	 */
	private Integer deductStatus;

	private Integer rechargeTag;

	private Double rechargeMoney;

	private Double addUpRechargeMoney;

	private Integer orderFlag;

	/**
	 * 运营商参数  p码
	 */
	private String operatorTag;

	/**
	 * p码名称
	 */
	private String operatorTagName;
	/**
	 * app包名
	 */
	private String appPackage;
}