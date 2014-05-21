package com.duapp.stonegate.mikuserver.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public  class UserMonitor {
     private static  UserMap usermap=new UserMap();
     public static boolean  putUser( UserState state){
    	 boolean res=false;
    	 if(usermap==null){
             usermap = new UserMap();
         }
    	 synchronized (usermap) {
    	   res=usermap.put(state);	
		}
    	 return res;
     }
     public static boolean dropUser(String userString)
     {
    	 boolean res=false;
    	 if(usermap==null) return false;
    	 synchronized (usermap) {
    		res=usermap.dropUser(userString);
		}
    	 return res;
     }

     public static String getIpAddress(String userName){
    	 String ipaddress=usermap.getUserIpAddress(userName);
    	 return ipaddress;
     }
     
     public static UserState getUserState( String userName){
    	 UserState state= usermap.getUserState(userName);
    	 return state;
    	 
     }
     public static String[] getAllUserState()
     {
    	 if(usermap==null) return null;
    	 return usermap.getAllUserState();
     }
}
class UserMap{
    
	 public boolean put( UserState state ) {
		 userMap.put(state.getUserName(), state);
		 return true;
		
	}
	public boolean isExist(String userName) {
		// TODO Auto-generated method stub
		UserState user=userMap.get(userName);		
		String IpAddress=user.getUserIpAddress();
		if(IpAddress == null)
		return true;
		return false;
	}
	Map<String,UserState> userMap;
	 public UserMap()
	 {
		 userMap=new HashMap<String, UserState>();
	 }
	 
	 public String getUserIpAddress(String userName) {
		// TODO Auto-generated method stub
		UserState user=userMap.get(userName);
	    if(user==null) return null;
	    return user.getUserIpAddress();
	}
	 
	 public UserState getUserState(String userName) {
		// TODO Auto-generated method stub
		UserState user=userMap.get(userName);
	    return user;
	}
	 public boolean dropUser(String userName)
	 {
		if( userMap.remove(userName)!=null) return true;
		return false;
	 }
	 String[] getAllUserState()
	 {
		 String[] res=new String[userMap.size()];
		 int i=0;
		for(Entry<String, UserState> entry:userMap.entrySet())
		{
			res[i++]=entry.getValue().getUserName()+":"+entry.getValue().getUserState()+":"+entry.getValue().getUserIpAddress();
		}
		 return res;
	 }
}

