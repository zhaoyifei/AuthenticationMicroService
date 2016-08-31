package com.zyifly.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	
	private static Logger LOG = Logger.getLogger("root");

	private static ConfigUtil instance = new ConfigUtil();
	
	private Properties p = new Properties();

	private ConfigUtil() {
		try {
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("config.properties");
			if (null != is) {
				p.load(is);
				is.close();
			}
		} catch (IOException e) {
			LOG.error(e);
		}
	}

	public static ConfigUtil getInstance() {
		return instance;
	}

	public String get(String key, String def) {
		return p.getProperty(key, def);
	}

	public String get(String key) {
		String val = p.getProperty(key);
		if (LOG.isDebugEnabled()) {
			LOG.debug("[load] " + key + "=" + val );
		}
		return val;
	}

	public int getInt(String key, int def) {
		String val = p.getProperty(key);
		if (null != val) {
			return Integer.valueOf(val);
		} else {
			return def;
		}
	}

	public long getLong(String key, long def) {
		String val = p.getProperty(key); 
		if (null != val) {
			return Long.valueOf(val);
		} else {
			return def;
		}
	}
}
