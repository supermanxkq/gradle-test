package com.xukaiqiang.blog.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:(String工具类)
 * @author wang.zx 
 * @date 2014-12-20 下午10:46:58
 * @version 1.0
 */
public class StringUtil {
	
	/********************************************************
	  功    能：返回一个字符串去掉右边空格后的值，如果为null则返回空串
	  入口参数：param str:待处理的字符串
	  出口参数：
	  返    回：去掉右边空格后的字符串或者空串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static String getValue(String str)
	{
		if (str==null) {return "";}
		if (str.trim().length()<=0) return "";
		str="H"+str;
		str=str.trim();
		str=str.substring(1);
		return str;
	}
	
	/********************************************************
	  功    能：判断一个字符串是否为空值（null或者空串）
	  入口参数：param str:待判断的字符串
	  出口参数：
	  返    回：true：空，false：非空
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean isStrEmpty(String str) {
		if ( (str == null) || (str.equals(""))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/********************************************************
	  功    能：判断一个字符串去掉空格后是否为空值（null或者空串）
	  入口参数：param str:待判断的字符串
	  出口参数：
	  返    回：true：空，false：非空
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean isStrTrimEmpty(String str) {
		if ( str == null || str.trim().equals("")) {
			return true;
		}
		else {
			return false;
		}
	}

	/********************************************************
	  功    能：判断一个字符串是否超出给定长度
	  入口参数：param text:待判断的字符串；param len:给定的长度
	  出口参数：
	  返    回：return true：未超过，false：为空或者超过
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean chkTextLen(String text, int len) {
		if (text==null || text.length() > len) {
			return false;
		}
		else {
			return true;
		}
	}

	/********************************************************
	  功    能：判断一个字符串去掉空格是否超出给定长度
	  入口参数：param text:待判断的字符串；param len:给定的长度
	  出口参数：
	  返    回：return true：未超过，false：为空或者超过
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean chkTextTrimLen(String text, int len) {
		if (text==null || text.trim().length() > len) {
			return false;
		}
		else {
			return true;
		}
	}

	/********************************************************
	  功    能：判断一个字符串是否只有english
	  入口参数：param text:待判断的字符串；
	  出口参数：
	  返    回：return true：合法，false:含有中文或者其它非法字符
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean isStrEn(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) > 127) {
				return false;
			}
		}
		return true;
	}
	
	/********************************************************
	  功    能：判断一个字符串是否数字
	  入口参数：param ch:待判断的字符
	  出口参数：
	  返    回：return true：数字，false:非数字
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean isCharNum(char ch) {
		if (ch > 47 && ch < 58) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/********************************************************
	  功    能：判断一个字符串是否含有非数字的字符
	  入口参数：param str:待判断的字符串
	  出口参数：
	  返    回：return true：Null或者不全是数字，false:全是数字
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean isStrNum(String str) {
		if (isStrEmpty(str)) {
			return true;
		}
		boolean notNum = false;
		for (int i = 0; i < str.length(); i++) {
			if (!isCharNum(str.charAt(i))) {
				notNum = true;
			}
		}
		return !notNum;
	}
	
	/********************************************************
	  功    能：判断一个字符串是否含有非数字的字符
	  入口参数：param strSrc:待判断的字符串
	  出口参数：
	  返    回：return true：全是数字，false:不全是数字
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean isNum(String strSrc) throws Exception {
		for (int i = 0; i < strSrc.length(); i++) {
			if (!isCharNum(strSrc.charAt(i)))
				return false;
	    }
	    return true;
	}
	
	/********************************************************
	  功    能：判断一个字符是否是英文字母
	  入口参数：param ch:待判断的字符
	  出口参数：
	  返    回：return true：是英文字母，false:不是英文字母
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean isCharLetter(char ch) {
		if ( (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
			return true;
		}
		else {
			return false;
		}
	}

	/********************************************************
	  功    能：判断一个字符串是否全是英文字母
	  入口参数：param str:待判断的字符串
	  出口参数：
	  返    回：return true：NULL或含有非英文字母，false:全是英文字母
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static boolean isStrLetter(String str) {
		if (isStrEmpty(str))
			return true;
		boolean notLetter = false;
		for (int i = 0; i < str.length(); i++) {
			if (!isCharLetter(str.charAt(i))) {
				notLetter = true;
			}
		}
		return !notLetter;
	}

	/********************************************************
	  功    能：假如传入的字符串是null则转成空串，否则返回原字符串
	  入口参数：param Content:待转换的字符串
	  出口参数：
	  返    回：如果字符串是null则转成空串，否则返回原字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public String nullToSpace(String Content) {
		if (Content == null) {
			Content = "";
		}
		return Content;
	}
	  
	/********************************************************
	  功    能：将传入的字符串取出第一个字符返回
	  入口参数：param src:传入的字符串
	  出口参数：
	  返    回：return 将传入的字符串取出第一个字符返回
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static char StrToChar(String src) {
		src = src.trim();
		char result = src.charAt(0);
		return result;
	}
	
	/********************************************************
	  功    能：将传入的字符串转成对应的ASCII码串
	  入口参数：param sql:待编码的sql条件串
	  出口参数：
	  返    回：编码后的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static String encodeSQL(String sql) {
		StringBuffer tempBuff = new StringBuffer();
		for (int i = 0; i < sql.length(); i++) {
			tempBuff.append(Integer.toHexString(sql.charAt(i)));
		}
		return tempBuff.toString();
	}

	/********************************************************
	  功    能：将传入的ASCII码串解码为对应的字符串
	  入口参数：param encoded:待解码的字符串
	  出口参数：
	  返    回：解码后的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static String decodeSQL(String encoded) {
		StringBuffer tempBuff = new StringBuffer();
		for (int i = 0; i < encoded.length(); i += 2) {
			tempBuff.append((char) Integer.parseInt(
					encoded.substring(i, i + 2), 16));
		}
		return tempBuff.toString();
	}
	
	/********************************************************
	  功    能：获取相对路径
	  入口参数：param path1:绝对路径，param context1:上下文
	  出口参数：
	  返    回：return 相对路径
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static String getAbsolutePath(String path1,String context1)
	{
		int i1=path1.indexOf(context1);
		if (i1<0) {return path1;}
		else {
			return path1.substring(path1.indexOf(context1)+context1.length());
		}
	}
	
	/********************************************************
	  功    能：获取子串
	  入口参数：param str1:待取子串的字符串，param sindex:起始位置，param eindex:结束位置
	  出口参数：
	  返    回：返回从起始位置开始结束位置结束的子串，如果结束位置小于0，则返回从起始位置开始的子串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static String getSubString(String str1,int sindex,int eindex)
	{
		if (str1==null) {return "";}
	    if (str1.trim().length()<=0) return "";
	    if (str1.length()>sindex)
	    {
	      if (eindex>=0)
	      return str1.substring(sindex, eindex);
	      else if (eindex<0)
	      return str1.substring(sindex);
	    }
	    return "";
	}
	

	  

	
	
	/********************************************************
	  功    能：将字符串数组扩充到指定的大小，不足的用空串补齐
	  入口参数：param strs:待扩充的字符串数组，param size1:给定的数组长度
	  出口参数：
	  返    回：return 括充后的字符串数组
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
	public static String[] getValues(String[] strs,int size1)
	{
	    String[] strs1=new String[size1];
	    for (int i=0;i<size1;i++)
	    {
	      strs1[i]="";
	    }
	    if  (strs==null) { return strs1;}
	    else {
	      if (strs.length<size1)
	      {
	         for (int i=0;i<strs.length;i++)
	         {
	           strs1[i]=strs[i];
	         }
	         return strs1;
	      }
	      else {
	        return strs;
	      }
	    }
	}
	
	/********************************************************
	  功    能：字符串全局替换函数
	  入口参数：param strSource  待替换的字符串，param strFrom  源字符串，param strTo  目的字符串
	  出口参数：
	  返    回：替换后的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String replaceStrAll(String strSource,String strFrom,String strTo)
    {
    	String strDest = "";
    	int intFromLen = strFrom.length();
    	int intPos;
    	while((intPos = strSource.indexOf(strFrom)) != -1)
    	{
             strDest = strDest + strSource.substring(0,intPos);
             strDest = strDest + strTo;
             strSource = strSource.substring(intPos + intFromLen);
    	}
    	strDest = strDest + strSource;
    	return strDest;
    }
    
    /********************************************************
	  功    能：把换行符替换成指定的字符串
	  入口参数：param strTarget  待处理的字符串，param strNew  要替掉\n的串
	  出口参数：
	  返    回：替换后的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/

    public static String replaceStr(String strTarget, String strNew) {

      int iIndex = -1;
      while (true) {

        iIndex = strTarget.indexOf('\n');

        if (iIndex < 0) {
          break;
        }

        String strTemp = null;
        strTemp = strTarget.substring(0, iIndex);

        strTarget = strTemp + strNew + strTarget.substring(iIndex + 1);

      }

      return strTarget;

    }
    
    /********************************************************
	  功    能：判断字符串数组中是否含有该字符串
	  入口参数：param str1 待寻找的字符串，param strarray 待寻找的字符串数组，
	  出口参数：
	  返    回：return true：含有;false：未含有
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static boolean includestr(String str1,String[] strarray)
    {
    	if (strarray==null || strarray.length<=0) return false;
    	for (int i=0;i<strarray.length;i++)	
    	{
    		if (strarray[i]==null)
    		{
    			if (str1==null) return true;
    			else continue;	
    		} 
    		if (strarray[i].trim().equals(str1))
    		{
    			return true;	
    		}	
    	}
    	return false;
    }
    
    /********************************************************
	  功    能：用\n作为分隔符，把字符串分隔成数组，并去掉\r
	  入口参数：param fvalue 待转换的字符串
	  出口参数：
	  返    回：return 转换后的数组
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String[] getAreaValues(String fvalue)
    {
       String tmpstr=fvalue;
       int i=0;
       if (tmpstr==null) return null;
       if (tmpstr.trim().equals("")) return null;
       while (tmpstr.indexOf("\n")>=0)
       {i++;
        tmpstr=tmpstr.substring(tmpstr.indexOf("\n")+1);
       }
       if (tmpstr.trim().equals("")) {i--;}
       String[] fvalues=new String[i+1];
       tmpstr=fvalue;
       i=0;
       while (tmpstr.indexOf("\n")>=0)
       {
          fvalues[i]=tmpstr.substring(0,tmpstr.indexOf("\n"));
          if (fvalues[i].indexOf("\r")>=0) fvalues[i]=fvalues[i].substring(0,fvalues[i].indexOf("\r"));
          i++;
          tmpstr = tmpstr.substring(tmpstr.indexOf("\n") + 1);
       }
       if (!tmpstr.trim().equals(""))
       fvalues[i]=tmpstr;
       return fvalues;
    }
    
    /********************************************************
	  功    能：将字符串中的|转成带\n
	  入口参数：param fvalue 待转换的字符串
	  出口参数：
	  返    回：转换后的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String getrealAreaValues(String fvalue)
    {
       String tmpstr=fvalue;
       String returnstr="";
       if (tmpstr==null) return null;
       if (tmpstr.trim().equals("")) return "";
       while (tmpstr.indexOf("|")>0)
       {
        returnstr+=tmpstr.substring(0,tmpstr.indexOf("|"))+"\n";
        tmpstr=tmpstr.substring(tmpstr.indexOf("|")+1);
       }
       return returnstr;
    }
    
    /********************************************************
	  功    能：计算字符串中含有的指定字符的个数
	  入口参数：param strInput 待计算的字符串，param chr 待寻找的字符
	  出口参数：
	  返    回：return 计算的字符个数
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static int CountChar(String strInput, char chr) {
      int iCount = 0;
      char chrTmp = ' ';
      
      if (strInput.trim().length()==0)
          return 0;
      //计算分割出多少割字符串
      for (int i = 0; i < strInput.length(); i++) {
        chrTmp = strInput.charAt(i);
        if (chrTmp == chr) {
          iCount++;
        }
      }
      return iCount;
    }
   
    
    /********************************************************
	  功    能：将二维数组转成一串字符串送出
	  入口参数：param strs 待转换的字符串数组
	  出口参数：
	  返    回：无
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String StrArrayToStr(String[] strs) {
    	StringBuffer returnstr=new StringBuffer("");
    	if (strs==null) return "";
    	for (int i = 0; i < strs.length; i++) {
    		returnstr.append(strs[i]);
    	}
    	return returnstr.toString();
    }
    /********************************************************
	  功    能：换行的打印出字符串数组的数据
	  入口参数：param strs 待打印的字符串数组
	  出口参数：
	  返    回：无
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static void printStrs(String[] strs) {
      for (int i = 0; i < strs.length; i++) {
        System.out.println(strs[i]);
      }
    }
    
    /********************************************************
	  功    能：二维不换行，一维换行的打印出字符串数组的数据
	  入口参数：param strs 待打印的二维字符串数组
	  出口参数：
	  返    回：无
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static void printDualStr(String[][] dualStr) {
      for (int i = 0; i < dualStr.length; i++) {
        for (int j = 0; j < dualStr[i].length; j++) {
          System.out.print(dualStr[i][j] + " ");
        }
        System.out.println();
      }
    }
    
    /********************************************************
	  功    能：将二维数组横数颠倒，将行变为列，将列变为行
	  入口参数：param dualStr 输入的二维数组
	  出口参数：
	  返    回：return 颠倒后的二维数组
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String[][] rowToColumn(String[][] dualStr) {
      String[][] returnDualStr = null;
      if (dualStr != null) {
        returnDualStr = new String[dualStr[0].length][dualStr.length];
        for (int i = 0; i < dualStr.length; i++)
          for (int j = 0; j < dualStr[0].length; j++)
            returnDualStr[j][i] = dualStr[i][j];
      }
      return returnDualStr;
    }
    
    /********************************************************
	  功    能：将要赋值给页面显示域的String内容中的特殊字符加上转意符
	  入口参数：param inStr 输入的字符串
	  出口参数：
	  返    回：return 添加转意符后的字符串  
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String latinString(String inStr) {
        String res=inStr;
        if(null==res)	return null;
        res=replaceStrAll(res,"\"","\\\"");
        res=replaceStrAll(res,"'","\\'");
        return res;
    }
    
    /********************************************************
	  功    能：将字符串所有空格替换成指定串
	  入口参数：param String strTarget, String strNew
	  出口参数：
	  返    回：return String 返回已被替换的字串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String replaceWhiteSpace(String strTarget, String strNew) {

      int iIndex = -1;
      while (true) {
        char cRep = 32;
        iIndex = strTarget.indexOf(cRep);

        if (iIndex < 0) {
          break;
        }

        String strTemp = null;
        strTemp = strTarget.substring(0, iIndex);

        strTarget = strTemp + strNew + strTarget.substring(iIndex + 1);

      }

      return strTarget;

    }
   
    /********************************************************
	  功    能：将金额改写成符合要求的小数点位数，只去掉多余的小数点位数，不扩展位数；
	  入口参数：param amount 输入的金额, param length 指定的小数位长度
	  出口参数：
	  返    回：return 添加转意符后的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String double2str(double amount, int length) {
        String strAmt = Double.toString(amount);

        int pos = strAmt.indexOf('.');

        if (pos != -1 && strAmt.length() > length + pos + 1)
          strAmt = strAmt.substring(0, pos + length + 1);

        return strAmt;
    }
    
    /********************************************************
	  功    能：根据chr分割字符串，因为String类自带的split不支持以"|"为分割符；
	  入口参数：param str 将要被分割的串,param chr 分割符号
	  出口参数：
	  返    回：return String[] 分割后的字符串数组,不包含最后一个|后面的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String[] doSplit(String str, char chr) {
      int iCount = 0;
      char chrTmp = ' ';
      //计算分割出多少割字符串
      for (int i = 0; i < str.length(); i++) {
        chrTmp = str.charAt(i);
        if (chrTmp == chr) {
          iCount++;
        }
      }
      String[] strArray = new String[iCount];
      for (int i = 0; i < iCount; i++) {
        int iPos = str.indexOf(chr);
        if (iPos == 0) {
          strArray[i] = "";
        }
        else {
          strArray[i] = str.substring(0, iPos);
        }
        str = str.substring(iPos + 1); //从iPos+1到结束,str长度逐步缩小
      }
      return strArray;
    }

    /********************************************************
	  功    能：根据s分割字符串，因为String类自带的split不支持以"|"为分割符，
	  入口参数：param str 将要被分割的串,param s 分割符号
	  出口参数：
	  返    回：return String[] 分割后的字符串数组,包含最后一个|后面的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
/******** mark by yebin 20141220
    public static String[] SplitStr(String str,char s)
    {
      String[] t=null;
      char[] c=null;
      StringBuffer x=new StringBuffer();
      int i,j,n,k;
      t=null;
      if(str==null) return null;
      if(str.length()==0)return null;
      c=str.toCharArray();
      n=c.length;
      for(j=0,i=0;i<n;i++)
      {
        if(c[i] == s)
        {
          j++;
        }
      }
      t=new String[j+1];
      for(k=0,j=0,i=0;i<n;i++)
      {
         if(c[i] == s)
         {
            t[j]=str.substring(k,i);
            j++;
            k=i+1;
         }
      }
      t[j]=str.substring(k,i);
      return t;
    }
******************/
    
    

