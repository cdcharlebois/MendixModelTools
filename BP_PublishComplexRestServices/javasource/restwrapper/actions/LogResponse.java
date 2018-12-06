// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package restwrapper.actions;

import java.util.HashMap;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

/**
 * Store the response data in the RequestHistory entity. 
 * 
 * This java action will create a new context and transaction, and a-synchronously call a Microflow to log the data so your response doesn't get delayed. The parameters are passed to the microflow: LogResponseFromJava which evaluates the data and logs all relevant information
 */
public class LogResponse extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __ResponseParameter1;
	private restwrapper.proxies.Response ResponseParameter1;
	private IMendixObject __HttpRequestParameter1;
	private system.proxies.HttpRequest HttpRequestParameter1;

	public LogResponse(IContext context, IMendixObject ResponseParameter1, IMendixObject HttpRequestParameter1)
	{
		super(context);
		this.__ResponseParameter1 = ResponseParameter1;
		this.__HttpRequestParameter1 = HttpRequestParameter1;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.ResponseParameter1 = __ResponseParameter1 == null ? null : restwrapper.proxies.Response.initialize(getContext(), __ResponseParameter1);

		this.HttpRequestParameter1 = __HttpRequestParameter1 == null ? null : system.proxies.HttpRequest.initialize(getContext(), __HttpRequestParameter1);

		// BEGIN USER CODE
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("HttpRequest", this.__HttpRequestParameter1);
		paramMap.put("Response", this.__ResponseParameter1);
		
		Core.executeAsync(getContext().clone(), "RestWrapper.LogResponseFromJava", false, paramMap);
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "LogResponse";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
