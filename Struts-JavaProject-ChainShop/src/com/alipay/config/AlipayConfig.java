package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091300504323";//2016091300504323
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCJL3zQnC+ngRUVDoMnUP+b+rGiPhvEqnKgk70+CaQCppMN2+U6OStmdQZvBuUvuHCXgKLkZvBW6Twq51I9fiFqwu4tglfT05+usRQqYkudKfCJSaOY9z3lir+OfcXWrQZL/69F5I3ZWty6gyp9bm2jLzt/UbR8MBpdxlkmy8zSflr9lpSVm4KbLHlwlkxaeV75S8vHtk4ky+fRypnu1rbG45WU9A4CFP3JLY7eCVqrTqfUcCaU8PSZ8C6nYSFzYszOj+LK/jI1VNLOLw5QOW1xxrs6qcQ9Hm0rkyBYIOnEBqiJb0fg+DL3/7TArtxrdu9l8VeQz7pKdHXJ4Mc+bCOFAgMBAAECggEAOzdNWDri8xnsAL/X6yOygiDPhmnq0JSGkDvVhy7gJejDN0tBAkXlLv+6vDgsu9GQgEUdixvICKv6tcZOII8OW6gy6WAHCz+hAOYc/0KYwwl0c75eqMuoYynmD9rIiCb9vdZrUO8cL8Nh3fx6XdRJ7ROZShb5olWdO/c/SljUW9Ndx+AEQB6EHKUbJIy4MEcls2yTn0a8Rkj+oOp6RoQVZYGXCkhq5+06iwSEwhbt3pxqu6/dgcA4VMFnovBJguSp1OCF9M7Aqx5qktPqr0B3GF28AEN8upgN45FIk2wd64V6gYiw64h0CuYuYk26IX2+gpxBn+0eBgYOlx9qvHuGYQKBgQDVfXmbFjGb3Ae86QeWJ07mqfmilRNTv5zBSv2QIePigfKqrG3D0ZidYE9la/YLLRNP+El0v2NBwiNgBdtw30hSWh3lJaY+cIaatks6cYloMvAAZjaV1jIGWxBpZ1B4tJdTvJ/QAIE7eFcCUK6IwclVdGLdFHjjEViezyUoHebMPQKBgQCkgG6G8tB+MBQmlUu4kiMKYYajZygLm2yWiE+sqeWSkJ8tkVaGa2Djn96uA7z/SGvRaUpB3Bb1wT38MRxQWFI3Zw7UEdcQyqHztFLL4wC4asjTltY6Q+B6p4GHIENnHkNp/BU+l3yN3HfYcyrmiuJL2kZArRdJb1m24R902VFA6QKBgBkq96EO1r5XDBp7JkfPTn/m3eUKygJ/fk1TN908AY98Xk08kpwZI3K6HeII/jKHF9W/oXk/7sWby2vQhPQjfnUm5otTCuwle9jVUL0NEXPVPXHumtTDMZaKOb8TTOtN7uESRYzR4mpOX4OIW2sH3WJTnCwP88hhDR97sBewnrrJAoGAVH+kRq1za15G+4q02po2ZZ6zCjxy1YOAw9JBGvAqfJ7NJRsC1wlRO5tjRv+klX0d5POwsSPcp2Ab9u9DHAJCOTM26rg/QODVT9nQreps9E3l2sogQM2dAWQJpN9twApLlqVmRECMOlKFPSnrX4D3vP7iF1bSH2aTLt10yxDWLAECgYBmR3SFfoR4cs55U1AHGZM8NsocVYxyoPeS0rYvlFoL1THyfrKQ710qma11zyULX7hV7JvIptsizFxsqqLCGdgNObLOHRtVXEvtF1HDZqRKfTlcPMGpJWJV7W3b/+eicFTOtmFfEFNJQ7XxpZYG3tBLKBDCfysdPhxsq3aXIvOXbg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyUL2hR4cy5EeVnMoynJPQnuDozWuz0mViOLIeKeQmi7nlQIjepA5yuGTzvb8GOgdW1bzFKG/4FFLn5NPr/IxzPv++6oBLtLQDlUanOamJYcfmPIKA85tpGoqdv1XT2c/j5jJ6S84KvHwLJ0D71Nvg53kk0VqehhghX5nCk98i51uvN/qWYnbSV1D9R3PzV31iluBCck9IUjx7shcGmf96TogGimtyIz2bJlDh7H/BAwfIWjwNaNMsauMht2wsU3v9H7pnPqt6jZq5l/nxrxbNN9/+ftGQ7Gz0wC3rzAD1Czu+bjUgLMu91pm/oABdKoFlQb5Gw/iJnqvDy1Swg/F0wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
	public static String return_url = "http://localhost:8080/Struts-JavaProject-ChainShop/return_url.jsp";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

