package com.aotain.common.utils.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 行政区域代码爬虫
 * 
 * @author liuz@aotian.com
 * @date 2018年7月11日 下午9:47:05
 */
public class AreaCodeCrawler {
	private static int id = 1;
	private static String MATCH_REGEX_STR = "^\\s*<tr type=\"2\" .*>$|^\\s*<td.*>.*</td>$|^\\s*</tr>$";
	private static Pattern MATCH_REGEX_CITY = Pattern.compile("^\\s*<td class=\"name_left\".*value=\"(.*)\" name=\"hid\">.*</td>$");
	private static Pattern MATCH_REGEX_COUNTRY = Pattern.compile("^\\s*<td class=\"name_left\">\\s*(.*)\\s*<input type=.*name=\"hidzxs\"></td>$");
	private static Pattern MATCH_REGEX_TD = Pattern.compile("^\\s*<td.*>\\s*(.*)\\s*</td>.*$");
	
	private static List<String> NO_COUNTRY_ARRAY = Arrays.asList("东莞市","中山市","嘉峪关市","三沙市","儋州市");
	
	private static void initRequestList(Map<String,String> requestList){
		requestList.put("北京市","http://xzqh.mca.gov.cn/defaultQuery?shengji=%B1%B1%BE%A9%CA%D0%28%BE%A9%29&diji=%B1%B1%BE%A9%CA%D0&xianji=-1");
		requestList.put("天津市","http://xzqh.mca.gov.cn/defaultQuery?shengji=%CC%EC%BD%F2%CA%D0%28%BD%F2%29&diji=-1&xianji=-1");
		requestList.put("河北省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BA%D3%B1%B1%CA%A1%28%BC%BD%29&diji=-1&xianji=-1");
		requestList.put("山西省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%C9%BD%CE%F7%CA%A1%28%BD%FA%29&diji=-1&xianji=-1");
		requestList.put("内蒙古自治区","http://xzqh.mca.gov.cn/defaultQuery?shengji=%C4%DA%C3%C9%B9%C5%D7%D4%D6%CE%C7%F8%28%C4%DA%C3%C9%B9%C5%29&diji=-1&xianji=-1");
		requestList.put("辽宁省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%C1%C9%C4%FE%CA%A1%28%C1%C9%29&diji=-1&xianji=-1");
		requestList.put("吉林省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BC%AA%C1%D6%CA%A1%28%BC%AA%29&diji=-1&xianji=-1");
		requestList.put("黑龙江省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BA%DA%C1%FA%BD%AD%CA%A1%28%BA%DA%29&diji=-1&xianji=-1");
		requestList.put("上海市","http://xzqh.mca.gov.cn/defaultQuery?shengji=%C9%CF%BA%A3%CA%D0%28%BB%A6%29&diji=%C9%CF%BA%A3%CA%D0&xianji=-1");
		requestList.put("江苏省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BD%AD%CB%D5%CA%A1%28%CB%D5%29&diji=-1&xianji=-1");
		requestList.put("浙江省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%D5%E3%BD%AD%CA%A1%28%D5%E3%29&diji=-1&xianji=-1");
		requestList.put("安徽省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%B0%B2%BB%D5%CA%A1%28%CD%EE%29&diji=-1&xianji=-1");
		requestList.put("福建省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%B8%A3%BD%A8%CA%A1%28%C3%F6%29&diji=-1&xianji=-1");
		requestList.put("江西省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BD%AD%CE%F7%CA%A1%28%B8%D3%29&diji=-1&xianji=-1");
		requestList.put("山东省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%C9%BD%B6%AB%CA%A1%28%C2%B3%29&diji=-1&xianji=-1");
		requestList.put("河南省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BA%D3%C4%CF%CA%A1%28%D4%A5%29&diji=-1&xianji=-1");
		requestList.put("湖北省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BA%FE%B1%B1%CA%A1%28%B6%F5%29&diji=-1&xianji=-1");
		requestList.put("湖南省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BA%FE%C4%CF%CA%A1%28%CF%E6%29&diji=-1&xianji=-1");
		requestList.put("广东省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%B9%E3%B6%AB%CA%A1%28%D4%C1%29&diji=-1&xianji=-1");
		requestList.put("广西壮族自治区","http://xzqh.mca.gov.cn/defaultQuery?shengji=%B9%E3%CE%F7%D7%B3%D7%E5%D7%D4%D6%CE%C7%F8%28%B9%F0%29&diji=-1&xianji=-1");
		requestList.put("海南省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%BA%A3%C4%CF%CA%A1%28%C7%ED%29&diji=-1&xianji=-1");
		requestList.put("重庆市","http://xzqh.mca.gov.cn/defaultQuery?shengji=%D6%D8%C7%EC%CA%D0%28%D3%E5%29&diji=%D6%D8%C7%EC%CA%D0&xianji=-1");
		requestList.put("四川省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%CB%C4%B4%A8%CA%A1%28%B4%A8%A1%A2%CA%F1%29&diji=-1&xianji=-1");
		requestList.put("贵州省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%B9%F3%D6%DD%CA%A1%28%C7%AD%A1%A2%B9%F3%29&diji=-1&xianji=-1");
		requestList.put("云南省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%D4%C6%C4%CF%CA%A1%28%B5%E1%A1%A2%D4%C6%29&diji=-1&xianji=-1");
		requestList.put("西藏自治区","http://xzqh.mca.gov.cn/defaultQuery?shengji=%CE%F7%B2%D8%D7%D4%D6%CE%C7%F8%28%B2%D8%29&diji=-1&xianji=-1");
		requestList.put("陕西省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%C9%C2%CE%F7%CA%A1%28%C9%C2%A1%A2%C7%D8%29&diji=-1&xianji=-1");
		requestList.put("甘肃省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%B8%CA%CB%E0%CA%A1%28%B8%CA%A1%A2%C2%A4%29&diji=-1&xianji=-1");
		requestList.put("宁夏回族自治区","http://xzqh.mca.gov.cn/defaultQuery?shengji=%C4%FE%CF%C4%BB%D8%D7%E5%D7%D4%D6%CE%C7%F8%28%C4%FE%29&diji=-1&xianji=-1");
		requestList.put("青海省","http://xzqh.mca.gov.cn/defaultQuery?shengji=%C7%E0%BA%A3%CA%A1%28%C7%E0%29&diji=-1&xianji=-1");
		requestList.put("新疆维吾尔族自治区","http://xzqh.mca.gov.cn/defaultQuery?shengji=%D0%C2%BD%AE%CE%AC%CE%E1%B6%FB%D7%D4%D6%CE%C7%F8%28%D0%C2%29&diji=-1&xianji=-1");
		requestList.put("香港特别行政区","http://xzqh.mca.gov.cn/defaultQuery?shengji=%CF%E3%B8%DB%CC%D8%B1%F0%D0%D0%D5%FE%C7%F8%28%B8%DB%29&diji=-1&xianji=-1");
		requestList.put("澳门特别行政区","http://xzqh.mca.gov.cn/defaultQuery?shengji=%B0%C4%C3%C5%CC%D8%B1%F0%D0%D0%D5%FE%C7%F8%28%B0%C4%29&diji=-1&xianji=-1");
		requestList.put("台湾省","");
	}
	