    /********************************************************
	  功    能：将字符串缩小到指定长度，多余的部分用...概括
	  入口参数：param src 将要被处理的串,param len  指定大小
	  出口参数：
	  返    回：return String 缩小到指定长度，多余的部分用...概括的字符串
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String strIntercept(String src, int len) {
    	if (src == null) {
    		return "";
    	}
    	if (src.length() > len) {
    		src = String.valueOf(String.valueOf(src.substring(0, len))).concat(
          "...");
    	}
    	return src;
    }

    /********************************************************
	  功    能：将字符串转成ISO8859_1编码
	  入口参数：param str_in 要被处理的字符串；
	  出口参数：
	  返    回：return String 转换后的字符串；
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String strtochn(String str_in) {
    	try {
    		String temp_p = str_in;
    		if (temp_p == null) {
    			temp_p = "";
    		}
    		String temp = "";
    		if (!temp_p.equals("")) {
    			byte[] byte1 = temp_p.getBytes("ISO8859_1");
    			temp = new String(byte1);
    		}
    		return temp;
    	}
    	catch (Exception e) {
    	}
    	return "null";
    }

    /********************************************************
	  功    能：将ISO8859_1字符串转成GBK编码
	  入口参数：param strvalue 要被处理的字符串；
	  出口参数：
	  返    回：return String 转换后的字符串；
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String ISO2GBK(String strvalue) {
    	try {
    		if (strvalue == null)
    			return null;
    		else {
    			strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK");
    			return strvalue;
    		}
    	}
    	catch (Exception e) {
    		return null;
    	}
    }
    
    /********************************************************
	  功    能：将GBK字符串转成ISO8859_1编码
	  入口参数：param strvalue 要被处理的字符串；
	  出口参数：
	  返    回：return String 转换后的字符串；
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public String GBK2ISO(String strvalue) throws Exception {
    	try {
    		if (strvalue == null)
    			return null;
    		else {
    			strvalue = new String(strvalue.getBytes("GBK"), "ISO8859_1");
    			return strvalue;
    		}
    	}
    	catch (Exception e) {
    		return null;
    	}
    }

    /********************************************************
	  功    能：在页面要显示中文对其进行编码转化
	  入口参数：param str 要被处理的字符串；
	  出口参数：
	  返    回：return String 转换后的字符串；
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static String cnCodeTrans(String str) {
    	String s = "";
    	try {
    		s = new String(str.getBytes("GB2312"), "8859_1");
    	}
    	catch (UnsupportedEncodingException a) {
    		System.out.print("chinese thansform exception");
    	}
    	return s;
    }
    /********************************************************
	  功    能：对页面要传入中文对其进行转码处理
	  入口参数：param str 要被处理的字符串；
	  出口参数：
	  返    回：return String 转换后的字符串；
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
  public static String chiEnUTF8(String str) {
  	String s = "";
  	try {
  		s = new String(java.net.URLEncoder.encode(str,"UTF-8"));
  	}
  	catch (UnsupportedEncodingException a) {
  		System.out.print("chinese thansform exception");
  	}
  	return s;
  }
  
  /********************************************************
  功    能：对页面传入中文对其进行解码处理，并转换为UTF-8
  入口参数：param str 要被处理的字符串；
  出口参数：
  返    回：return String 转换后的字符串；
  整 理 人：
  编写日期：20141220
  修改备注：
  ********************************************************/
public static String chiDeUTF8(String str) {
	String s = "";
	try {
		s = new String(java.net.URLDecoder.decode(str,"UTF-8"));
	    
		byte[] bytes = s.getBytes("ISO-8859-1");    
	    s = new String(bytes, "UTF-8"); 
	}
	catch (UnsupportedEncodingException a) {
		System.out.print("chinese thansform exception");
	}
	return s;
} 
  
