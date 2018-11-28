package com.aotain.common.utils.tools;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * 工具类
 * 
 * @author Administrator
 * 
 */
public class Tools {

	private static Logger logger = Logger.getLogger(Tools.class);

	/**
	 * 获得当前服务器的IP地址
	 * 
	 * @return
	 */
	public static String getHostAddress() {
		String ip = "";
		try {
			InetAddress addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress();
		} catch (Exception e) {
			logger.error("get host address error!", e);
		}
		return ip;
	}
	
	/**
	 * 获取服务器名+IP
	 * @return
	 */
	public static String getHostAddressAndIp() {
		String ip = "";
		try {
			InetAddress addr = InetAddress.getLocalHost();
			ip = addr.toString();
		} catch (Exception e) {
			logger.error("get host address error!", e);
		}
		return ip;
	}

	/**
	 * 获得当前服务器的主机名
	 * 
	 * @return
	 */
	public static String getHostName() {
		String hostname = "";
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (Exception e) {
			logger.error("get host name error!", e);
		}
		return hostname;
	}

	/**
	 * 获得配置文件路径
	 * 
	 * @return
	 */
	public static String getSystemWorkPath(Class<?> cls) {
		String path = System.getProperty("work.dir");
		if (path == null || path.length() == 0) {
			path = cls.getProtectionDomain().getCodeSource()
					.getLocation().getPath();// Thread.currentThread().getContextClassLoader().getResource("./").getPath();
			// path = path + "../";
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				path = path.replaceFirst("/", "");
			}
			System.setProperty("work.dir", path);
		}

