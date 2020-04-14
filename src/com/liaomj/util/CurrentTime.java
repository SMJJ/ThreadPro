package com.liaomj.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	public static String currentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date()).toString();
	}
}