    /********************************************************
	  功    能：判断源串是否符合规则，例：STaaaa符合ST******
	  入口参数：param strSource要被处理的字符串；param strRule规则串
	  出口参数：
	  返    回：return false:源串不匹配规则，true:源串匹配规则
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
    public static boolean judgeMatch(String strSource, String strRule) {
    	int i = 0;
    	//源串长度判断
    	if ( (null == strSource) || (strSource.length() == 0))
    		return false;
    	//规则串长度判断
    	if ( (null == strRule) || (strRule.length() == 0))
    		return false;
    	//长度不可超长
    	if (strSource.length() > strRule.length())
    		return false;
    	//每一位的判断
    	for (i = 0; i < strRule.length(); i++) {
    		//源串比规则串短
    		if (strSource.length() < i + 1) {
    			break;
    		}
    		if ( (strRule.charAt(i) != '*')
    				&& (strSource.charAt(i) != strRule.charAt(i))) {
    			return false;
    		}
    	}
    	//对于源串比规则串短的情况，若规则串后不是均为'*'，则匹配不上
    	for (; i < strRule.length(); i++) {
    		if (strRule.charAt(i) != '*')
    			return false;
    	}
    	return true;
  }
    
    /********************************************************
	  功    能：判断字符串中最后一位是否含有单个的半个中文码，则去掉那半个中文码
	  入口参数：param strSource要被处理的字符串；
	  出口参数：
	  返    回：去掉半个中文码后的串;
	  整 理 人：
	  编写日期：20141220
	  修改备注：
	  ********************************************************/
  public static String getFullChnStr(String strSource) {
  	//源串长度判断
  	if ( (null == strSource) || (strSource.length() == 0))
  		return "";
  	//如果长度为1则只需要判断第一位是否是中文就可以了
  	if (strSource.length()==1)
  	{
  		if (strSource.charAt(0) > '\177')
  		{
  			return "";
  		} 
  		return strSource;
  	}
  	if (strSource.charAt(strSource.length()-2)<='\177' && strSource.charAt(strSource.length()-1) > '\177') {
		return strSource.substring(0,strSource.length()-1);
	}
  	
  	boolean prechn=false;
  	String returnstr="";
  	for (int i=0;i<strSource.length();i++)
  	{
  		//如果第i个字符不是汉字
  		if (strSource.charAt(i)<='\177')
  		{
  			//如果前面有半个汉字，则去掉前面那半个汉字
  			if (prechn)
  			{
  				returnstr=returnstr.substring(0,returnstr.length()-1);
  				
  			} 
  			returnstr=returnstr+strSource.charAt(i);
  			prechn=false;
  		} else {
            //如果前面有半个汉字，则刚好组合成一个
  			returnstr=returnstr+strSource.charAt(i);
            if (prechn)
            {
            	prechn=false;
            } else {
            	prechn=true;
            }
  		}
  	}
  	if (prechn)
  	{
  		returnstr=returnstr.substring(0,returnstr.length()-1);
  	}
  	return returnstr;
  }
  
