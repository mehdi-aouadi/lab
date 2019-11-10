package practice.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileTail {

	public static List<String> readTail(BufferedReader reader, int linesNumber) {

		String[] lastLines = new String[linesNumber];

		try {
			String line;

			while ((line = reader.readLine()) != null) {
				insertBackwardArray(lastLines, line);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Arrays.asList(lastLines);

	}

	public static void insertBackwardArray(String[] lines, String line) {

		for (int i = 0; i < lines.length - 1; i++) {
			lines[i] = lines[i + 1];
		}

		lines[lines.length - 1] = line;
	}
}
