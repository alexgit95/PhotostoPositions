package alexgit95.batch.PhotosToPositions;



import org.springframework.stereotype.Component;


@Component
public class PhotosToPositionsApplicationTests {/*
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	@Autowired
	PhotosToPositionsCommandLineRunner runner;
	
	private List<Photos> allPhotos = new ArrayList<Photos>();
	
	
		
	@Test
	public void test() throws Exception {
		runner = new PhotosToPositionsCommandLineRunner();
		
		initTestsPhotos();
		
		
		DaoServices mockDao = Mockito.mock(DaoServices.class);
		List<LocationsOutput> allPositions = new ArrayList<LocationsOutput>();
		LocationsOutput fakeExistingPosition = new LocationsOutput();
		fakeExistingPosition.setAddress("NAMETEST");
		fakeExistingPosition.setLattitude(44);
		fakeExistingPosition.setLongitude(4);
		
		
		
		
		
		Calendar begin = Calendar.getInstance();
		begin.set(Calendar.YEAR, 2018);
		begin.set(Calendar.MONTH, Calendar.AUGUST);
		begin.set(Calendar.DAY_OF_MONTH, 24);
		
		begin.set(Calendar.HOUR_OF_DAY, 11);
		begin.set(Calendar.MINUTE, 44);
		begin.set(Calendar.SECOND, 43);
		fakeExistingPosition.setBegin(begin.getTime());
		
		Calendar endtime = Calendar.getInstance();
		endtime.set(Calendar.YEAR, 2018);
		endtime.set(Calendar.MONTH, Calendar.AUGUST);
		endtime.set(Calendar.DAY_OF_MONTH, 24);
		
		endtime.set(Calendar.HOUR_OF_DAY, 11);
		endtime.set(Calendar.MINUTE, 44);
		endtime.set(Calendar.SECOND, 45);
		fakeExistingPosition.setEnd(endtime.getTime());
		
		allPositions.add(fakeExistingPosition);
		
		
		Mockito.when(mockDao.getAllPositions()).thenReturn(allPositions);
		Mockito.when(mockDao.getAllPictures()).thenReturn(allPhotos);
		
		
		runner.setDaoServices(mockDao);
		runner.run();
		assertEquals("Nombre d'elements attendu comme traite",386, runner.getNbElementsTraites());
		
		
	}
	
	
	
	private void initTestsPhotos() throws IOException{
		
		List<String> lines = FileUtils.readLines(new File("src/main/resources/Photos.csv"), Charset.defaultCharset());
		
		Function<String, String> cleanString= s ->{
			s=s.replaceAll("\"", "");
			return s;
		};
		
		Consumer<String> extractPhotos = s->{
			String[] split = s.split(",");
			try {
				
				allPhotos.add(new Photos(split[0],Double.parseDouble(split[2]),Double.parseDouble(split[3]),sdf.parse(split[1])));
			} catch (NumberFormatException | ParseException e) {
				e.printStackTrace();
			}
		};
		
		lines.stream().map(cleanString).forEach(extractPhotos);
		
	}*/

}