  /********************************************************
	  功    能：判断输入查询条件包含'时是否符合规则，例：PEOPLE'S转换为PEOPLE''S
	  入口参数：String qryStr要被处理的字符串
	  出口参数：
	  返    回：return String 转换后的字符串
	  整 理 人：
	  编写日期：20060823
	  修改备注：
	  ********************************************************/
    public static String filerQuery(String qryStr) {
		int comma = 0;		
		int len = 0;		
		String Str = "";
		
		comma = qryStr.indexOf("'");
		len = qryStr.length();	
		
		if (qryStr == ""){
		    Str = "";
		}else{
			if (comma >0){
				Str = qryStr.substring(0,comma) + "''" + qryStr.substring(comma+1,len);
		    }else if(comma == 0){
		    	Str = "''";
		    }else if(comma < 0){
		    	Str = qryStr;
		    }		    
		}
		return Str;
	}
    /********************************************************
	  功    能：在的字符串在小数点前每隔三位用逗号隔开 如：23432525.00 转完后为23,432,525.00
	  入口参数：param str 要被处理的字符串；
	  出口参数：
	  返    回：return String 转换后的字符串；
	  整 理 人：
	  编写日期：20060823
	  修改备注：考虑负数的情况  modify by yczheng on 20070327
	  ********************************************************/
	public static String appendStr(String str) {
		
		int strlength=0;
		int adddot=0;
		int tmpstrlength=0;
		int callength=0;
		int plusdot=0;
		String firststr="";
		String endstr="";
		String returnStr=""; 
		String tmpfirststr="";
		String tmpendstr="";
		boolean isNegative = false;
		
		if(str.startsWith("-")){
			isNegative = true;
		}
		tmpstrlength=str.indexOf(".");//通过"."分隔
		if(isNegative){
			firststr = str.substring(1,tmpstrlength);//获取"-"与"."之间的字符
		}else{
			firststr=str.substring(0,tmpstrlength);//获取"."之前的字符
		}
//		firststr=str.substring(0,tmpstrlength);//获取"."之前的字符
		endstr=str.substring(tmpstrlength);//获取"."之后的字符(包括".")
		strlength=firststr.length();
		adddot=strlength/3;//判断需要插入","个数;
		plusdot=strlength%3;
		if(plusdot==0)
		{
			adddot=adddot-1;
		}
		for(int i=0;i<adddot;i++)
		{
	
			callength=firststr.length();
			tmpfirststr=firststr.substring(0,callength-(4*i+3));//得到需要插","的前面字符
			tmpendstr=firststr.substring(callength-(4*i+3));//得到需要插","后面的字符
			firststr=tmpfirststr+","+tmpendstr;	//合并
	
			
		}
		if(isNegative){
			returnStr = "-" + firststr + endstr;
		}else{
			returnStr=firststr+endstr;
		}
		return returnStr;
	}

