package com.jeremy.rxjava.practice.util.data;

import java.util.ArrayList;
import java.util.List;

public class Group {

	public static List<String> getFirstGroup(){
		List<String> grouop = new ArrayList<>();
		grouop.add("신정호");
		grouop.add("전우균");
		grouop.add("강동호");
		grouop.add("박승규");
        
        return grouop;
	}
	
	
	public static List<String> getSecondGroup(){
		List<String> grouop = new ArrayList<>();
		grouop.add("김동학");
		grouop.add("조준호");
		grouop.add("정재우");
		grouop.add("박민");
        
        return grouop;
	}
	
	public static List<String> getAllMembers(){
		List<String> grouop = new ArrayList<>();
		
		grouop.add("신정호");
		grouop.add("전우균");
		grouop.add("강동호");
		grouop.add("박승규");
		grouop.add("김동학");
		grouop.add("조준호");
		grouop.add("정재우");
		grouop.add("박민");
		
        return grouop;
	}
	
}
