package alexgit95.batch.PhotosToPositions.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import alexgit95.batch.PhotosToPositions.model.IgnorePlace;
import alexgit95.batch.PhotosToPositions.model.LocationsOutput;
import alexgit95.batch.PhotosToPositions.model.Photos;

@Component
public class DaoServicesImpl implements DaoServices {

	private AmazonDynamoDB client;
	private DynamoDBMapper mapper;
	

	public DaoServicesImpl() {
		super();
		client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_3).build();
		mapper = new DynamoDBMapper(client);
	}
	
	@Override
	public void savePosition(LocationsOutput toSave) {
		mapper.save(toSave);
		
	}

	@Override
	public List<Photos> getAllPictures() {
		return mapper.scan(Photos.class, new DynamoDBScanExpression());
	}

	@Override
	public List<LocationsOutput> getAllPositions() {
		return mapper.scan(LocationsOutput.class, new DynamoDBScanExpression());
	}

	@Override
	public List<IgnorePlace> getAllIgnorePlaces() {
		return mapper.scan(IgnorePlace.class, new DynamoDBScanExpression());
	}

}
