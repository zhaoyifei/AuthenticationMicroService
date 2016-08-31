package com.zyifly.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	// 定义script的正则表达式  
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; 
    
    // 定义style的正则表达式  
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; 
    
    // 定义HTML标签的正则表达式  
    private static final String regEx_html = "<[^>]+>"; 
    
    //定义空格回车换行符  
    private static final String regEx_space = "\\s*|\t|\r|\n";
    
	/** 
     * @param htmlStr 
     * @return 
     *  删除Html标签 
     */  
    public static String delHTMLTag(String htmlStr) {  
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
        Matcher m_script = p_script.matcher(htmlStr);  
        htmlStr = m_script.replaceAll(""); // 过滤script标签  
  
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
        Matcher m_style = p_style.matcher(htmlStr);  
        htmlStr = m_style.replaceAll(""); // 过滤style标签  
  
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
        Matcher m_html = p_html.matcher(htmlStr);  
        htmlStr = m_html.replaceAll(""); // 过滤html标签  
  
        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);  
        Matcher m_space = p_space.matcher(htmlStr);  
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签  
        htmlStr =  htmlStr.trim(); // 返回文本字符串  
        htmlStr = htmlStr.replaceAll("&nbsp;", "");  
        return htmlStr;
    }
    /**
     * 检查字符串是否为 <code>null</code> 或空字符串 <code>""</code>或只包含空格。
     * <p/>
     * <pre>
     *
     *    StringUtil.isEmpty(null)      = true
     *    StringUtil.isEmpty(&quot;&quot;)        = true
     *    StringUtil.isEmpty(&quot; &quot;)       = true
     *    StringUtil.isEmpty(&quot;bob&quot;)     = false
     *    StringUtil.isEmpty(&quot;  bob  &quot;) = false
     *
     * </pre>
     *
     * @param str 要检查的字符串
     * @return 如果为空, 则返回 <code>true</code>
     */
    public static boolean isEmpty(String str) {
        return isEmpty(str, true);
    }
    public static boolean isEmpty(String str, boolean trim) {
        if ((str == null) || (str.isEmpty()))
            return true;
        if (trim)
            return str.trim().isEmpty();
        return str.isEmpty();
    }

    /**
     * 比较两个字符串（大小写不敏感）。
     * <p/>
     * <pre>
     *
     *    StringUtil.equalsIgnoreCase(null, null)   = true
     *    StringUtil.equalsIgnoreCase(null, &quot;abc&quot;)  = false
     *    StringUtil.equalsIgnoreCase(&quot;abc&quot;, null)  = false
     *    StringUtil.equalsIgnoreCase(&quot;abc&quot;, &quot;abc&quot;) = true
     *    StringUtil.equalsIgnoreCase(&quot;abc&quot;, &quot;ABC&quot;) = true
     *
     * </pre>
     *
     * @param str1 要比较的字符串1
     * @param str2 要比较的字符串2
     * @return 如果两个字符串相同，或者都是 <code>null</code> ，则返回 <code>true</code>
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return equalsIgnoreCase(str1, str2, true);
    }

    public static boolean equalsIgnoreCase(String str1, String str2, boolean nullValid) {
        if (str1 == null){
            if (nullValid) return str2 == null;
            else return false;
        }
        return str1.equalsIgnoreCase(str2);
    }

}
