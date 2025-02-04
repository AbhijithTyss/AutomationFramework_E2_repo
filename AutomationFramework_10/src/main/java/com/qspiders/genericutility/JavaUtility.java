package com.qspiders.genericutility;

import java.time.LocalDateTime;
/**
 * @author abhijith
 */
public class JavaUtility {
	/**
	 * This method will capture system date and time and return
	 * @return System date and time
	 */
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
}
