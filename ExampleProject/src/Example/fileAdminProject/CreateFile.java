package fileAdminProject;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import link.sortLinks;

import org.apache.http.impl.client.DefaultHttpClient;

import documents.document;
import net.smartam.leeloo.client.request.OAuthClientRequest;
import net.smartam.leeloo.client.response.OAuthJSONAccessTokenResponse;
import net.smartam.leeloo.common.exception.OAuthProblemException;
import net.smartam.leeloo.common.exception.OAuthSystemException;

/*
*You'll need to get a clientId and RedirectURI from huddle:
*http://code.google.com/p/huddle-apis/wiki/OauthIntegration
*/
public class CreateFile {
	//this example will make a file in the first folder it finds in the first workspace
	public static void main(String args[])
	{
		String _HUDDLEAUTHSERVER = "https://login.huddle.net/";
		Authentication auth;
		OAuthJSONAccessTokenResponse token;
		Scanner input = new Scanner(System.in);
		HuddleApiImpl api;
		sortLinks sortLinks;
		document document;
		
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
			
			//first we need to create the file to do this we upload the data to a given workspace link
			URI uri = new URI("http://api.huddle.dev/files/folders/1237980");
			sortLinks = new sortLinks(api.getFolders(uri).getLinks());

			uri = new URI(sortLinks.getLinkWithRel("create-document").getHref());

			//now we have the document that we just created to us we can upload to it
			document  = api.createFile(uri, "foo", "bar");
			sortLinks = new sortLinks(document.getLinks());
			
			//gets the upload uri
			uri = new URI(sortLinks.getLinkWithRel("upload").getHref());
			api.uploadToFile(uri, new File("C:\\Users\\adam.flax\\Documents\\foo.txt"));
			
			
		}catch(OAuthSystemException ex){System.out.println(ex);}
		catch(URISyntaxException ex){System.out.println(ex);}
		catch(OAuthProblemException ex){System.out.println(ex);}
		catch(IOException ex){System.out.println(ex);}
		System.exit(0);//out of the while loop
	}

}
