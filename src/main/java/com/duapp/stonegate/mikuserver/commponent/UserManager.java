package com.duapp.stonegate.mikuserver.commponent;


import com.duapp.stonegate.mikuserver.serilize.UserDTO;

/**
 * Created by chao.zhu
 * 14-4-22
 * 下午5:49
 */
public interface UserManager {
    public UserDTO register(UserDTO userDTO) throws Exception;
    public UserDTO logon(UserDTO userDTO) throws Exception;
}
