/*
 * 公司名称：江苏华招网信息技术有限公司
 * 版权信息：江苏华招网信息技术有限公司版权所有
 * 文件名称：Tree.java
 * 修改时间：2017-3-8
 * 修改人：胡贤
 * 修改内容：
 * 跟踪单号：
 * 修改单号 ：
 */

package cn.com.njdhy.muscle.triceps.model.database;

import java.io.Serializable;

/**
 * <一句话功能简述> 树控件实体类
 * <功能详细描述>
 * @author 胡贤
 * @version V0.0.1-SNAPSHOT
 */
public class OrgZTree implements Serializable {
    
    /* *******************************************************************************************/
    /*                                        序列化代码区域                                                                                                     */
    /* *******************************************************************************************/
    private static final long serialVersionUID = 1L;
    
    /* *******************************************************************************************/
    /*                                       全局变量声明区域                                                                                                    */
    /* *******************************************************************************************/
    
    private String orgCode;

    private String pOrgCode;

    private String orgName;

    /**
     * 是否打开
     */
    private boolean open;

    /**
     * 是否选中
     */
    private boolean checked;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getpOrgCode() {
        return pOrgCode;
    }

    public void setpOrgCode(String pOrgCode) {
        this.pOrgCode = pOrgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    /* *******************************************************************************************/
    /*                                       私有函数声明区域                                                                                                    */
    /* *******************************************************************************************/
}
