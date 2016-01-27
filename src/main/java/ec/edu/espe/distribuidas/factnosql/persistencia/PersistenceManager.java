package ec.edu.espe.distribuidas.factnosql.persistencia;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class PersistenceManager {
	private static Morphia morphia;
	private static MongoClient mongoClient;
	private final Datastore mds;
	
	static{
		MongoClientOptions mongoOptions = 
		MongoClientOptions.builder().socketTimeout(60000).connectTimeout(60000).build();
		
		try
		{	
                    mongoClient = new MongoClient(new ServerAddress("localhost"),mongoOptions);
                }
		catch(Exception e)
		{
			
			throw new RuntimeException("Error",e);
		}
		
		mongoClient.setWriteConcern(WriteConcern.SAFE);
		morphia = new Morphia();
		
		morphia.mapPackage("ec.edu.espe.distribuidas.factnosql.modelo", true);
		
	}
	
	public PersistenceManager()
	{
		
		mds = morphia.createDatastore(mongoClient, "facturacion");
		mds.ensureIndexes();
	}

	public Datastore context()
	{
		return this.mds;
	}
	
	
}