		return path;
	}

	/**
	 * 判断字符串是否为空或NULL
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if (s == null || s.length() <= 0)
			return true;
		else
			return false;
	}

	public static String format2Two(String num) {
		if (num.length() < 2) {
			return "0" + num;
		}
		return num;
	}

	/**
	 * 构造一个批次ID
	 * 
	 * @return
	 */
	public static String getBatchId() {
		String mBatchId = "";
		Calendar cal = Calendar.getInstance();
		mBatchId = "" + cal.get(Calendar.YEAR);
		mBatchId += format2Two(cal.get(Calendar.MONTH) + 1 + "");
		mBatchId += format2Two(cal.get(Calendar.DAY_OF_MONTH) + "");
		mBatchId += format2Two(cal.get(Calendar.HOUR_OF_DAY) + "");
		mBatchId += format2Two(cal.get(Calendar.MINUTE) + "");
		mBatchId += format2Two(cal.get(Calendar.SECOND) + "");
		mBatchId += format2Two(cal.get(Calendar.MILLISECOND) + "");
		mBatchId += getUUIDPrefix();
		return mBatchId;
	}

	public static String getUUIDPrefix() {
		String result = "";
		// 550E8400-E29B-11D4-A716-446655440000
		UUID uuid = UUID.randomUUID();
		String temp = uuid.toString();
		if (temp.contains("-")) {
			result = temp.substring(0, 8);
		}
		return result;
	}

	public static byte[] joinBytes(byte[] srcByte1, byte[] srcByte2) {
		int byte1Length = srcByte1.length;
		int byte2Length = srcByte2.length;
		byte[] retByte = new byte[byte1Length + byte2Length];
		System.arraycopy(srcByte1, 0, retByte, 0, byte1Length);
		System.arraycopy(srcByte2, 0, retByte, byte1Length, byte2Length);
		return retByte;
	}

	public static String getDateStr(long timestamp) {
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date(timestamp);
		return dateFormater.format(date);
	}

	public static String getDatetimeStr(long timestamp) {
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(timestamp);
		return dateFormater.format(date);
	}
	
	public static List<BigInteger> str2List(String mStr, String separator) {
		List<BigInteger> list = new ArrayList<BigInteger>();
		if (mStr != null) {
			String[] strs = mStr.split(separator);
			for (int i = 0; i < strs.length; i++) {
				list.add(new BigInteger(strs[i]));
			}
		}
		return list;
	}
	public static boolean isNumeric(String str) {
		if(str == null) return false;
		Pattern pattern = Pattern.compile("-?[0-9]+");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
	/**
	 * 判断是否是IP地址
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isIpAddress(String s) {
		if (s == null)
			return false;
		String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}

	/**
	 * 判断是否是IPV6地址
	 *
	 * @param s
	 * @return
	 */
	public static boolean isIpV6Address(String s) {
		if (s == null)
			return false;
		boolean result = false;
		String regex = "^(^((\\p{XDigit}{1,4}):){7}(\\p{XDigit}{1,4})$)|(^(::((\\p{XDigit}{1,4}):){0,5}(\\p{XDigit}{1,4}))$)|(^((\\p{XDigit}{1,4})(:|::)){0,6}(\\p{XDigit}{1,4})$)$";;
		if (s.indexOf(":") != -1)
		{
			if (s.length() <= 39)
			{
				String addressTemp = s;
				int doubleColon = 0;
				if(s.equals("::"))return true;
				while (addressTemp.indexOf("::") != -1)
				{
					addressTemp = addressTemp.substring(addressTemp
							.indexOf("::") + 2, addressTemp.length());
					doubleColon++;
				}
				if (doubleColon <= 1)
				{
					result = s.matches(regex);
				}
			}
		}
		return result;
	}

	/**
	 * ipv6转int
	 *
	 */
	public static BigInteger ipv6toInt(String ipv6)
	{

		int compressIndex = ipv6.indexOf("::");
		if (compressIndex != -1)
		{
			String part1s = ipv6.substring(0, compressIndex);
			String part2s = ipv6.substring(compressIndex + 1);
			BigInteger part1 = ipv6toInt(part1s);
			BigInteger part2 = ipv6toInt(part2s);
			int part1hasDot = 0;
			char ch[] = part1s.toCharArray();
			for (char c : ch)
			{
				if (c == ':')
				{
					part1hasDot++;
				}
			}
			// ipv6 has most 7 dot
			return part1.shiftLeft(16 * (7 - part1hasDot )).add(part2);
		}
		String[] str = ipv6.split(":");
		BigInteger big = BigInteger.ZERO;
		for (int i = 0; i < str.length; i++)
		{
			//::1
			if (str[i].isEmpty())
			{
				str[i] = "0";
			}
			big = big.add(BigInteger.valueOf(Long.valueOf(str[i], 16))
					.shiftLeft(16 * (str.length - i - 1)));
		}
		return big;
	}

	/**
	 * int 转ipv6
	 *
	 * @author : songl
	 * @since:2018年7月11日 下午8:00:43
	 */
	public static String int2ipv6(BigInteger big)
	{
		String str = "";
		BigInteger ff = BigInteger.valueOf(0xffff);
		for (int i = 0; i < 8 ; i++)
		{
			str = big.and(ff).toString(16) + ":" + str;

			big = big.shiftRight(16);
		}
		//the last :
		str = str.substring(0, str.length() - 1);

		return str.replaceFirst("(^|:)(0+(:|$)){2,8}", "::");
	}

	/**
	 * ip地址转成整数.
	 * 
	 * @param ip
	 * @return
	 */
	public static long ip2long(String ip) {
		if (!isIpAddress(ip))
			return -1;

		String[] ips = ip.split("[.]");
		long num = 16777216L * Long.parseLong(ips[0]) + 65536L
				* Long.parseLong(ips[1]) + 256 * Long.parseLong(ips[2])
				+ Long.parseLong(ips[3]);

		return num;
	}

	/**
	 * 整数转成ip地址.
	 * 
	 * @param ipLong
	 * @return
	 */
	public static String long2ip(long ipLong) {
		long mask[] = { 0x000000FF, 0x0000FF00, 0x00FF0000, 0xFF000000 };
		long num = 0;
		StringBuffer ipInfo = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			num = (ipLong & mask[i]) >> (i * 8);
			if (i > 0)
				ipInfo.insert(0, ".");
			ipInfo.insert(0, Long.toString(num, 10));
		}
		return ipInfo.toString();
	}

	/**
	 * 存储单位转换方法
	 * @param size 单位为Byte
	 * @return
	 */
	public static String formatStorageUnit(BigDecimal size) {
		BigDecimal bd1024 = new BigDecimal(1024);
		BigDecimal unit_k = size.divide(bd1024);
		int rsize = 3;
		if(unit_k.compareTo(BigDecimal.ONE) == -1){
			return size.setScale(1,BigDecimal.ROUND_HALF_DOWN)+"(Byte)";
		}
		BigDecimal unit_m = unit_k.divide(bd1024);
		if(unit_m.compareTo(BigDecimal.ONE) == -1){
			return unit_k.setScale(rsize,BigDecimal.ROUND_HALF_DOWN)+"(KB)";
		}
		BigDecimal unit_g = unit_m.divide(bd1024);
		if(unit_g.compareTo(BigDecimal.ONE) == -1){
			return unit_m.setScale(rsize,BigDecimal.ROUND_HALF_DOWN)+"(MB)";
		}
		BigDecimal unit_t = unit_g.divide(bd1024);
		if(unit_t.compareTo(BigDecimal.ONE) == -1){
			return unit_g.setScale(rsize,BigDecimal.ROUND_HALF_DOWN)+"(GB)";
		}
		return unit_t.setScale(6,BigDecimal.ROUND_HALF_DOWN)+"(TB)";
	}
	
	public static void main(String[] args) {
		System.out.println(formatStorageUnit(new BigDecimal(1023L*1024L*1024L*1024L*102)));
	}
}
