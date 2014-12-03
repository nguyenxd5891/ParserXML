package com.example.xmlparserimage1.entity;

public class Album {

	private String image;
	private String name;
	private String idAlbum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Album() {
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Image Girl: " + this.image;
	}

	public String getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(String idAlbum) {
		this.idAlbum = idAlbum;
	}

}
