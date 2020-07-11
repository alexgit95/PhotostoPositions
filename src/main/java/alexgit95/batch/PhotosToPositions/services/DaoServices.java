package alexgit95.batch.PhotosToPositions.services;

import java.util.List;

import alexgit95.batch.PhotosToPositions.model.IgnorePlace;
import alexgit95.batch.PhotosToPositions.model.LocationsOutput;
import alexgit95.batch.PhotosToPositions.model.Photos;

public interface DaoServices {
	
	
	void savePosition(LocationsOutput toSave);
	
	List<Photos> getAllPictures();
	
	List<LocationsOutput> getAllPositions();
	
	List<IgnorePlace> getAllIgnorePlaces();

}
