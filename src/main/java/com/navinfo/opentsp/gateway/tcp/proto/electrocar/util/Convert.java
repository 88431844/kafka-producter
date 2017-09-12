package com.navinfo.opentsp.gateway.tcp.proto.electrocar.util;

/**
 * 进制转换
 * 
 * @author lgw
 * 
 */
public final class Convert {
	private final static byte[] hex = "0123456789ABCDEF".getBytes();

	/*1个字节，FF*/
	public static int BytesOf1=255;
	/*2个字节，FFFF*/
	public static int BytesOf2=65535;
	/*4个字节，FFFFFFFF*/
	public static Long BytesOf4=4294967295L;

	/*1个字节，FF*/
	public static int BytesOf1FE=254;
	/*2个字节，FFFE*/
	public static int BytesOf2FE=65534;
	/*4个字节，FFFFFFFE*/
	public static Long BytesOf4FE=4294967294L;


	public static void main(String[] args) {
//		byte[] aa = hexStringToBytes("232305020101010101010101010101010101010101010006100C161006110C");
//		System.out.println(bytesToHexString(new byte[] {checkPackage(aa, 2, aa.length - 2)}));
//		byte bb = (byte)0x0C;
//		System.out.println(checkPackage(aa,2,aa.length-2) == bb);
//		byte[] bytes = new byte[]{16,12,15,18,20,34};
//		System.out.println(gbDateToString(bytes));

		System.out.println(isExceptionOrInvalid(1, 255));
		System.out.println(isExceptionOrInvalid(1, 254));
		System.out.println(isExceptionOrInvalid(1, 253));
	}
	/**
	 * 删除字符串前面的0
	 * @param str 需要去除零的字符串
	 * @return 删除前面有0字符的字符串
     */
	public static String removeHeadZero(String str){
		while (true){
			if (str.startsWith("0")){
				str = str.substring(1);
			}else{
				return str;
			}
		}
	}

	/**
	 * 字节数组转换到十六进制字符串
	 * 
	 * @param bytes
	 *            {@link Byte}字节数组
	 * @return {@link String} 十六进制字符串
	 */
	public static String bytesToHexString(byte[] bytes) {
		byte[] buff = new byte[2 * bytes.length];
		for (int i = 0, length = bytes.length; i < length; i++) {
			buff[2 * i] = hex[(bytes[i] >> 4) & 0x0f];
			buff[2 * i + 1] = hex[bytes[i] & 0x0f];
		}
		return new String(buff);
	}

	/**
	 * 十六进制字符串转换到字节数组
	 * 
	 * @param hexstr
	 *            {@link String} 十六进制字符串
	 * @return {@link Byte}[]字节数组
	 */
	public static byte[] hexStringToBytes(String hexstr) {
		byte[] b = new byte[hexstr.length() / 2];
		int j = 0;
		for (int i = 0, length = b.length; i < length; i++) {
			char c0 = hexstr.charAt(j++);
			char c1 = hexstr.charAt(j++);
			b[i] = (byte) ((parse(c0) << 4) | parse(c1));
		}
		return b;
	}

	private static int parse(char c) {
		if (c >= 'a')
			return (c - 'a' + 10) & 0x0f;
		if (c >= 'A')
			return (c - 'A' + 10) & 0x0f;
		return (c - '0') & 0x0f;
	}

	/**
	 * 十进制转十六进制
	 * 
	 * @param number
	 *            int 十进制
	 * @param x
	 *            int 位数
	 * @return
	 */
	public static String decimalToHexadecimal(long number, int x) {
		String hex = Long.toHexString(number).toUpperCase();
		return fillZeroHead(hex, x);
	}

	/**
	 * 填充0
	 * 
	 * @param text
	 *            {@link Object} 需要补0的对象
	 * @param length
	 *            {@link Integer} 补0后的长度
	 * @return {@link String}
	 */
	public static String fillZeroHead(Object text, int length) {
		StringBuilder builder = new StringBuilder(length);
		if (text == null) {
			for (int i = 0; i < length; i++)
				builder.append("0");
		} else {
			for (int i = String.valueOf(text).length(); i < length; i++) {
				builder.append("0");
			}
			builder.append(text);
		}
		return builder.toString();
	}

	/**
	 * 整形转字节
	 * 
	 * @param number
	 * @param size
	 * 
	 * @return
	 */
	public static byte[] longTobytes(long number, int size) {
		byte[] b = new byte[size];
		for (int i = 0; i < size; i++) {
			b[i] = (byte) (number >> 8 * (size - i - 1) & 0xFF);
		}
		return b;
	}

	public static byte[] longTobytesLittleEndian(long number, int size) {
		byte[] b = new byte[size];
		for (int i = size-1; i >= 0; i--) {
			b[i] = (byte) (number >> 8 * i & 0xFF);
		}
		return b;
	}

	/**
	 * 字节转整形<br>
	 * 最大支持4字节
	 * 
	 * @param bytes
	 * @param size
	 * @return
	 */
	public static long byte2Long(byte[] bytes, int size) {
		long intValue = 0l;
		for (int i = 0; i < bytes.length; i++) {
			intValue |= (long)(bytes[i] & 0xFF) << (8 * (size - i - 1));
		}
		return intValue;
	}
	/**
	 * 按照java字节序处理
	 * @param bytes
	 * @param size
	 * @return
	 */
	public static int byte2Int(byte[] bytes, int size) {
		int intValue = 0;
		for (int i = 0; i < bytes.length; i++) {
			intValue += (bytes[i] & 0xFF) << (8 * (size - i - 1));
		}
		return intValue;
	}

