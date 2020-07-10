package alexgit95.batch.PhotosToPositions.model;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import alexgit95.batch.PhotosToPositions.utils.Utils;

@DynamoDBTable(tableName="Photos")
public class Photos   {
	
	
	private String name;
	private double lattitude;
	private double longitude;
	private Date dateprise;
	
	private Date truncatedDate;
	
	@DynamoDBHashKey(attributeName="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@DynamoDBAttribute(attributeName="lattitude")
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	@DynamoDBAttribute(attributeName="longitude")
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@DynamoDBAttribute(attributeName="dateprise")
	public Date getDateprise() {
		return dateprise;
	}
	public void setDateprise(Date dateprise) {
		this.dateprise = dateprise;
		this.truncatedDate=Utils.truncateDate(dateprise);
	}
	public Photos() {
		super();
	}
	public Photos(String name, double lattitude, double longitude, Date dateprise) {
		super();
		this.name = name;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.dateprise = dateprise;
		
		this.truncatedDate=Utils.truncateDate(dateprise);
	}
	@Override
	public String toString() {
		return "Photos [name=" + name + ", lattitude=" + lattitude + ", longitude=" + longitude + ", dateprise="
				+ dateprise + "]";
	}
	public Date getTruncatedDate() {
		return truncatedDate;
	}
	
	
	public boolean isFarFrom(Photos otherPhoto) {
		System.out.println(this.lattitude+"|"+otherPhoto.getLattitude()+"|"+this.longitude+"|"+otherPhoto.getLongitude());
		return Utils.distance(this.lattitude, otherPhoto.getLattitude(), this.longitude, otherPhoto.getLongitude())>4000;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((truncatedDate == null) ? 0 : truncatedDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photos other = (Photos) obj;
		if (truncatedDate == null) {
			if (other.truncatedDate != null)
				return false;
		} else if (!truncatedDate.equals(other.truncatedDate)) {
			return false;
		}else if(Utils.distance(lattitude, other.getLattitude(), longitude, other.getLongitude())>4000){
			return false;
		}
		return true;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