	//比较两个以\r\n分隔的字符串大小是否一致，多出的回车符不算,每行多出右边空格不算
	public static boolean CompareString(String str1,String str2)
	{
		if (str1.equals(str2))
		{
			return true;
		}
		if (str1.endsWith("\r\n") && str1.length()>2)
		{
			str1=str1.substring(0,str1.length()-2);
		} 
		if (str2.endsWith("\r\n") && str2.length()>2)
		{
			str2=str2.substring(0,str2.length()-2);
		} 
		if (str1.equals(str2))
		{
			return true;
		}
		return false;
	}
	
	 //将字符串中的/r、/n去掉，当超过最大长度的时候,就加上分隔符;
	public static String SepFormatStr(String SourceStr,int maxlength,String separator)
	{
		if(SourceStr==null)return null;
		SourceStr = SourceStr.replaceAll("\r","");
		SourceStr = SourceStr.replaceAll("\n","");
		SourceStr = SourceStr.replaceAll(separator,"");
		//是否汉字标志
		boolean cnflag = false;
		//是否该结尾标志
		boolean end = false;
		//要返回的转换后的结果串
		StringBuffer resultsb = new StringBuffer();
		//有最大长度限制的临时串
		StringBuffer tempsb = new StringBuffer();
		//超最大长度限制的中间汉字
		String tempstr = "";
		for(int i=0;i<SourceStr.length();i++)
		{
			char Cindex = SourceStr.charAt(i);
			//判断是否为中文字符
			if (Cindex > '\177')
			{
				//判断先前字符是否中文字符
				if(cnflag)
				{				
					//判断加上汉字后是否会超过最大长度
					if(tempsb.length()>=maxlength-1)
					{
						//做结尾处理
						//判断是否需加分割符
						if(resultsb.length()>0)
						{
							resultsb.append(separator);				
						}
						resultsb.append(tempsb);
						tempsb.delete(0,tempsb.length());
					}
					//赋值超最大长度限制的中间汉字
					tempstr =SourceStr.substring(i-1,i+1);
					//赋值超最大长度限制的中间汉字给新串
					tempsb.append(tempstr);					
					cnflag = false;
				}else{
					cnflag =true;
				}
			}else
			{
				if(cnflag)
				{
					//如果先前是中文字符则放弃先前的中文字符
					cnflag = false;
				}	
				//追加每个非中文字符
				tempsb.append(Cindex);
			}
			//如果字符遍历结束，则该结尾
			if(i==SourceStr.length()-1)end=true;
			//做结尾处理
			if(tempsb.length()>0 && (tempsb.length()>=maxlength || end))
			{
				//判断是否需加分割符
				if(resultsb.length()>0)
				{
					resultsb.append(separator);				
				}
				resultsb.append(tempsb);
				tempsb.delete(0,tempsb.length());
				end = false;
			}
		}			
		return resultsb.toString();
	}	
	
	

	
	//调换姓名中的姓和名
	public static String exchangeName(String strTmp)
	{
		String ori = strTmp.trim();
		if(ori != null)
		{
			if(ori.length()== 4 || ori.length() == 6)
			{
				if(ori.length() == 4)
				{
					ori = ori.substring(2,4) + ori.substring(0,2) ;
				}
				else 
				{
					ori = ori.substring(2,6) + ori.substring(0,2) ;
				}
				
			}
			else
			{
				return ori;
			}
		}
		return ori;
	}
	
