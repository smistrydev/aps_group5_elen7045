package elen7045.group5.project.aps.rest;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/**
 * Some of the REST calls are required to be via <code>POST</code> calls and for
 * this we usually pass through JSON. The REST implementation (GSON) sees this JSON as
 * an object in the POST and then tries to match it to a Java equivalent
 *  
 */
public class RuleSetJSON implements Serializable {

  private static final long serialVersionUID = 1123123123L;
  private String modifyUser;
  private int ruleSetId;

  public int getRuleSetId() {
    return ruleSetId;
  }

  public void setRuleSetId(int ruleSetId) {
    this.ruleSetId = ruleSetId;
  }

  /** 
   * @deprecated - Method is no longer used as we are now pulling out the user
   * from the {@link HttpServletRequest}  
   */
  @Deprecated
public String getModifyUser() {
    return modifyUser;
  }

  /** 
   * @deprecated - Method is no longer used as we are now pulling out the user
   * from the {@link HttpServletRequest}  
   */
  @Deprecated
public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }
}
