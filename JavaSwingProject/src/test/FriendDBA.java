package test;

import java.util.ArrayList;

import test.Friend;

public interface FriendDBA {
	//추�?
	//보기
	//�??��
	public void friendInsert(Friend f);
	public ArrayList<Friend>friendView();
	public ArrayList<Friend>friendSearch(String str, String word);
}