	/**
	 * 爬取数据
	 * @param key
	 * @param url
	 */
	private static List<String> crawling(String key,String url){
		List<String> list = new ArrayList<String>();
		if(StringUtils.isBlank(key)){
			return list;
		}
		if("台湾省".equals(key)){
			list.add(buildSqlForLevelOne(id++,"710000",key, null, null));
			return list;
		}
		if("香港特别行政区".equals(key)){
			list.add(buildSqlForLevelOne(id++,"810000",key, null, "0852"));
			return list;
		}
		if("澳门特别行政区".equals(key)){
			list.add(buildSqlForLevelOne(id++,"820000",key, null, "0853"));
			return list;
		}
		// 爬取一个网页，逐条解析其中的行政区域代码信息，并构造SQL
		List<String> docs = doGet(url);
		System.out.println("请求到"+docs.size()+"行数据");
		for(int i = 0 ; i < docs.size(); i++) {
			String line = docs.get(i);
			Matcher m = MATCH_REGEX_CITY.matcher(line);
			if(!m.find()){
				 // 跳过无效行
				continue;
			}
			String nextParentCode = "000000";
			// 1. 取市名称
			String cityName = m.group(1);
			// 2. 取市行政区域代码
			i += 2; // 跳过两行
			line = docs.get(i);
			String xzqhCode = parseTdValue(line);
			// 3. 取区号
			line = docs.get(++i);
			String areaCode = parseTdValue(line);
			// 4. 取邮编
			line = docs.get(++i);
			String postCode = parseTdValue(line);
			// 5. 取父节点值
			String parentCode = null;
			boolean needWaitCountryInfo = false;
			if(StringUtils.isBlank(postCode) && StringUtils.isNotBlank(xzqhCode)){ // 可判断为直辖市
				parentCode = "000000";
				needWaitCountryInfo = true;
			}else{
				parentCode = parseParentCode(xzqhCode,2); // 市级的parenCode:将后两位转成'0'
			}
			
			// 6. 初始化后面市级别以下的ParentCode
			nextParentCode = xzqhCode;
			boolean hasDealNON = true;
			if(!needWaitCountryInfo){ // 无需等待从县级别获取邮编信息时，直接生成sql；否则等待下条县级信息
				// 省直辖单位过滤掉一条无效数据
				// 三种情况：省直辖县级行政单位，自治区直辖县级行政单位，省直辖县级行政单位
				if(!StringUtils.isBlank(xzqhCode)){
					// 7. 构造市级别的sql
					// 第一个市需要：构造省级单位sql
					if(list.size() == 0){
						String sql = buildSql(id++, parseParentCode(parentCode,4), parseParentCode(parentCode,6), key, trimNull(postCode,6), trimNull(areaCode,4), 1);
						list.add(sql);
					}
				
					// 构造一个市级单位sql
					String sql = buildSql(id++, xzqhCode, parseParentCode(parentCode,4), cityName, trimNull(postCode,6), trimNull(areaCode,4), 2);
					list.add(sql);
					// 有些市下面没有3级行政单位，直接跳过第三级行政单位的获取
					if(NO_COUNTRY_ARRAY.contains(cityName)) {
						continue;
					}
				}else{
					// "NON"表示省直辖单位
					nextParentCode = "NON";
					hasDealNON = false;
				}
			}
			
			
			i++;
			// 8. 循环读取县级单位
			for(;i < docs.size();i++){
				line = docs.get(i);
//				System.out.println(line);
				Matcher m1 = MATCH_REGEX_COUNTRY.matcher(line);
				if(!m1.find()){
					 // 跳过无效行
					continue;
				}
				// 1. 取县名称
				String countryName = m1.group(1);
				// 2. 取县行政区域代码
				i += 4; // 跳过四行
				line = docs.get(i);
				String xzqhCodeCountry = parseTdValue(line);
				// 3. 取区号
				line = docs.get(++i);
				String areaCodeCountry = parseTdValue(line);
				// 4. 取邮编
				line = docs.get(++i);
				String postCodeCountry = parseTdValue(line);
//				// 5. 取父节点值
				String parentCodeCountry = nextParentCode.equals("NON") ? parseParentCode(xzqhCodeCountry,2):nextParentCode; // "NON"表示省直辖单位 
				if(!hasDealNON){ // 构造一个省直辖单位（市级）
					String sql = buildSql(id++, parseParentCode(xzqhCodeCountry,2), parseParentCode(xzqhCodeCountry,4), cityName, trimNull(postCodeCountry,4), trimNull(areaCode,4), 2);
					list.add(sql);
					hasDealNON = true;
				}
				if(needWaitCountryInfo){ // 直辖市需要等待第一条县级信息取到后组装sql
					String sql = buildSql(id++, xzqhCode, parentCode, cityName, parseParentCode(trimNull(postCodeCountry,6),4), trimNull(areaCodeCountry,4), 1); 
					list.add(sql);
					needWaitCountryInfo = false;
				}
				// 添加县级单位
				if(StringUtils.isBlank(postCodeCountry)){
					postCodeCountry = postCode;
				}
				if(StringUtils.isBlank(areaCodeCountry)){
					areaCodeCountry = areaCode;
				}
				
				// 构造县级行政单位
				String sql = buildSql(id++, xzqhCodeCountry, parentCodeCountry, countryName, trimNull(postCodeCountry,6), trimNull(areaCodeCountry,4), 3); 
				list.add(sql);
				
				// 尝试寻找下一个市级单位，找到后退出内层循环
				int tid = i + 2;
				m = MATCH_REGEX_CITY.matcher(docs.get(tid));
				if(m.find()){
					break;
				}
			}
		}
		return list;
	}
	
