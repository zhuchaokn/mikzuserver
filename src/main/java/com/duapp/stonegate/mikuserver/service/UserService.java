package com.duapp.stonegate.mikuserver.service;

import com.duapp.stonegate.mikuserver.serilize.UserDTO;

/**
 * Created by chao.zhu 14-4-22 下午5:44
 */
public interface UserService {
    public void registerUser(UserDTO userDTO);

    /**
     * 验证用户，并将用户id写入传入dto中
     * 
     * @param userDTO
     * @return
     */
    public boolean validate(UserDTO userDTO) throws Exception;

    public UserDTO getUserByName(String userName);
}