	//提取一个字符串中的连续15个以上的数字字符
	public static String isExistAcc(String strIn)
	{
		strIn = strIn.replaceAll("\r\n","\n");
		strIn = strIn.replaceAll("\n","");
		
		String strAccRet = "";
		int iCount = 0;
		if(strIn != null && strIn.length() > 0)
		{
			StringBuffer buff = new StringBuffer(strIn);
			int len = buff.length();
			for (int i = 0; i < len;i++) 
			{
				char ch = buff.charAt(i);
				if((ch >= '0' && ch <= '9'))
				{
					iCount++;
					strAccRet += String.valueOf(ch);
				}
				else
				{
					if(iCount > 15)
						break;
					iCount = 0;
					strAccRet = "";
				}
			}
		}
		
		if(iCount > 15)
			return strAccRet;
		else
			return "";
	}
	
	//判断传入的字符串(除掉空格)是否全部为数字
	public static boolean judgeAllNumberic(String strIn)
	{
		strIn = strIn.replaceAll("\r\n","\n");
		strIn = strIn.replaceAll("\n","");
		strIn = strIn.replaceAll(" ","");
		
		if(strIn != null && strIn.length() > 0)
		{
			StringBuffer buff = new StringBuffer(strIn);
			int len = buff.length();
			for (int i = 0; i < len;i++) 
			{
				char ch = buff.charAt(i);
				if((ch >= '0' && ch <= '9'))
				{
					continue;
				}
				else
				{
					return false;
				}
			}
		}
		else
			return false;
		return true;
	}
	
	//判断传入的字符串是否全为中文
	public static boolean judgeAllChn(String strIn)
	{
		strIn = strIn.replaceAll("\r\n","\n");
		strIn = strIn.replaceAll("\n","");
		strIn = strIn.replaceAll(" ","");
		
		if(strIn != null && strIn.length() > 0)
		{
			StringBuffer buff = new StringBuffer(strIn);
			int len = buff.length();
			for (int i = 0; i < len;i++) 
			{
				char ch = buff.charAt(i);
				 if( ch <= 0 || ch >= 126)
				 {
					 continue;
				 }
				 else
					 return false;
			}
			return true;
		}
		else
			return false;
	}	
	
