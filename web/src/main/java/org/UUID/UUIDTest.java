package org.UUID;

import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String str=uuid.toString();
		
		System.out.println(str.substring(0,8)+"@"+str.substring(9,12));

	}

}
