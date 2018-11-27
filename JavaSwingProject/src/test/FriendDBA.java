package test;

import java.util.ArrayList;

import test.Friend;

public interface FriendDBA {
	//ì¶”ê?
	//ë³´ê¸°
	//ê²??ƒ‰
	public void friendInsert(Friend f);
	public ArrayList<Friend>friendView();
	public ArrayList<Friend>friendSearch(String str, String word);
}
