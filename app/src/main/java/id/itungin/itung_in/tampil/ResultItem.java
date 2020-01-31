package id.itungin.itung_in.tampil;

import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("id_pemasukkan")
	private String idPemasukkan;

	@SerializedName("pemasukkan")
	private int pemasukkan;

	@SerializedName("jam")
	private String jam;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("tanggal")
	private String tanggal;

	public void setIdPemasukkan(String idPemasukkan){
		this.idPemasukkan = idPemasukkan;
	}

	public String getIdPemasukkan(){
		return idPemasukkan;
	}

	public void setPemasukkan(int pemasukkan){
		this.pemasukkan = pemasukkan;
	}

	public int getPemasukkan(){
		return pemasukkan;
	}

	public void setJam(String jam){
		this.jam = jam;
	}

	public String getJam(){
		return jam;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}
}