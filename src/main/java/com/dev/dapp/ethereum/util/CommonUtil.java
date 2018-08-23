package com.dev.dapp.ethereum.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * The Class CommonUtil.
 */
public class CommonUtil {

	private CommonUtil() {
	}

	/**
	 * Convert MultipartFile file to java.io.File.
	 *
	 * @param file
	 *            the file
	 * @return the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		try (FileOutputStream fos = new FileOutputStream(convFile)) {
			fos.write(file.getBytes());
			return convFile;
		}
	}
}
