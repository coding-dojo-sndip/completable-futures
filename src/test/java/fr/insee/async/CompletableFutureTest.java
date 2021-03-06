package fr.insee.async;

import static java.util.concurrent.CompletableFuture.allOf;
import static java.util.concurrent.CompletableFuture.anyOf;
import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.assertj.core.util.Objects;
import org.junit.Test;

import fr.insee.async.sirene.service.CalculService;
import fr.insee.async.sirene.service.SireneService;

public class CompletableFutureTest {
	
	private SireneService sireneService = SireneService.getInstance();
	private CalculService calculService = CalculService.getInstance();
	
	@Test
	public void thenAccept() throws InterruptedException, ExecutionException {
		// Ex�cuter la fonction fetchOne
		// Une fois la fontion termin�e, ex�cuter la fonction longCalcul avec en param�tre l'�tablissement retourn�
		// Imprimer "Termin�" dans la console
		// En parall�le de ces op�rations, ex�cuter la fonction longCalcul sans param�tre
	}
	
	@Test
	public void thenApply() throws InterruptedException, ExecutionException, TimeoutException {
		// Ex�cuter la fonction fetchFirst
		// Enchainer la m�thode fetchNext
		// R�cup�rer le premier �tablissement de la deuxi�me page
		// En parall�le, ex�cuter la fonction longCalcul sans param�tre
	}
	
	@Test
	public void allOfTest() throws InterruptedException, ExecutionException, TimeoutException {
		// Ex�cuter la fonction fetchOne et imprimer le r�sultat une fois obtenu
		// En parall�le, lancer la fonction longCalcul
	}
	
	@Test
	public void anyOfTest() throws InterruptedException, ExecutionException, TimeoutException {
		// Ex�cuter en parall�le 4 fois la fonction fetchOne en faisant varier le param�tre rank.
		// Imprimer le premier �tablissement � �tre retourn�
	}
}
