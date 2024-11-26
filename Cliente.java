import java.util.Random;

public class Cliente implements Runnable {
    private int idCliente;
    private Buffer buffer;

    public Cliente(int id, Buffer buffer) {
        this.idCliente = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] itens = {"Salada Caesar", "Sopa de tomate", "Carpaccio de carne", "Frango grelhado", "Bife com batatas fritas", "Lasagna à bolonhesa", "Macarrão com frutos do mar", "Risoto de cogumelos", "Mousse de chocolate", "Tiramisu", "Cheesecake"};
        String[] categorias = {"Entrada", "Prato principal", "Sobremesa"};

        for (int i = 0; i < 3; i++) {
            String nome = itens[random.nextInt(itens.length)];
            int tempoPreparo = 100 + random.nextInt(3901); // Tempo de preparo entre 100 e 4000ms
            String categoria = categorias[i];

            Pedido pedido = new Pedido(nome, tempoPreparo, categoria);
            buffer.set(idCliente, pedido);

            try {
                Thread.sleep(100 + random.nextInt(4901)); // Tempo de consumo entre 100 e 5000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}