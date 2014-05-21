package com.duapp.stonegate.mikuserver.commmon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * com.qunar.qtown.lib.common.JsonSuccessData
 * 
 * @author yushen.ma
 * @date 2014-03-26
 */
public class JsonSuccessData implements Serializable {

    private static final long serialVersionUID = -6167830445571610871L;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    Object data = null;
    int status = 0;

    public JsonSuccessData() {
        logger.debug("Wrap a json success data : []");
    }

    public JsonSuccessData(Object data) {
        this.data = data;
        logger.debug("Wrap a json success data : {}", this);
    }

    public JsonSuccessData(Object data, int status) {
        this.data = data;
        this.status = status;
        logger.debug("Wrap a json success data : {}", this);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonSuccessData{" + "data=" + data + ", status=" + status + '}';
    }
}