	//判断传入的字符串是否为数字或者中文(全数字,全中文,数字+中文)
	public static boolean judgeChnCode(String strIn)
	{
		strIn = strIn.replaceAll("\r\n","\n");
		strIn = strIn.replaceAll("\n","");
		strIn = strIn.replaceAll(" ","");
		
		if(strIn != null && strIn.length() > 0)
		{
			StringBuffer buff = new StringBuffer(strIn);
			int len = buff.length();
			for (int i = 0; i < len;i++) 
			{
				char ch = buff.charAt(i);
				if((ch >= '0' && ch <= '9') || (ch <= 0 || ch >= 126))
				{
					continue;
				}
				else
				{
					return false;
				}
			}
		}
		else
			return false;
		return true;
	}
	
	//判断传入的字符串是否存在中文
	public static boolean judgeExistChn(String strIn)
	{
		if(judgeChnCode(strIn))
		{
			return true;
		}
		
		strIn = strIn.replaceAll("\r\n","\n");
		strIn = strIn.replaceAll("\n","");
		strIn = strIn.replaceAll(" ","");
		
		if(strIn != null && strIn.length() > 0)
		{
			StringBuffer buff = new StringBuffer(strIn);
			int len = buff.length();
			for (int i = 0; i < len;i++) 
			{
				char ch = buff.charAt(i);
				 if( ch <= 0 || ch >= 126)
				 {
					 return true;
				 }
				 else
					 continue;
			}
			return false;
		}
		else
			return false;
	}
	
	//判断传入的字符串是否存在数字
	public static boolean judgeExistNumber(String strIn)
	{
		if(judgeChnCode(strIn))
		{
			return true;
		}
		
		strIn = strIn.replaceAll("\r\n","\n");
		strIn = strIn.replaceAll("\n","");
		strIn = strIn.replaceAll(" ","");
		
		if(strIn != null && strIn.length() > 0)
		{
			StringBuffer buff = new StringBuffer(strIn);
			int len = buff.length();
			for (int i = 0; i < len;i++) 
			{
				char ch = buff.charAt(i);
				 if( ch >= '0' && ch <= '9')
				 {
					 return true;
				 }
				 else
					 continue;
			}
			return false;
		}
		else
			return false;
	}


