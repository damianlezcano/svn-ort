package web;

import java.io.File;
import java.util.Date;

public class GraphItemView implements UIGraph{
	
	private Date date;
	private float amount;
	
	//--
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public File getImageGraph() {
		return null;
	}
	@Override
	public Double getValueX() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Double getValueY() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
