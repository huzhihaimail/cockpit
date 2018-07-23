package cn.com.njdhy.muscle.triceps.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;


/**
 * @Author Richard.li
 * @Description
 * @Date 2018/7/20
 **/
public class ExportExcelUtil {

    // 2007 版本以上 最大支持1048576行
    public  final static String  EXCEl_FILE_2007 = "2007";
    // 2003 版本 最大支持65536 行
    public  final static String  EXCEL_FILE_2003 = "2003";

    /**
     * HSSFWorkbook
     * 导出excel生成2003版本的excel,文件名后缀：xls <br>
     * @param list 数据集合
     * @param column 列名
     * @param os  输出流
     */
    public static <T> void exportExcel(List<T> list, List<String> column, OutputStream os) {

        // 声明一个工作薄
        XSSFWorkbook wb = new XSSFWorkbook();
        // 声明一个单子并命名
        XSSFSheet sheet = wb.createSheet("1");
        // 给单子名称一个长度
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        XSSFCellStyle style = wb.createCellStyle();
        // 创建第一行（也可以称为表头）
        XSSFRow row = sheet.createRow(0);
        // 样式字体居中
        style.setAlignment(HorizontalAlignment.CENTER);
        // 给表头第一行一次创建单元格
        if (column == null || column.size() == 0)
            return ;
        for (int index = 0; index < column.size(); index++) {
            XSSFCell cell = row.createCell(index);
            // 名称..
            cell.setCellValue(column.get(index));
            cell.setCellStyle(style);
        }


        JSONArray jsonarray = (JSONArray) JSONObject.toJSON(list);
        // 向单元格里填充数据
        for (short i = 0; i < jsonarray.size(); i++) {
            row = sheet.createRow(i + 1);
            JSONObject jsonObject = jsonarray.getJSONObject(i);
            for (int index = 0; index < column.size(); index++) {
                row.createCell(index).setCellValue(jsonObject.get(column.get(index)) + "");
            }
        }

        try {
            wb.write(os);
            wb.close();
        } catch (Exception e) {

        }
    }



}
