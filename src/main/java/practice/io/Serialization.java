package practice.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void seriliazeObjectToFile(Object obj, String filePath) {

		System.out.println("Serializing Object to File.");
		try {
			FileOutputStream fileOut = new FileOutputStream(filePath + obj.getClass().getSimpleName() + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in " + filePath + obj.getClass().getSimpleName() + ".ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] seriliazeObjectToBytes(Object obj) {

		System.out.println("Serializing Object to Bytes.");
		ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();

		try {
			ObjectOutputStream out = new ObjectOutputStream(bytesOut);
			out.writeObject(obj);
			out.close();
			bytesOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytesOut.toByteArray();
	}

	public static Object desiliazeObjectFromFile(FileInputStream fileIn) {

		System.out.println("Deserializing Object from File.");
		Object desiriliazedObj = new Object();
		try {
			ObjectInputStream in = new ObjectInputStream(fileIn);
			desiriliazedObj = in.readObject();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return desiriliazedObj;
	}

	public static Object desirializeObjectFromBytes(byte[] objectBytes) {

		System.out.println("Deserializing Object from Bytes.");
		Object desiriliazedObj = new Object();

		try {
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(objectBytes));
			desiriliazedObj = in.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return desiriliazedObj;
	}

}
