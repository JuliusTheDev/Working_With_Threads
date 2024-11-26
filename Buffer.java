import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Pedido> pedidos;
    private int capacidade;

    public Buffer() {
        this.pedidos = new LinkedList<>();
        this.capacidade = 10; // Capacidade da fila de pedidos
    }

    public synchronized void set(int idCliente, Pedido pedido) {
        while (pedidos.size() == capacidade) {
            try {
                System.out.println("Cliente #" + idCliente + " esperando para fazer o pedido...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pedidos.add(pedido);
        System.out.println("Cliente #" + idCliente + " fez o pedido de " + pedido.getNome() + " (" + pedido.getCategoria() + ")");
        notifyAll();
    }

    public synchronized Pedido get(int idCozinheiro) {
        while (pedidos.isEmpty()) {
            try {
                System.out.println("Cozinheiro #" + idCozinheiro + " esperando por pedidos...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Pedido pedido = pedidos.poll();
        System.out.println("Cozinheiro #" + idCozinheiro + " está preparando " + pedido.getNome() + " (" + pedido.getCategoria() + ")");
        notifyAll();
        return pedido;
    }
}