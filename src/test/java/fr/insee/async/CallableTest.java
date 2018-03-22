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
		// Ex�cuter la fonction fetchOne()
		// Lancer la fonction longCalcul() sans attendre le r�sultat de la fonction fetchOne.
		// Imprimer le r�sultat de la fonction fetchOne
	}
	
	@Test
	public void callableIsDone() throws InterruptedException, ExecutionException {
		// Ex�cuter la fonction fetchOne()
		// Tant que le r�sultat n'est pas ariv�, imprimer un message chaque 20 millisecondes.
		// Imprimer le r�sultat de la fonction fetchOne
	}
	
	@Test
	public void invokeAll() throws InterruptedException, ExecutionException {
		// Ex�cuter en parall�le 5 fois la fonction fetchOne en faisant varier le param�tre rank.
		// Essayer de faire varier la taille du pool de threads
	}
	
	@Test
	public void invokeAny() throws InterruptedException, ExecutionException {
		// Ex�cuter en parall�le 5 fois la fonction fetchOne en faisant varier le param�tre rank.
		// Imprimer le premier �tablissement � �tre retourn�
	}
}
