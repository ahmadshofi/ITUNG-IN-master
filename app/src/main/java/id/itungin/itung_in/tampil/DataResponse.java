package id.itungin.itung_in.tampil;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataResponse{

	@SerializedName("result")
	private List<ResultItem> result;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}
}