	public static long byte2LongLittleEndian(byte[] bytes) {
		long intValue = 0l;
		for (int i = 0; i < bytes.length; i++) {
			intValue |= (long)(bytes[i] & 0xFF) << (8 * i);
		}
		return intValue;
	}

	public static int byte2IntLittleEndian(byte[] bytes) {
		int intValue = 0;
		for (int i = 0; i < bytes.length; i++) {
			intValue += (bytes[i] & 0xFF) << (8 * i);
		}
		return intValue;
	}

	public static double byte2doubleLittleEndian(byte[] bytes){
		return Double.longBitsToDouble(byte2LongLittleEndian(bytes));
	}

	/**
	 * 整形转字节
	 * 
	 * @param number
	 * @param size
	 * 
	 * @return
	 */
	public static byte[] intTobytes(int number, int size) {
		byte[] b = new byte[size];
		for (int i = 0; i < size; i++) {
			b[i] = (byte) (number >> 8 * (size - i - 1) & 0xFF);
		}
		return b;
	}

	public static byte[] intTobytesLittleEndian(int number, int size) {
		byte[] b = new byte[size];
		for (int i = size-1; i >= 0; i--) {
			b[i] = (byte) (number >> 8 * i & 0xFF);
		}
		return b;
	}
	
	/**
	 * 唯一标识转long进行数据存储
	 * 
	 * @param uniqueMark
	 *            {@link String} 终端唯一标识
	 * @return {@link Long}
	 */
	public static long uniqueMarkToLong(String uniqueMark) {
		return Long.parseLong(uniqueMark);
	}

	/**
	 * 终端标识转换成数据包唯一标识
	 * 
	 * @param terminalId
	 * @return
	 */
	public static String terminalIdToUniqueMark(long terminalId) {
		String temp = String.valueOf(terminalId);
		for (int i = temp.length(); i < 12 ; i++) {
			temp = "0" + temp;
		}
		return temp;
	}
	
	/**
	 * 节点标识转数据包唯一标识
	 * @param nodeCode
	 * @return
	 */
	public static String nodeCodeToUniqueMark(int nodeCode){
		return Convert.fillZeroHead(nodeCode, 12);
	}
	
	public static byte[] byteReverse(byte[] b){
		
		byte[] reB= new byte[b.length];
		
		for(int i=b.length-1; i>=0;i--){
			reB[b.length-i-1] = b[i];
		}
		return reB;
	}

	/**
	 * 数据检验
	 *
	 * @param data
	 *            {@link Byte}[] 源数据
	 * @param begin
	 *            {@link Integer} 开始字节
	 * @param end
	 *            {@link Integer} 结束字节
	 * @return {@link Byte}
	 */
	public static byte checkPackage(byte[] data, int begin, int end) {
		byte crc = 0x00;
		for (int i = begin; i <= end; i++) {
			crc ^= data[i];
		}
		return crc;
	}

	/**
	 * 判断是否在合理区间内
	 *
	 * @param minValue
	 * @param maxValue
	 * @param currentValue
	 * @return
	 */
	public static boolean InRegion(long minValue, long maxValue, long currentValue) {
		if (currentValue >= minValue && currentValue <= maxValue) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断当前是否是异常或无效值
	 * @param size
	 * @param value
	 * @return
	 */
	public static boolean isExceptionOrInvalid(int size, long value){
		if(size <= 0){
			return false;
		}

		byte[] b = new byte[size]; // 默认为无效
		for (int i=0; i<size; i++){
			b[i] = (byte)0xff;
		}

		if(byte2Long(b, size) == value){	// 无效
			return true;
		}

		b[size - 1] = (byte)0xfe;
		if(byte2Long(b, size) == value){	// 异常
			return true;
		}

		return false;
	}

	/**
	 * 判断是否在合理区间内
	 *
	 * @param minValue
	 * @param maxValue
	 * @param currentValue
	 * @return
	 */
	public static boolean InRegion1Bytes(long minValue, long maxValue, long currentValue) {
		if (currentValue!=BytesOf1&&currentValue!=BytesOf1FE&&currentValue >= minValue && currentValue <= maxValue) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean InRegion2Bytes(long minValue, long maxValue, long currentValue) {
		if (currentValue!=BytesOf2&&currentValue!=BytesOf2FE&&currentValue >= minValue && currentValue <= maxValue) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 国标的时间转为时间字符串yyyy-mm-dd HH-mm-ss
	 * @param bytes 国标时间格式
	 * @return 时间字符串
     */
	public static String gbDateToString(byte[] bytes){
		StringBuffer sb = new StringBuffer();
		sb.append("20").append(fillZeroHead(bytes[0], 2)).append("-");
		sb.append(fillZeroHead(bytes[1], 2)).append("-");
		sb.append(fillZeroHead(bytes[2], 2)).append(" ");
		sb.append(fillZeroHead(bytes[3], 2)).append(":");
		sb.append(fillZeroHead(bytes[4], 2)).append(":");
		sb.append(fillZeroHead(bytes[5], 2));
		return sb.toString();
	}
}
