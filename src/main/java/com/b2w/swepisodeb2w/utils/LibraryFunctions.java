package com.b2w.swepisodeb2w.utils;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryFunctions {
	
	public static List<Message> clearMessagesDuplicate(List<Message> listMessages) {
		return listMessages.stream().distinct().collect(Collectors.toList());	
	}
	
	public static boolean hasFatalError(List<Message> messages) {
		boolean fatalError = false;
		for (Message messageService : messages) {
			if (messageService.getType() == TypeMessage.error) {
				fatalError = true;
				break;
			} else
				fatalError = false;
		}
		return fatalError;
	}
	
}
