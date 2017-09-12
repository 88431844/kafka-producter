package com.navinfo.opentsp.gateway.tcp.proto.electrocar.util;

import java.util.Arrays;

public final class ArraysUtils {
	/**
	 * 数组拼接
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public final static byte[] arraycopy(final byte[] begin, final byte[] end) {
		if (begin == null)
			return end;
		if (end == null)
			return begin;
		int length = begin.length + end.length;
		byte[] result = new byte[length];
		System.arraycopy(begin, 0, result, 0, begin.length);
		System.arraycopy(end, 0, result, begin.length, end.length);
		return result;
	}

	/**
	 * 字节数据追加
	 * 
	 * @param source
	 * @param sourceIndex
	 * @param end
	 * @return
	 */
	public final static byte[] arrayappend(final byte[] source,
			int sourceIndex, final byte[] end) {
		if (end.length + sourceIndex > source.length)
			throw new IndexOutOfBoundsException("length = " + source.length
					+ " , total length = " + (sourceIndex + end.length));
		System.arraycopy(end, 0, source, sourceIndex, end.length);
		return source;
	}

	/**
	 * byte数组截取,注意：length必须是小于bytes的长度,当length<0或者length>bytes.length-startIndex
	 * ,则从startIndex开始一直截取到最后
	 * 
	 * @param bytes
	 *            byte 需要截取的byte数组
	 * @param startIndex
	 *            int 开始截取的下标
	 * @param length
	 *            int 截取的总长度
	 * 
	 * @return byte[] 截取后新byte数组
	 */
	public static final byte[] subarrays(final byte[] bytes,
			final int startIndex, final int length) {
		if(startIndex > bytes.length){
			throw new IndexOutOfBoundsException("statIndex = "+startIndex+" , bytes length = "+bytes.length+"");
		} else if (startIndex == 0 && bytes.length == length) {
			return bytes;
		} else if (length == -1 || bytes.length - startIndex < length) {
			byte[] rbytes = new byte[bytes.length - startIndex];
			System.arraycopy(bytes, startIndex, rbytes, 0, rbytes.length);
			return rbytes;
		} else {
			byte[] rbytes = new byte[length];
			System.arraycopy(bytes, startIndex, rbytes, 0, length);
			return rbytes;
		}
	}

	public static final byte[] subarrays(final byte[] bytes,
			final int startIndex) {
		if (startIndex > bytes.length) {
			throw new IndexOutOfBoundsException("statIndex = "+startIndex+" , bytes length = "+bytes.length+"");
		} else {
			byte[] rbytes = new byte[bytes.length - startIndex];
			System.arraycopy(bytes, startIndex, rbytes, 0, rbytes.length);
			return rbytes;
		}
	}

	public static final boolean equals(byte[] frist, byte[] second) {
		return Arrays.equals(frist, second);
	}

	public static final int indexOf(byte b, byte[] bytes) {
		for (int i = 0, length = bytes.length; i < length; i++) {
			if (b == bytes[i])
				return i;
		}
		return -1;
	}

	/**
	 * 数组填充长度
	 *
	 * @param src
	 * @param length
	 * @param padByte
	 * @return
	 */
	public final static byte[] fillArrayTail(byte[] src, int length, byte padByte) {
		if (src.length >= length) {
			return src;
		}

		byte[] fillBytes = new byte[length - src.length];
		for (int i = 0; i < fillBytes.length; i++) {
			fillBytes[0] = padByte;
		}

		byte[] bytes = new byte[length];
		System.arraycopy(src, 0, bytes, 0, src.length);
		System.arraycopy(fillBytes, 0, bytes, src.length, fillBytes.length);
		return bytes;
	}

	/**
	 * 数组填充长度
	 *
	 * @param src
	 * @param length
	 * @param padByte
	 * @return
	 */
	public final static byte[] fillArrayHead(byte[] src, int length, byte padByte) {
		if (src.length >= length) {
			return src;
		}

		byte[] fillBytes = new byte[length - src.length];
		for (int i = 0; i < fillBytes.length; i++) {
			fillBytes[0] = padByte;
		}

		byte[] bytes = new byte[length];
		System.arraycopy(fillBytes, 0, bytes, 0, fillBytes.length);
		System.arraycopy(src, 0, bytes, fillBytes.length, src.length);
		return bytes;
	}

}
