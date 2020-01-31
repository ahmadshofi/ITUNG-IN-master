package id.itungin.itung_in.register;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("result")
	private List<ResultItem> result;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}
}