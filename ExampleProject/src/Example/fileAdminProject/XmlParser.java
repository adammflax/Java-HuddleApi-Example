package fileAdminProject;
import java.io.InputStream;

import link.link;
import membership.membership;


import profile.profile;

import user.user;

import Internationalisation.internationalisation;

import actor.actor;
import ancestry.ancestry;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import documents.document;
import documents.documents;

import folder.folder;
import folder.folders;



public class XmlParser {
	
	
	
	public user parseXmlUser(InputStream is)
	{
		//use the magic of serialisation and seralise the xml data to the user object
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		
		//set the alias (by default xstream expects all the classes to be in the same package
		xstream.alias("user", user.class);
		xstream.alias("profile", profile.class);
		xstream.alias("membership", membership.class);
		xstream.alias("internationalisation", internationalisation.class);
		xstream.alias("link", link.class);

		user user =  (user)xstream.fromXML(is);
       return user;
	}
	
	public folder parseXmlFolder(InputStream is)
	{
		//use the magic of serialisation and seralise the xml data to the folder object
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		
		//set the alias (by default xstream expects all the classes to be in the same package
		xstream.setClassLoader(folder.class.getClassLoader());
		xstream.alias("ancestry", ancestry.class);
		xstream.alias("actor", actor.class);
		xstream.alias("folder", folder.class);
		xstream.alias("folders", folders.class);
		xstream.alias("documents", documents.class);
		
		folder folder =  (folder)xstream.fromXML(is);

       return folder;
	}
	
	public document parseXmlDocuments(InputStream is)
	{
		//use the magic of serialisation and seralise the xml data to the folder object
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		
		//set the alias (by default xstream expects all the classes to be in the same package
		xstream.setClassLoader(document.class.getClassLoader());
		xstream.alias("document", document.class);
		
		document document =  (document)xstream.fromXML(is);

       return document;
	}
}
