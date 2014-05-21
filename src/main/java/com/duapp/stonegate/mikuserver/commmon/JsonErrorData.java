package com.duapp.stonegate.mikuserver.commmon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * com.qunar.qtown.lib.common.JsonErrorData
 * 
 * @author yushen.ma
 * @date 2014-03-26
 */
public class JsonErrorData implements Serializable {

    private static final long serialVersionUID = -2865731288421128872L;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * this will ignore
     */

    String errmsg;
    int status = 1;

    public JsonErrorData(String errmsg) {
        this.errmsg = errmsg;
        logger.debug("Wrap a json error data : {}", this);
    }

    public JsonErrorData(String errmsg, int status) {
        this.errmsg = errmsg;
        this.status = status;
    }

    public JsonErrorData(String errmsg, int status, String originMsg) {
        this.errmsg = errmsg;
        this.status = status;
        logger.debug("Wrap a json error data : {}", this);
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JsonErrorData{" + "errmsg='" + errmsg + '\'' + ", status=" + status + '}';
    }
}
