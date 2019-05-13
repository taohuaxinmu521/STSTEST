package com.example.demo.easyexcel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.example.demo.model.Student1;
import com.github.crab2died.ExcelUtils;

@Controller
public class ExcelController {
	
	
	private Logger logger = LoggerFactory.getLogger(ExcelController.class);
	
	@RequestMapping("export")
	@ResponseBody
	public String export(HttpServletResponse response){
		
		OutputStream out = null;
		try {
			out = new FileOutputStream("C:\\Users\\tanwen\\Desktop\\export\\exports.xlsx");
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
        try {
        	
        	ExcelWriter writer = EasyExcelFactory.getWriter(out);
        	
            Sheet sheet1 = new Sheet(1, 0,PersonDto.class);
            sheet1.setSheetName("第一个sheet");
            writer.write(getListString(), sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return "SUCCESS";
	}

	private List<? extends BaseRowModel> getListString() {
		
		List<PersonDto> list = new ArrayList<>();
		PersonDto pto = null;
		
		for(int i = 0; i <1000000; i++){
			pto = new PersonDto();
			pto.setAddress("陕西省汉中市");
			pto.setAge("20");
			pto.setEmail("690387060@qq.com");
			pto.setHeigh("180");
			pto.setLast("2019");
			pto.setName("谈闻");
			pto.setSax("Nan");
			list.add(pto);
		}
		
		return list;
	}
	
	
	@RequestMapping("2excel")
	public void testObject2Excel(HttpServletResponse response) throws Exception {
		
		logger.info("开始导出Excel文件，，，，，，，，，，");

        String tempPath = "C:\\Users\\tanwen\\Desktop\\export\\normal_template.xlsx";
        List<Student1> list = new ArrayList<>();
        Student1 student = null;
        for(int i =0; i<10000; i++){
        	student = new Student1("10000" + i, "盖伦", "六年级三班");
        	list.add(student);
        }
        
        Map<String, String> data = new HashMap<>();
        data.put("title", "战争学院花名册");
        data.put("info", "学校统一花名册");
        
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        
        // 基于模板导出Excel
        ExcelUtils.getInstance().exportObjects2Excel(tempPath, 0, list, data, Student1.class, false, os);
        

        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);

        String name = "用户列表";
        //对文件名称进行转码，不然中文会乱码
        String newName = new String(name.getBytes("UTF-8"),"ISO8859-1");

        response.reset();
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;filename=\"" +newName+".xlsx"+ "\"");

        ServletOutputStream out = response.getOutputStream();

        byte[] buff = new byte[1024];
        int m;

        while ((m = is.read(buff)) !=-1) {
            out.write(buff, 0, m);
        }
        
        logger.info("导出Excel文件结束，，，，，，，，，，");

	}
}
