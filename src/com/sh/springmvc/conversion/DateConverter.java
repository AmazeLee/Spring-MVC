package com.sh.springmvc.conversion;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @ClassName: DateConverter 
 * @Description: 日期转换
 * @author lishuhua leeshuhua@163.com 
 * @date 2017年11月12日 下午8:28:16 
 *
 * Converter<S,T>
 * S source:需要转换的源的类型
 * T target：需要转换的目标类型
 */
public class DateConverter implements Converter<String,Date> {

	@Override
	public Date convert(String source) {
		try {
			// 把字符串转换为日期类型
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			Date date = simpleDateFormat.parse(source);

			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果转换异常则返回空
		return null;
	}
}
