package com.example.customgriddemo;

public class Photo 
{
   int imageId;
   String title;
public Photo(int imageId, String title) {
	super();
	this.imageId = imageId;
	this.title = title;
}
public int getImageId() {
	return imageId;
}
public void setImageId(int imageId) {
	this.imageId = imageId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
   
   
}
