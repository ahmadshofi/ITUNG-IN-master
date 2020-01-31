package id.itungin.itung_in.login;

import com.google.gson.annotations.SerializedName;

public class 	Data{

	@SerializedName("id_user")
	private String idUser;

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}
}