import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {
    public static void main(String[] args) {
        Random random = new Random();
        int numClientes = 20 + random.nextInt(31); // Número de clientes entre 20 e 50
        int numCozinheiros = 5 + random.nextInt(6); // Número de cozinheiros entre 5 e 10

        Buffer buffer = new Buffer();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= numClientes; i++) {
            executor.execute(new Cliente(i, buffer));
        }

        for (int i = 1; i <= numCozinheiros; i++) {
            executor.execute(new Cozinheiro(i, buffer));
        }

        executor.shutdown();
    }
}