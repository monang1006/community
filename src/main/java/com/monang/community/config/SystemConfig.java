/**  
 * All rights Reserved, Designed By www.jxdevelop.com<br>
 * <br>
 * @Copyright: 2018 www.jxdevelop.com Inc. All rights reserved. 
 */
package com.monang.community.config;

import com.fxkj.fxframe.kernel.spring.context.SpringContextUtil;
import com.fxkj.fxframe.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类名 ：SystemConfig<br>
 * <br>
 * 功能概要：从扩展配置文件（config-external.properties）中读取对应配置项工具类<br>
 * <br>
 * 创建日期：2018年9月17日 yubin<br>
 * <br>
 * 修改日期：<br>
 */
public class SystemConfig {

	static Logger logger = LoggerFactory.getLogger(SystemConfig.class);
	private static final String EXTERNAL_CONFIG_FILE_NAME = "config-external.properties";

	private static Properties configs = null;

	/**
	 * 获取扩展配置中指定配置项的值
	 * 
	 * @param name
	 *            -配置项名称
	 * @return
	 * @throws IOException
	 */
	public static String get(String name) throws IOException {
		if (configs == null) {
			String activeProfile = SpringContextUtil.getApplicationContext().getEnvironment().getActiveProfiles()[0];
			InputStream inputStream = SystemConfig.class.getClassLoader()
					.getResourceAsStream(activeProfile + "/" + EXTERNAL_CONFIG_FILE_NAME);
			configs = new Properties();
			configs.load(inputStream);
		}
		return configs.getProperty(name);
	}

	/**
	 * 获取扩展配置中指定配置项的值（字符串形式）
	 * 
	 * @param name
	 *            -配置项名称
	 * @param defaultValue
	 *            -配置项为空时的默认值
	 * @return
	 */
	public static String getString(String name, String defaultValue) {
		try {
			String value = get(name);
			if (StringUtil.isNotEmpty(value)) {
				return value;
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return defaultValue;
		}
		return defaultValue;
	}

	/**
	 * 获取扩展配置中指定配置项的值（整数形式）
	 * 
	 * @param name
	 *            -配置项名称
	 * @param defaultValue
	 *            -配置项为空时的默认值
	 * @return
	 */
	public static Integer getInteger(String name, int defaultValue) {
		try {
			String value = get(name);
			if (StringUtil.isNotEmpty(value)) {
				return Integer.parseInt(value);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return defaultValue;
		}
		return defaultValue;
	}

	/**
	 * 获取扩展配置中指定配置项的值（布尔值形式）
	 * 
	 * @param name
	 *            -配置项名称
	 * @param defaultValue
	 *            -配置项为空时的默认值
	 * @return
	 */
	public static Boolean getBoolean(String name, boolean defaultValue) {
		try {
			String value = get(name);
			if (StringUtil.isNotEmpty(value)) {
				return Boolean.valueOf(value);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return defaultValue;
		}
		return defaultValue;
	}

}
