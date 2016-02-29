/**
 * 
 */
package com.m0427.web.model.web;



/**
 * @author zhj
 *
 */
public class AjaxResult {
	private HttpStatus statusCode;
	private String message;
	private String rel;
	private CallbackType callbackType;
	private String forwardUrl;
	private String confirmMsg;
	private Object data;
	
	public AjaxResult(String message)
	{
		this.statusCode=HttpStatus.OK;
	  this.callbackType=CallbackType.Empty;
		this.message=message;
	}

	public int getStatusCode() {
		return statusCode==null?HttpStatus.OK.getValue():statusCode.getValue();
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getCallbackType() {
		return callbackType==null?CallbackType.Empty.getValue():callbackType.value;
	}

	public void setCallbackType(CallbackType callbackType) {
		this.callbackType = callbackType;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String getConfirmMsg() {
		return confirmMsg;
	}

	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
