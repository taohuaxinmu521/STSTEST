package com.example.demo;

import java.util.Date;

import com.github.crab2died.converter.WriteConvertible;
import com.github.crab2died.utils.DateUtils;

public class Student2DateConverter implements WriteConvertible {

	@Override
	public Object execWrite(Object object) {
		Date date = (Date) object;
        return DateUtils.date2Str(date, DateUtils.DATE_FORMAT_SEC);
	}

}
