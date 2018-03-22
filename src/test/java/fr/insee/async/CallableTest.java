package fr.insee.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import fr.insee.async.sirene.service.CalculService;
import fr.insee.async.sirene.service.SireneService;

public class CallableTest {
	
	private SireneService sireneService = SireneService.getInstance();
	private CalculService calculeService = CalculService.getInstance();
	
	@Test
	public void callable() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		System.out.println("Soumission du callable");
		Future<Etablissement> future = executor.submit(() -> sireneService.fetchOne(1000));
		executor.shutdown();
		
		System.out.println("Ex�cution d'un calcul");
		calculeService.longCalcul();
		
		System.out.println("R�cup�ration du contenu du future");
		Etablissement etablissement = future.get();
		System.out.println(etablissement);
		
	}
	
	@Test
	public void callableIsDone() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		System.out.println("Soumission du callable");
		Future<Etablissement> future = executor.submit(() -> sireneService.fetchOne(1000));
		executor.shutdown();
		
		while(!future.isDone()) {
			System.out.println("Requ�te en cours...");
			TimeUnit.MILLISECONDS.sleep(200);
		}
		
		System.out.println("R�cup�ration du contenu du future");
		Etablissement etablissement = future.get();
		System.out.println(etablissement);
		
	}
	
	@Test
	public void callableThenApply() throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		System.out.println("Soumission du callable");
		executor.shutdown();
		Future<Etablissement> future = executor.submit(() -> sireneService.fetchOne(1500));
		calculeService.longCalcul();
		calculeService.longCalcul(future.get(1, TimeUnit.MINUTES));
		System.out.println("Termin�");
		
	}
	
	@Test
	public void invokeAll() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		System.out.println("Soumission des callables");
		List<Future<Etablissement>> futures = executor.invokeAll(Arrays.asList(
			() -> sireneService.fetchOne(0),
			() -> sireneService.fetchOne(100),
			() -> sireneService.fetchOne(10000),
			() -> sireneService.fetchOne(10001),
			() -> sireneService.fetchOne(10002)
		));
		executor.shutdown();
		
		System.out.println("R�cup�ration du contenu des futures");
		for (Future<Etablissement> future : futures) {
			System.out.println(future.get());
		}
		
	}
	
	@Test
	public void invokeAny() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		System.out.println("Soumission des callables");
		Etablissement etablissement = executor.invokeAny(Arrays.asList(
			() -> sireneService.fetchOne(0),
			() -> sireneService.fetchOne(100),
			() -> sireneService.fetchOne(10000),
			() -> sireneService.fetchOne(10001),
			() -> sireneService.fetchOne(10002)
		));
		executor.shutdown();
		System.out.println(etablissement);
	}
}
