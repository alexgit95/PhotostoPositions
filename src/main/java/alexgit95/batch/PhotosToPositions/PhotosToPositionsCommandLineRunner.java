package alexgit95.batch.PhotosToPositions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import alexgit95.batch.PhotosToPositions.model.LocationsOutput;
import alexgit95.batch.PhotosToPositions.model.Photos;
import alexgit95.batch.PhotosToPositions.services.DaoServices;
import alexgit95.batch.PhotosToPositions.utils.Utils;


@Component
public class PhotosToPositionsCommandLineRunner implements CommandLineRunner {
	
	
	public static ConcurrentHashMap<Date, Photos> dejaEnregistre = new ConcurrentHashMap<>();
	
	
	@Autowired
	private DaoServices daoServices;

	
	private Logger logger = LoggerFactory.getLogger(PhotosToPositionsCommandLineRunner.class);
	
	private int nbElementsTraites;

	@Override
	public void run(String... args) throws Exception {

		long debut=System.nanoTime();
		List<Photos> allPhotos = daoServices.getAllPictures();
		List<LocationsOutput> allPositions = daoServices.getAllPositions();
		Gson gson=new Gson();
		System.out.println(gson.toJson(allPositions));
		if(allPositions.size()>0) {
			return;
		}
		
		
		//Ajout des poisitions deja existante dans la DB
		allPositions.stream().forEach(location -> { 
			dejaEnregistre.put(Utils.truncateDate(location.getBegin()), new Photos(location.getName(),location.getLattitude(),location.getLongitude(),location.getBegin())); 
		});
		
		logger.info("Avant traitement "+allPhotos.size());
		
		
		List<LocationsOutput> elementsTraite = new ArrayList<>();
		
		Consumer<Photos> savePhotos = photo -> {
			logger.info("Sauvegarde de la position : "+photo.getName());
			
			LocationsOutput output = new LocationsOutput();
			output.setBegin(photo.getDateprise());
			output.setEnd(photo.getDateprise());
			output.setLattitude(photo.getLattitude());
			output.setLongitude(photo.getLongitude());
			elementsTraite.add(output);
			daoServices.savePosition(output);
						
		};
		
		
		allPhotos.stream().distinct().forEach(savePhotos);
		
		
		long fin=System.nanoTime();
		long duree=fin-debut;
		logger.info("Duree execution : "+(duree/1000000)+"ms");
		setNbElementsTraites(elementsTraite.size());
		logger.info("Elements finalement traites : "+elementsTraite.size());
		
	}

	

	public void setDaoServices(DaoServices daoServices) {
		this.daoServices = daoServices;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}



	public int getNbElementsTraites() {
		return nbElementsTraites;
	}



	public void setNbElementsTraites(int nbElementsTraites) {
		this.nbElementsTraites = nbElementsTraites;
	}
	
	
	
	
	
	
	
	

}
