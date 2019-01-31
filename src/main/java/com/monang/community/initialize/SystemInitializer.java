/**
 * All rights Reserved, Designed By monang<br>
 * <br>
 *
 * @Copyright: 2019 monang. All rights reserved.
 */
package com.monang.community.initialize;

import java.io.InputStream;
import java.util.Properties;

/**
 * 类名：SystemInitializer<br>
 * <br>
 * 功能概要：系统初始化<br>
 * <br>
 * 创建日期：2019年01月31日 monang<br>
 * <br>
 * 修改日期：<br>
 */
public class SystemInitializer {
    public static void init() {

    }

    private static void readSystemConfig(){
        if (configs == null) {
            String activeProfile = SpringContextUtil.getApplicationContext().getEnvironment().getActiveProfiles()[0];
            InputStream inputStream = ExternalConfig.class.getClassLoader()
                    .getResourceAsStream(activeProfile + "/" + EXTERNAL_CONFIG_FILE_NAME);
            configs = new Properties();
            configs.load(inputStream);
        }
        return configs.getProperty(name);
    }
}