	private static String parseParentCode(String xzqhCode,int length) {
		char[] n = new char[length];
		Arrays.fill(n, '0');
		return xzqhCode.replaceAll("\\d{"+length+"}$", new String(n));
	}

	private static String parseTdValue(String line){
		if(StringUtils.isBlank(line)){
			return "";
		}
		Matcher m = MATCH_REGEX_TD.matcher(line);
		if(m.find()){
			return m.group(1);
		}
		return "";
	}
	
	private static List<String> doGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        List<String>  list = new ArrayList<String>();
        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "GBK"));
                // 存放数据
                String temp = null;
                while ((temp = br.readLine()) != null) {
                	if(temp.matches(MATCH_REGEX_STR)){
                		list.add(temp);
                	}
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }
		return list;

    }
	
	/**
	 * 特别行政区以及台湾sql语句构造
	 * @param id
	 * @param xzqhCode
	 * @param mc
	 * @param postCode
	 * @param areaCode
	 * @return
	 */
	private static String buildSqlForLevelOne(int id,String xzqhCode,String mc,String postCode,String areaCode){
		return buildSql(id,xzqhCode,"000000",mc, postCode, areaCode,1); 
	}
	
	/**
	 * 组装一条sql插入语句
	 * @param id
	 * @param xzqhCode
	 * @param parentCode
	 * @param mc
	 * @param postCode
	 * @param areaCode
	 * @param codeLevel
	 * @return
	 */
	private static String buildSql(int id,String xzqhCode,String parentCode,String mc,String postCode,String areaCode,int codeLevel){
		if(null != areaCode && areaCode.length() == 3){
			areaCode += '0';
		}
		return "INSERT INTO IDC_JCDM_XZQYDM(ID,CODE,PARENTCODE,MC,CODELEVEL,POSTCODE,AREACODE) VALUES("+id+",'"+xzqhCode+"','"+parentCode+"','"+trimStartChar(mc)+"',"+codeLevel+",'"+trimNull(postCode,6)+"','"+trimNull(areaCode,4)+"');";
	}
	
	private static String trimStartChar(String mc) {
		if(!mc.contains("☆")){
			return mc;
		}
		return mc.replace("☆", "");
	}

	private static String trimNull(String value,int length){
		char[] n = new char[length];
		Arrays.fill(n, '0');
		return StringUtils.isBlank(value) ? new String(n) : value;
	}
	
	private static void writeSqlFile(String key,List<String> sqlList,FileOutputStream ismsSqlFile,FileOutputStream passportSqlFile){
		String warning = "-- 省份："+key+"\t记录条数："+sqlList.size();
		try {
			ismsSqlFile.write(getBytes(warning));
			passportSqlFile.write(getBytes(warning));
			for(String sql : sqlList) {
				ismsSqlFile.write(getBytes(sql));
				passportSqlFile.write(getBytes(toPassportSql(sql)));
			}
			ismsSqlFile.flush();
			passportSqlFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String toPassportSql(String sql){
		// AREACODE,PARENT,AREANAME,AREATYPE;
		return sql.replace("IDC_JCDM_XZQYDM", "DIC_CHINAAREA").replace("ID,CODE,PARENTCODE,MC,CODELEVEL,POSTCODE,AREACODE", "AREACODE,PARENT,AREANAME").replaceAll("VALUES\\(\\d+,", "VALUES(").replaceAll(",\\d+,'\\d{6}','\\d{3,4}'\\);$", ");");
	}
	
	private static byte[] getBytes(String value) {
		try {
			return (value+"\r\n").getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
	
	public static void main(String[] args) throws IOException {
		Map<String,String> requestList = new HashMap<String,String>();
		// 初始化请求列表
		initRequestList(requestList);
		
		File ismsSqlFile = new File("./isms_xzqhdm.sql");
		File passportSqlFile = new File("./passport_xzqhdm.sql");
		FileOutputStream fos1 = new FileOutputStream(ismsSqlFile);
		FileOutputStream fos2 = new FileOutputStream(passportSqlFile);
		
		int total = 0;
		// 轮循爬取数据
		for(String key : requestList.keySet()) {
			System.out.println("开始请求"+key+",URL="+requestList.get(key));
			List<String> sqlList = crawling(key, requestList.get(key));
			total += sqlList.size();
			writeSqlFile(key, sqlList, fos1, fos2);
			System.out.println("抓取到记录："+sqlList.size()+"条");
		}
		System.out.println("抓取记录总数："+total+"条");
		System.out.println("输出文件："+ismsSqlFile.getCanonicalFile().getAbsolutePath());
		System.out.println("输出文件："+passportSqlFile.getCanonicalFile().getAbsolutePath());
		fos1.close();
		fos2.close();
		
	}
}
