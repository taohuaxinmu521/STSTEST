package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.crab2died.ExcelUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExcel {
	
	private Logger logger = LoggerFactory.getLogger(TestExcel.class);
	
	@Test
	public void test(){
		logger.info("------------------6666--------------");
	}
	
	
	@Test
    public void testList2Excel() throws Exception {
        
        List<List<String>> list2 = new ArrayList<>();
        List<String> header = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> _list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                _list.add(i + " -- " + j);
            }
            list2.add(_list);
            header.add(i + "---");
        }
        ExcelUtils.getInstance().exportObjects2Excel(list2, header, "C:\\Users\\tanwen\\Desktop\\export\\D.xlsx");
    }
	
	
	// 验证日期转换函数 Student2DateConverter
    // 注解 `@ExcelField(title = "入学日期", order = 3, writeConverter = Student2DateConverter.class)`
    @Test
    public void testWriteConverter() throws Exception {

        List<Student2> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Student2(10000L + i, "学生" + i, new Date(), 201, false));
        }
        ExcelUtils.getInstance().exportObjects2Excel(list, Student2.class, true, "sheet0", true, "C:\\Users\\tanwen\\Desktop\\export\\B.xlsx");
    }
    
    
    
    @Test
    public void testObject2Excel() throws Exception {

        String tempPath = "C:\\Users\\tanwen\\Desktop\\export\\normal_template.xlsx";
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("1010001", "盖伦", "六年级三班"));
        list.add(new Student1("1010002", "古尔丹", "一年级三班"));
        list.add(new Student1("1010003", "蒙多(被开除了)", "六年级一班"));
        list.add(new Student1("1010004", "萝卜特", "三年级二班"));
        list.add(new Student1("1010005", "奥拉基", "三年级二班"));
        list.add(new Student1("1010006", "得嘞", "四年级二班"));
        list.add(new Student1("1010007", "瓜娃子", "五年级一班"));
        list.add(new Student1("1010008", "战三", "二年级一班"));
        list.add(new Student1("1010009", "李四", "一年级一班"));
        Map<String, String> data = new HashMap<>();
        data.put("title", "战争学院花名册");
        data.put("info", "学校统一花名册");
        // 基于模板导出Excel
        ExcelUtils.getInstance().exportObjects2Excel(tempPath, 0, list, data, Student1.class, false, "C:\\Users\\tanwen\\Desktop\\export\\E.xlsx");
        // 不基于模板导出Excel
        ExcelUtils.getInstance().exportObjects2Excel(list, Student1.class, true, null, true, "C:\\Users\\tanwen\\Desktop\\export\\F.xlsx");

    }

}
