package fileAdminProject;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import net.smartam.leeloo.client.response.OAuthJSONAccessTokenResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import documents.document;
import folder.folder;

import user.user;



public class HuddleApiImpl implements HuddleApi {
	
	private OAuthJSONAccessTokenResponse tokenClient;
	private HttpClient httpClient;
	private XmlParser xml;
	
	public HuddleApiImpl(HttpClient httpClient,OAuthJSONAccessTokenResponse tokenClient, XmlParser xml)
	{
		this.httpClient = httpClient;
		this.xml = xml;
		this.tokenClient = tokenClient;
	}
	
	public user getUser() throws IOException, URISyntaxException
	{	
		
		URI uri = new URI("http://api.huddle.dev/" + "entry/");
		HttpGet httpget = new HttpGet(uri);
		httpget.addHeader("Authorization", "OAuth2 "+ tokenClient.getAccessToken());
		HttpResponse response = httpClient.execute(httpget);
		
		user user;
		user = xml.parseXmlUser(response.getEntity().getContent());
		return user;
	}
	     
	
	@Override
	public folder getFolders(URI uri) throws IOException
	{
		
		HttpGet httpget = new HttpGet(uri);
		httpget.addHeader("Authorization", "OAuth2 "+ tokenClient.getAccessToken());
		HttpResponse response = httpClient.execute(httpget);
		
		
		folder folder;
		folder = xml.parseXmlFolder(response.getEntity().getContent());
		
		return folder;
	}
	
	@Override
	public void deleteContent(URI uri) throws IOException
	{
		HttpDelete httpDelete = new HttpDelete(uri);
		httpDelete.addHeader("Authorization", "OAuth2 "+ tokenClient.getAccessToken());
		httpClient.execute(httpDelete);

	}
	
	@Override
	public void createFolder(URI uri, String name, String desc) throws IOException
	{
	    HttpPost httpPost = new HttpPost(uri);
	    httpPost.addHeader("Authorization", "OAuth2 "+ tokenClient.getAccessToken());
	    httpPost.addHeader("Content-Type","application/vnd.huddle.data+xml");
	    
		 //set the body to post
	    StringEntity entity = new StringEntity("<folder title=" + name + " description=" + desc + "/>");
	    httpPost.setEntity(entity);
	    
	    httpClient.execute(httpPost);
	}
	
	@Override
	public document createFile(URI uri, String name, String desc) throws IOException
	{
	    HttpPost httpPost = new HttpPost(uri);
	    httpPost.addHeader("Authorization", "OAuth2 "+ tokenClient.getAccessToken());
	    httpPost.addHeader("Content-Type","application/vnd.huddle.data+xml");
	    
		 //set the body to post
	    StringEntity entity = new StringEntity("<document title=" + "\"" +  name + "\"" + " description=" + "\""+ desc + "\"" + "/>");
	    httpPost.setEntity(entity);
	    
	    HttpResponse response = httpClient.execute(httpPost);
	    document document = xml.parseXmlDocuments(response.getEntity().getContent());

	    return document;
	}
	@Override
	public void uploadToFile(URI document, File file) throws IOException {
		HttpPut httpPut = new HttpPut(document);
	    httpPut.addHeader("Authorization", "OAuth2 "+ tokenClient.getAccessToken());
	    httpPut.addHeader("Content-Type","multipart/form-data");
	    
	    MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
	    entity.addPart("filename",new FileBody(file));
	    httpPut.setEntity(entity);
	    
	    httpClient.execute(httpPut);
	}
}
