/**
 *       Copyright 2010 Newcastle University
 *           Maciej Machulak, Lukasz Moren
 *
 *          http://research.ncl.ac.uk/smart/
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package fileAdminProject;


import java.sql.Timestamp;
import java.util.Calendar;
import net.smartam.leeloo.client.OAuthClient;
import net.smartam.leeloo.client.URLConnectionClient;
import net.smartam.leeloo.client.request.OAuthClientRequest;
import net.smartam.leeloo.client.response.OAuthJSONAccessTokenResponse;
import net.smartam.leeloo.common.exception.OAuthProblemException;
import net.smartam.leeloo.common.exception.OAuthSystemException;
import net.smartam.leeloo.common.message.types.GrantType;

public class Authentication {
	
	private String huddleAuthServer;
	private String code;
	private OAuthJSONAccessTokenResponse oAuthResponse;
	private Timestamp refreshTime;
	//for timings
	Calendar calender = Calendar.getInstance();

	public Authentication(String huddleAuthServer, String code)
	{
		this.huddleAuthServer = huddleAuthServer;
		this.code = code;
	}
    
    //this is the only method that will get called, it will return whatever token is needed
    public OAuthJSONAccessTokenResponse handleAccessToken() throws OAuthSystemException, OAuthProblemException
    {
    	if(oAuthResponse == null)
    		return getAccessToken();
    	else if(new Timestamp(calender.getTime().getTime()).compareTo(refreshTime) >= 0)
    		return refreshAccessToken();
    	else
    		return oAuthResponse;
    	
    }
    
    private OAuthJSONAccessTokenResponse getAccessToken() throws OAuthSystemException, OAuthProblemException
    {
    	OAuthClientRequest request = OAuthClientRequest
    			.tokenLocation(huddleAuthServer + "token/")
    			.setGrantType(GrantType.AUTHORIZATION_CODE)
    			.setClientId("FileAdminProjectHuddleOob")
    			.setRedirectURI("urn:ietf:wg:oauth:2.0:oob")
    			.setCode(code)
    			.buildBodyMessage();

    	request.addHeader("Accept", "application/json");
    	OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
    	oAuthResponse = oAuthClient.accessToken(request, OAuthJSONAccessTokenResponse.class);
 
    	//work out what time the token expires
    	refreshTime = new Timestamp(Long.parseLong(oAuthResponse.getExpiresIn()) + calender.getTime().getTime());
    	return oAuthResponse;

    }
    
    private OAuthJSONAccessTokenResponse refreshAccessToken() throws OAuthSystemException, OAuthProblemException
    {
    	//now lets refresh the token
    	OAuthClientRequest request = OAuthClientRequest
    			.tokenLocation(huddleAuthServer + "token/")
    			.setGrantType(GrantType.REFRESH_TOKEN)
    			.setClientId("FileAdminProjectHuddleOob")
    			.setRefreshToken(oAuthResponse.getRefreshToken())
    			.buildBodyMessage();

    	request.addHeader("Accept", "application/json");
    	OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
    	System.out.println("----Refreshing Access Token----");  

    	oAuthResponse = oAuthClient.accessToken(request, OAuthJSONAccessTokenResponse.class);
    	System.out.println("Access Token: " + oAuthResponse.getAccessToken() + ", Expires in: " + oAuthResponse .getExpiresIn());
    	refreshTime = new Timestamp(Long.parseLong(oAuthResponse.getExpiresIn()) + calender.getTime().getTime());
    	return oAuthResponse;
    }
}
