package fileAdminProject;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.impl.client.DefaultHttpClient;

import link.sortLinks;
import membership.workspace;
import net.smartam.leeloo.client.request.OAuthClientRequest;
import net.smartam.leeloo.client.response.OAuthJSONAccessTokenResponse;

public class getWorkspaces {
/*
 * You'll need to get a clientId and RedirectURI from huddle:
 *http://code.google.com/p/huddle-apis/wiki/OauthIntegration
*/
	
	public static void main(String args[])
	{
		String _HUDDLEAUTHSERVER = "https://login.huddle.net/";
		Authentication auth;
		OAuthJSONAccessTokenResponse token;
		Scanner input = new Scanner(System.in);
		HuddleApiImpl api;
		
		try
		{
			//First we need to get the person's Auth code so we can get the access token
	    	OAuthClientRequest request = OAuthClientRequest
	    			.authorizationLocation(_HUDDLEAUTHSERVER + "request")
	    			.setClientId("FOO")
	    			.setRedirectURI("BAR")
	    			.setResponseType("code")
	    			.buildQueryMessage();
	
	    	//in web application you make redirection to uri:
	    	System.out.println("Visit: " + request.getLocationUri() + "\nto get your authorisation code");
	
	    	System.out.print("Now enter the OAuth code you have received in redirect uri ");
	    	String code = input.nextLine();
	    	
	    	//now lets get our selves a access token
			auth = new Authentication(_HUDDLEAUTHSERVER,code);
			
			token = auth.handleAccessToken();
			System.out.println("Your access token is: " + token.getAccessToken());
			
			//now we can mess around with the api yay
			api = new HuddleApiImpl(new DefaultHttpClient(),token,new XmlParser());

			ArrayList<workspace> workspaces = api.getUser().getMembership().getWorkspaces().getWorkspace();//store the workspace info into an arrayList

			System.out.println("You currently have " + workspaces.size() + " workspaces!");
					
			if(workspaces != null && workspaces.size() > 0)
			{
				for(int i = 0; i < workspaces.size(); i++)
				{
					//sort the array of links out!
					sortLinks sortLinks = new sortLinks(workspaces.get(i).getLinks());
					System.out.println(i + "." + workspaces.get(i).getTitle() + " " + workspaces.get(i).getType() 
							+ " at location: " + sortLinks.getLinkWithRel("documentLibrary").getHref() ); 
				}
			}	
		}catch(Exception ex){System.out.println(ex);}
		System.exit(0);//out of the while loop
	}

}
