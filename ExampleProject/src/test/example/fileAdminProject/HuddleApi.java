package fileAdminProject;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import documents.document;

import user.user;
import folder.folder;

public interface HuddleApi {

	public abstract user getUser() throws IOException, URISyntaxException;

	public abstract folder getFolders(URI folderUri)
			throws IOException;

	public abstract void deleteContent(URI objectUri)
			throws IOException;

	public abstract void createFolder(URI parentFolder, String name, String desc) throws IOException;
	
	public abstract document createFile(URI parentFolder, String name, String desc) throws IOException;
	
	public abstract void uploadToFile(URI document, File file) throws IOException;

}