	//字符串是否复合匹配规则--使用正则表达式
	public static boolean chkString(String existStr,String value)
	{
		  Pattern pattern  = Pattern.compile(existStr);
		  Matcher matcher  = pattern.matcher(value);
		  boolean didMatch = matcher.matches();
		  return didMatch;
	}
	
	
	/**
	 * 字符串matchStr中是否存在regexp子字符串
	 * @param regexp
	 * @param mathStr
	 * @return
	 * zlh
	 */
	public static boolean isExist_Str(String regexp,String mathStr){		
		boolean result=false;
		Pattern pattern=Pattern.compile(regexp);
		Matcher matcher=pattern.matcher(mathStr);
		result = matcher.find();		
		return result;
	}
	
/**
 * 提取一个字符串中的连续数字字符
 * @param numStr 
 * @param count
 * @return
 */
	public static String getSeqNumber(String numStr)
	{	
		numStr = numStr.replaceAll("\r\n","\n");
		numStr = numStr.replaceAll("\n","");	
		
		String seqNumRet = "";
		int iCount = 0;
		if(numStr != null && numStr.length() > 0)
		{
			StringBuffer buff = new StringBuffer(numStr);
			int len = buff.length();
			for (int i = 0; i < len;i++) 
			{
				char ch = buff.charAt(i);
				if((ch >= '0' && ch <= '9'))
				{
					iCount++;
					seqNumRet += String.valueOf(ch);
				}
				else
				{
					
					if(iCount > 10 && !(ch >= '0' && ch <= '9'))
						break;
					iCount = 0;
					seqNumRet = "";
				}
			}
		}
		
		
		return seqNumRet;
		
	}
	
	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
			"参数scale必须是大于0的整数");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
     * 左填充指定字符
     * @param str	字符串
     * @param ch	填充字符
     * @param len	填充后字符的总长度
     * @return
     */
    public static String rfillCharater(String str , char ch , int len)
    {
    	StringBuffer fillStr = new StringBuffer(str);
    	int fillLen = len - fillStr.length();
    	
    	for(int i = 0 ; i < fillLen ; i++) {
    		fillStr.append(ch);
    	}
    	
    	return fillStr.toString();
    }
    
    /**
     * 右填充指定字符
     * @param str	字符串
     * @param ch	填充字符
     * @param len	填充后字符的总长度
     * @return
     */
    public static String lfillCharater(String str , char ch , int len)
    {
    	StringBuffer fillStr = new StringBuffer();
    	int fillLen = len - str.length();
    	
    	for(int i = 0 ; i < fillLen ; i++) {
    		fillStr.append(ch);
    	}
    	fillStr.append(str);
    	
    	return fillStr.toString();
    }
    
	
	/**
	 * 正则表达式
	 * 
	 * @param regexPattern  
	 *            规则  浮点:"^\\-?\\d+\\.?\\d*$"
	 *            整数："[0-9]+";
	 * @param value
	 *            校验值
	 * @return
	 * 
	 * @author zhengjl
	 */
	public static boolean propRule(String regexPattern, String value) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(value);
		boolean didMatch = matcher.matches();
		return didMatch;
	}
	
	/**
	 * str是否包含strarray中的元素
	 * @param str
	 * @param strarray
	 * @author zlh
	 * @return
	 */
	public static boolean isExistStr(String str,String[] strarray){
		if (strarray==null || strarray.length<=0) return false;
    	for (int i=0;i<strarray.length;i++)	
    	{
    		if (strarray[i]==null)
    		{
    			if (str==null) return true;
    			else continue;	
    		} 
    		if (str.indexOf(strarray[i].trim())!=-1)
    		{
    			return true;	
    		}	
    	}
    	return false;
	}
	/**
	 * 四角码四组换行
	 * @param str
	 * @return
	 */
	public static String codeToLines(String str){
		String strTemp ="";
		if(str==null){
			return strTemp;
		}
		while(str.length()>19){
 			strTemp =strTemp+"\n"+str.substring(0,19);
 			if(' '==str.charAt(19)){
 				str = str.substring(20);
 			}else{
 				str = str.substring(19);
 			}
		}
		strTemp = strTemp+"\n"+str;
		strTemp = strTemp.substring(1);
		return strTemp;
	}
	/**
	 * 字符串四位换行
	 * @param str
	 * @return
	 */
	public static String nameToLines(String str){
		String strTemp ="";
		if(str==null){
			return strTemp;
		}
		while(str.length()>8){
 			strTemp =strTemp+"<br>"+str.substring(0,8);
			str = str.substring(8);
		}
		strTemp = strTemp+"<br>"+str;
		strTemp = strTemp.substring(4);
		return strTemp;
	}
	
	public static String lowerToUppser(String str){
		str = str.trim();
		String strTemp = "";
		char a;
		if(str == null || str.trim().length()==0){
			return strTemp;
		}
		for(int i=0; i<str.length();i++){
			a = str.charAt(i);
			if(a >=97 && a<=122){
				a = (char)(a-32);
			}
			strTemp = strTemp + a;
		}
		return strTemp;
	}	
	/**
	 * 获得字符串中的域名
	 * @param str
	 * @return
	 */
	public static String getDomain(String str){
		String strTemp ="";
		if(str==null){
			return strTemp;
		}
		int i = str.indexOf("http://");
		if(i >= 0)
		{
			strTemp = str.substring(i + 7);
		}
		i = str.indexOf("www.");
		if(i >= 0)
		{
			strTemp = strTemp.substring(i + 4);
		}		
		i = str.indexOf('/');
		if(i >=0)
		{
			strTemp = strTemp.substring(0,i);
		}		
		return strTemp;
	}
	
	  /**
     * 判断字符串是否存在
     * @param str
     * @return
     */
    public static boolean isExist(String str) {
        if (str != null && str.length() > 0) { 
            return true;
        } 
        return false;
    }
    
    /**
     * 判断是否是数字
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        //验证数字：^[0-9]*$
        return str.matches("^\\d+(\\,\\d+)*$");
    }
    
    /**
     * 验证日期 yyyy-MM-dd
     * @param dateStr
     * @return
     */
    public static boolean isValidDate(String dateStr) {
        boolean isValid = false;
        if (dateStr == null || dateStr.length() <= 0) {
            return false;
        }
        String pattern = "yyyy-MM-dd";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            String date = sdf.format(sdf.parse(dateStr));
            if (date.equalsIgnoreCase(dateStr)) {
                isValid = true;
            }
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }
    
    /**
     * 验证日期格式是否是 yyyy-MM-dd HH:mm:ss
     * @param dateStr
     * @return
     */
    public static boolean isValidDateTime(String dateStr) {
        boolean isValid = false;
        if (dateStr == null || dateStr.length() <= 0) {
            return false;
        }
        String pattern = "yyyy-MM-dd HH:mm:ss";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            String date = sdf.format(sdf.parse(dateStr));
            if (date.equalsIgnoreCase(dateStr)) {
                isValid = true;
            }
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }
    
    public static String joinStr(String[] array,String joinChar){
    	if(array==null)
    	return "";
    	if(joinChar==null)joinChar=",";
    	String str="";
    	for(int i=0;i<array.length;i++){
    		str=str+array[i];
    		if(i<array.length-1)str=str+joinChar;
    	}
    	return str;
    }
    
  //不让字符串中的特殊字符转义
  	public static String transferSpecialLetters(String str){
  		if(isNotEmpty(str)){
  			str = str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("'", "&quot;");
  		}
  		return str;
  	}
  	
  	//题干、材料题的<p>标签过滤掉
  	public static String transferSpecialSubStr(String str){
  		StringBuffer buffer = new StringBuffer();
  		if(isNotEmpty(str)){
  			if(str.length() > 3){
  				buffer.append(str.substring(0, 3));
  			}
  			String subStr = str.substring(3, str.length() - 5).replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("'", "&quot;");
  			
  			buffer.append(subStr);
  			buffer.append(str.substring(str.length() - 5));
  		}
  		return buffer.toString();
  	}
  	
  	public static boolean isNotEmpty(String s){
		return !isEmpty(s);
	}
  	
  //判读是否为空
  	public static boolean isEmpty(String str){
  		if(str == null){
  			return true;
  		}else if("".equals(str)){
  			return true;
  		}
  		return false;
  	}
  	
  	public static List<Integer> getIndexOfChar(String str, String start, String end){
  		int starIndex = 0;
  		List<Integer> list = new ArrayList<Integer>();
		while (true) {
			int a = 0;
			if (list.size() % 2 == 0) {
				a = str.indexOf(start, starIndex);
			} else {
				a = str.indexOf(end, starIndex);
			}

			if (a == -1) {
				break;
			}
			list.add(a);
			starIndex = a + 1;
		}
		return list;
  	}
}
